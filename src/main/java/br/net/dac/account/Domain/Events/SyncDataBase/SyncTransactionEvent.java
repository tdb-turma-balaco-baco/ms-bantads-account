package br.net.dac.account.Domain.Events.SyncDataBase;

import br.net.dac.account.Domain.Entities.Write.Transaction;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class SyncTransactionEvent extends DomainEvent{
    private Transaction transaction;
    private Double newBalanceAccount;
    private Double newBalanceDestinationAccount;
    private String clientName;
    private String destinationClientName;

    public SyncTransactionEvent(Transaction transaction, Double newBalanceAccount, Double newBalanceDestinationAccount,
            String clientName, String destinationClientName) {
        this.transaction = transaction;
        this.newBalanceAccount = newBalanceAccount;
        this.newBalanceDestinationAccount = newBalanceDestinationAccount;
        this.clientName = clientName;
        this.destinationClientName = destinationClientName;
    }

    public SyncTransactionEvent(Transaction transaction, Double newBalanceAccount, String clientName) {
        this.transaction = transaction;
        this.newBalanceAccount = newBalanceAccount;
        this.clientName = clientName;
    }

    public SyncTransactionEvent() {
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Double getNewBalanceAccount() {
        return newBalanceAccount;
    }

    public void setNewBalanceAccount(Double newBalanceAccount) {
        this.newBalanceAccount = newBalanceAccount;
    }

    public Double getNewBalanceDestinationAccount() {
        return newBalanceDestinationAccount;
    }

    public void setNewBalanceDestinationAccount(Double newBalanceDestinationAccount) {
        this.newBalanceDestinationAccount = newBalanceDestinationAccount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDestinationClientName() {
        return destinationClientName;
    }

    public void setDestinationClientName(String destinationClientName) {
        this.destinationClientName = destinationClientName;
    }

}
