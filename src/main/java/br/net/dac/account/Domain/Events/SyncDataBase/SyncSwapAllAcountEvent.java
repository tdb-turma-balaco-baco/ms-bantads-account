package br.net.dac.account.Domain.Events.SyncDataBase;

import br.net.dac.account.Domain.Entities.Write.Manager;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class SyncSwapAllAcountEvent extends DomainEvent{
    private Manager manager;
    private String oldManagercpf;
    
    public SyncSwapAllAcountEvent(Manager manager, String oldManagercpf) {
        this.manager = manager;
        this.oldManagercpf = oldManagercpf;
    }
    
    public SyncSwapAllAcountEvent() {
    }

    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public String getOldManagercpf() {
        return oldManagercpf;
    }
    public void setOldManagercpf(String oldManagercpf) {
        this.oldManagercpf = oldManagercpf;
    }

    

}
