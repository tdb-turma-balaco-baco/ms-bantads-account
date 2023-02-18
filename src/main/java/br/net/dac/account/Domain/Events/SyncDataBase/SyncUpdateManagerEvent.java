package br.net.dac.account.Domain.Events.SyncDataBase;

import br.net.dac.account.Domain.Entities.Write.Manager;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class SyncUpdateManagerEvent extends DomainEvent{
    private Manager manager;

    public SyncUpdateManagerEvent(Manager manager) {
        this.manager = manager;
    }

    public SyncUpdateManagerEvent() {
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    
    
}
