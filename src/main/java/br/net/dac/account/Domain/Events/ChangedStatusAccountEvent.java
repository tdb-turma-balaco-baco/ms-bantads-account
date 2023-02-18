package br.net.dac.account.Domain.Events;

import br.net.dac.account.Domain.Enums.Status;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class ChangedStatusAccountEvent extends DomainEvent{
    private String cpf;
    private Status status;
    private String statusReason;
    
    public ChangedStatusAccountEvent(String cpf, Status status, String statusReason) {
        this.cpf = cpf;
        this.status = status;
        this.statusReason = statusReason;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String getStatusReason() {
        return statusReason;
    }
    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    
}
