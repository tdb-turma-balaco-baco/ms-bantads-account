package br.net.dac.account.Application.Services.SyncDatabase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.dac.account.Domain.Entities.Read.AccountDetails;
import br.net.dac.account.Domain.Entities.Read.TransactionDetails;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncStatusAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncSwapAllAcountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncSwapOneAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncTransactionEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncUpdateAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncUpdateManagerEvent;
import br.net.dac.account.Domain.Exceptions.AccountNotFoundException;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesRead.AccountReadRepository;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesRead.TransactionReadRepository;

@Service
public class SyncHandler implements ISyncHandler{

    @Autowired
    AccountReadRepository _accountReadRepository;

    @Autowired
    TransactionReadRepository _transactionReadRepository;

    @Override
    public void syncCreateAccount(SyncAccountEvent event) {
        AccountDetails account = mapToEntity(event);
        _accountReadRepository.saveAndFlush(account);
    }

    
    @Override
    public void syncUpdateAccount(SyncUpdateAccountEvent event) {
        Optional<AccountDetails> account = _accountReadRepository.findById(event.getAccount().getAccountNumber());

        if(!account.isPresent()) throw new AccountNotFoundException();

        AccountDetails accountSync = account.get();
        accountSync.setWage(event.getAccount().getWage());
        accountSync.setClientName(event.getAccount().getClient().getName());
        accountSync.setClientEmail(event.getAccount().getClient().getEmail());
        accountSync.setLimit(event.getAccount().getLimit());

        _accountReadRepository.saveAndFlush(accountSync);
    }

    @Override
    public void syncUpdateStatus(SyncStatusAccountEvent event) {
        Optional<AccountDetails> account = _accountReadRepository.findById(event.getAccount().getAccountNumber());

        if(!account.isPresent()) throw new AccountNotFoundException();

        AccountDetails accountSync = account.get();
        accountSync.setStatus(event.getAccount().getStatus());
        accountSync.setStatusReason(event.getAccount().getStatusReason());
        accountSync.setUpdatedDate(event.getAccount().getUpdatedDate());

        _accountReadRepository.saveAndFlush(accountSync);
    }

    @Override
    public void syncUpdateManager(SyncUpdateManagerEvent event) {
        List<AccountDetails> accounts = _accountReadRepository.findAllByManagerCpf(event.getManager().getCpf());

        for (AccountDetails account : accounts) {
            account.setManagerName(event.getManager().getName());
        }

        _accountReadRepository.saveAllAndFlush(accounts);
        
    }

    @Override
    public void syncSwapAllAcount(SyncSwapAllAcountEvent event) {
        List<AccountDetails> accounts = _accountReadRepository.findAllByManagerCpf(event.getOldManagercpf());
        for (AccountDetails account : accounts) {
            account.setManagerName(event.getManager().getName());
            account.setManagerCpf(event.getManager().getCpf());
        }

        _accountReadRepository.saveAllAndFlush(accounts);
    }

    @Override
    public void syncSwapOneAcount(SyncSwapOneAccountEvent event) {
        Optional<AccountDetails> account = _accountReadRepository.findById(event.getAccount().getAccountNumber());

        if(!account.isPresent()) throw new AccountNotFoundException();

        AccountDetails accountSync = account.get();
        accountSync.setManagerCpf(event.getAccount().getManager().getCpf());
        accountSync.setManagerName(event.getAccount().getManager().getName());

        _accountReadRepository.saveAndFlush(accountSync);
        
    }

    @Override
    public void syncTransaction(SyncTransactionEvent event) {
        switch(event.getTransaction().getOperationType()){
            case DEPOSIT:
            case WITHDRAW:
                updateBalanceAccount(event.getTransaction().getSourceAccount(), event.getNewBalanceAccount());
            break;
            case TRANFER:
                updateBalanceAccount(event.getTransaction().getSourceAccount(), event.getNewBalanceAccount());
                updateBalanceAccount(event.getTransaction().getDestinationAccount(), event.getNewBalanceDestinationAccount());
            break;
        }

        _accountReadRepository.flush();
        
        TransactionDetails transaction = mapToTransferEntity(event);
        _transactionReadRepository.saveAndFlush(transaction);
    }

    private AccountDetails mapToEntity(SyncAccountEvent event) {
        AccountDetails account = new AccountDetails();
        account.setAccountNumber(event.getAccount().getAccountNumber());
        account.setBalance(event.getAccount().getBalance());
        account.setClientCpf(event.getAccount().getClient().getCpf());
        account.setClientEmail(event.getAccount().getClient().getEmail());
        account.setClientName(event.getAccount().getClient().getName());
        account.setCreationDate(event.getAccount().getCreationDate());
        account.setLimit(event.getAccount().getLimit());
        account.setManagerCpf(event.getAccount().getManager().getCpf());
        account.setManagerName(event.getAccount().getManager().getName());
        account.setStatus(event.getAccount().getStatus());
        account.setStatusReason(event.getAccount().getStatusReason());
        account.setUpdatedDate(event.getAccount().getUpdatedDate());
        account.setWage(event.getAccount().getWage());
        return account;
    }

    private TransactionDetails mapToTransferEntity(SyncTransactionEvent event)
    {
        TransactionDetails transaction = new TransactionDetails();
        transaction.setDestinationAccount(event.getTransaction().getDestinationAccount());
        transaction.setId(event.getTransaction().getId());
        transaction.setOperationDate(event.getTransaction().getOperationDate());
        transaction.setOperationType(event.getTransaction().getOperationType());
        transaction.setPreviousBalance(event.getTransaction().getPreviousBalance());
        transaction.setSourceAccount(event.getTransaction().getSourceAccount());
        transaction.setValue(event.getTransaction().getValue());
        transaction.setDestinationClientName(event.getDestinationClientName());
        transaction.setSourceClientName(event.getClientName());
        return transaction;
    }

    private void updateBalanceAccount(Long accountId, Double totalValue)
    {
        AccountDetails account = _accountReadRepository.findById(accountId).get();
        account.setBalance(totalValue);
        _accountReadRepository.save(account);
    }

    
}
