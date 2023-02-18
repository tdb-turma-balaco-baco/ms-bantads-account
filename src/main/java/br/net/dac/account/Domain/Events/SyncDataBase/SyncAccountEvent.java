package br.net.dac.account.Domain.Events.SyncDataBase;

import br.net.dac.account.Domain.Entities.Write.Account;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class SyncAccountEvent extends DomainEvent {
    private Account account;

    public SyncAccountEvent(Account account) {
        this.account = account;
    }

    public SyncAccountEvent() {
    }
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    
}
