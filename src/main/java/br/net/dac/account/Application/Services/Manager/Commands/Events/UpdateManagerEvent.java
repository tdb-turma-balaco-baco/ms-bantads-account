package br.net.dac.account.Application.Services.Manager.Commands.Events;

public class UpdateManagerEvent {
    private String cpf;
    private String name;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
