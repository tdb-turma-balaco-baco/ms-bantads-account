package br.net.dac.account.Application.Services.Manager.Commands.UpdateManager;

public class UpdateManagerCommand {
    private String cpf;
    private String name;

    public UpdateManagerCommand(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }
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
