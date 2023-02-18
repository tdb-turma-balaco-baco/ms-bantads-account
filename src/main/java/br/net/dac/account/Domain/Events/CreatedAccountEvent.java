package br.net.dac.account.Domain.Events;

import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class CreatedAccountEvent extends DomainEvent{
    private String email;
    private String name;
    private String cpf;
    
    public CreatedAccountEvent(String email, String name, String cpf) {
        this.email = email;
        this.name = name;
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
}
