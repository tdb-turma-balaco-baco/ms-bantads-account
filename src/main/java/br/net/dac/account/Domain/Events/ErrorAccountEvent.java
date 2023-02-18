package br.net.dac.account.Domain.Events;

import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class ErrorAccountEvent extends DomainEvent {
    private String cpf;

    public ErrorAccountEvent(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
