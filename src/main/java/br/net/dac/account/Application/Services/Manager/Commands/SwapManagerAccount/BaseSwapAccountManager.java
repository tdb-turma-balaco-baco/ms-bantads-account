package br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount;

public class BaseSwapAccountManager {
    protected String oldManagerCpf;
    protected String cpf;
    protected String name;

    public BaseSwapAccountManager(String oldManagerCpf, String cpf, String name) {
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
