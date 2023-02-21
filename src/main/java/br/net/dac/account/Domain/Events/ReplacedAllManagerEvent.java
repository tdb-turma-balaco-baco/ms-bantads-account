package br.net.dac.account.Domain.Events;

import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class ReplacedAllManagerEvent extends DomainEvent{
    private String cpf;

    public ReplacedAllManagerEvent(String cpf) {
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
