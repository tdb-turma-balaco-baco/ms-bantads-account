package br.net.dac.account.Domain.Events;

import br.net.dac.account.Domain.Enums.Status;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class ChangedStatusAccountEvent extends DomainEvent{
    private String cpf;
    private String email;
    private Status status;
    private String statusReason;
    
    public ChangedStatusAccountEvent(String cpf, String email, Status status, String statusReason) {
        this.cpf = cpf;
        this.email = email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
