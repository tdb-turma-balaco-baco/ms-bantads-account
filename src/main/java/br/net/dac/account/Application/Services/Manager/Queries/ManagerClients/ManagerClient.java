package br.net.dac.account.Application.Services.Manager.Queries.ManagerClients;

public class ManagerClient {
    private String cpf;
    private String name;
    private Double balance;
    
    public ManagerClient(String cpf, String name, Double balance) {
        this.cpf = cpf;
        this.name = name;
        this.balance = balance;
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
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    
}
