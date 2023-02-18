package br.net.dac.account.Application.Services.Transaction.Commands.Handler;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Abstractions.IMessageSender;
import br.net.dac.account.Application.Services.Transaction.Commands.Common.BaseTransactionCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Deposit.DepositCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Transfer.TransferCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Withdraw.WithdrawCommand;
import br.net.dac.account.Domain.Entities.Write.Account;
import br.net.dac.account.Domain.Entities.Write.Transaction;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncTransactionEvent;
import br.net.dac.account.Domain.Exceptions.AccountNotFoundException;
import br.net.dac.account.Domain.Exceptions.InsufficientFundsException;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite.AccountRepository;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite.TransactionRepository;

@Service
public class TransactionCommandHandler implements ITransactionCommandHandler {

    @Autowired
    TransactionRepository _transactionRepository;

    @Autowired
    AccountRepository _accountRepository;

    @Autowired
    IMessageSender _messageSender;

    @Override
    public void makeDeposit(DepositCommand deposit) throws AccountNotFoundException {

        ValidateAccountExist(deposit.getAccountId());

        Account account = _accountRepository.findById(deposit.getAccountId()).get();

        Transaction transaction = createTransaction(deposit, account.getBalance());

        transaction = _transactionRepository.saveAndFlush(transaction);

        Double totalValue = account.getBalance() + deposit.getAmount();
        updateBalanceAccount(account, totalValue);

        _messageSender.sendSyncEventMessage(new SyncTransactionEvent(transaction, totalValue, account.getClient().getName()));
    }

    @Override
    public void makeWithdraw(WithdrawCommand withdraw){
        
        ValidateAccountExist(withdraw.getAccountId());

        Account account = _accountRepository.findById(withdraw.getAccountId()).get();

        ValidateSufficientFunds(withdraw.getAmount(), account.maxOperationValue());

        Transaction transaction = createTransaction(withdraw, account.getBalance());

        transaction = _transactionRepository.saveAndFlush(transaction);

        Double totalValue = account.getBalance() - withdraw.getAmount();
        updateBalanceAccount(account, totalValue);
        
        _messageSender.sendSyncEventMessage(new SyncTransactionEvent(transaction, totalValue, account.getClient().getName()));
    }

    @Override
    public void makeTransfer(TransferCommand transfer){

        ValidateAccountExist(transfer.getAccountId());
        ValidateAccountExist(transfer.getDestinationAccountId());

        Account account = _accountRepository.findById(transfer.getAccountId()).get();

        ValidateSufficientFunds(transfer.getAmount(), account.maxOperationValue());

        Transaction transaction = createTransaction(transfer, account.getBalance());
        transaction.setDestinationAccount(transfer.getDestinationAccountId());

        transaction = _transactionRepository.saveAndFlush(transaction);

        Double totalValue = account.getBalance() - transfer.getAmount();
        updateBalanceAccount(account, totalValue);

        Account updatedDestinationAccount = updateBalanceDestinationAccount(transfer.getDestinationAccountId(), transfer.getAmount());

        _messageSender.sendSyncEventMessage(new SyncTransactionEvent(transaction,
                                                totalValue,
                                                updatedDestinationAccount.getBalance(),
                                                account.getClient().getName(),
                                                updatedDestinationAccount.getClient().getName())
                                            );
        
    }

    private Transaction createTransaction(BaseTransactionCommand command, Double balance){
        return new Transaction(
            UUID.randomUUID(),
            command.getAmount(),
            new Date(),
            command.getOperation(),
            command.getAccountId(),
            null,
            balance
        );
    }

    private void ValidateAccountExist(Long accountId){
        if(_accountRepository.existsApprovedAccountById(accountId) == false){      
            throw new AccountNotFoundException();
        };
    }

    private void ValidateSufficientFunds(Double operationValue, Double maxOperationValue){
        if(operationValue > maxOperationValue){      
            throw new InsufficientFundsException();
        };
    }

    private void updateBalanceAccount(Account account, Double totalValue) {
        account.setBalance(totalValue);
        _accountRepository.saveAndFlush(account);
    }

    private Account updateBalanceDestinationAccount(Long accountId, Double amount)
    {
        Account destinationAccount =_accountRepository.findById(accountId).get();   
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        _accountRepository.saveAndFlush(destinationAccount);
        return destinationAccount;
    }
    
}
