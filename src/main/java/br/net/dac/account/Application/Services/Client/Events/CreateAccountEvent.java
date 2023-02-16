package br.net.dac.account.Application.Services.Client.Events;

public class CreateAccountEvent {
    private String clientName;
    private String clientCpf;
    private String clientEmail;
    private String managerCpf;
    private String managerName;
    private Double wage;
    
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getClientCpf() {
        return clientCpf;
    }
    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }
    public String getClientEmail() {
        return clientEmail;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public String getManagerCpf() {
        return managerCpf;
    }
    public void setManagerCpf(String managerCpf) {
        this.managerCpf = managerCpf;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public Double getWage() {
        return wage;
    }
    public void setWage(Double wage) {
        this.wage = wage;
    }

    
}
