package br.net.dac.account.Domain.Events.SyncDataBase;

import br.net.dac.account.Domain.Entities.Write.Account;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class SyncStatusAccountEvent extends DomainEvent{
    private Account account;

    public SyncStatusAccountEvent(Account account) {
        this.account = account;
    }

    public SyncStatusAccountEvent() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    
}
