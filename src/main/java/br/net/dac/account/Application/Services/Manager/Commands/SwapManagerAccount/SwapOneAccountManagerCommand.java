package br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount;

public class SwapOneAccountManagerCommand {
    private String oldManagerCpf;
    private String cpf;
    private String name;
    
    public SwapOneAccountManagerCommand(String oldManagerCpf, String cpf, String name) {
        this.oldManagerCpf = oldManagerCpf;
        this.cpf = cpf;
        this.name = name;
    }
    public String getOldManagerCpf() {
        return oldManagerCpf;
    }
    public void setOldManagerCpf(String oldManagerCpf) {
        this.oldManagerCpf = oldManagerCpf;
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
