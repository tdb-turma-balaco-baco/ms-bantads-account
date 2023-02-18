package br.net.dac.account.Domain.Events.SyncDataBase;

import br.net.dac.account.Domain.Entities.Write.Account;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class SyncSwapOneAccountEvent extends DomainEvent {
    private Account account;

    public SyncSwapOneAccountEvent(Account account) {
        this.account = account;
    }

    public SyncSwapOneAccountEvent() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
}
