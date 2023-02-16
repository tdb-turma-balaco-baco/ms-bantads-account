package br.net.dac.account.Application.Services.Manager.Commands.Events;

public class SwapManagerEvent {
    private String oldManagerCpf;
    private String cpf;
    private String name;
    private boolean swapAll;

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
    public boolean isSwapAll() {
        return swapAll;
    }
    public void setSwapAll(boolean swapAll) {
        this.swapAll = swapAll;
    }
    
}
