package br.net.dac.account.Application.Services.Transaction.Commands.Handler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.net.dac.account.Application.Services.Transaction.Commands.Common.BaseTransactionCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Deposit.DepositCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Transfer.TransferCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Withdraw.WithdrawCommand;
import br.net.dac.account.Domain.Entities.Transaction;
import br.net.dac.account.Domain.Exceptions.AccountNotFoundException;
import br.net.dac.account.Domain.Exceptions.InsufficientFundsException;
import br.net.dac.account.Infrastructure.Persistence.Repositories.AccountRepository;
import br.net.dac.account.Infrastructure.Persistence.Repositories.TransactionRepository;

public class TransactionCommandHandler implements ITransactionCommandHandler {

    @Autowired
    TransactionRepository _transactionRepository;

    @Autowired
    AccountRepository _accountRepository;

    @Override
    public void makeDeposit(DepositCommand deposit) throws AccountNotFoundException {

        ValidateAccountExist(deposit.getAccountId());

        Double balance = _accountRepository.getBalanceByAccountId(deposit.getAccountId());

        Transaction transaction = createTransaction(deposit, balance);

        _transactionRepository.save(transaction);

        //Update balance
        //Send event - balance and createTransaction
    }

    @Override
    public void makeWithdraw(WithdrawCommand withdraw){
        
        ValidateAccountExist(withdraw.getAccountId());

        Double balance = _accountRepository.getBalanceByAccountId(withdraw.getAccountId());

        ValidateSufficientFunds(withdraw.getAmount(), balance);

        Transaction transaction = createTransaction(withdraw, balance);

        _transactionRepository.save(transaction);
        
    }

    @Override
    public void makeTransfer(TransferCommand transfer){

        ValidateAccountExist(transfer.getAccountId());
        ValidateAccountExist(transfer.getDestinationAccountId());
        
        Double balance = _accountRepository.getBalanceByAccountId(transfer.getAccountId());
        
        ValidateSufficientFunds(transfer.getAmount(), balance);

        Transaction transaction = createTransaction(transfer, balance);
        transaction.setDestinationAccount(transaction.getDestinationAccount());

        _transactionRepository.save(transaction);
        
    }

    private Transaction createTransaction(BaseTransactionCommand command, Double balance){
        return new Transaction(
            UUID.randomUUID(),
            command.getAmount(),
            Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
            command.getOperation(),
            command.getAccountId(),
            null,
            balance
        );
    }

    private void ValidateAccountExist(Long accountId){
        if(_accountRepository.existsById(accountId) == false){      
            throw new AccountNotFoundException();
        };
    }

    private void ValidateSufficientFunds(Double operationValue, Double balanceAccount){
        if(operationValue > balanceAccount){      
            throw new InsufficientFundsException();
        };
    }
    
}
