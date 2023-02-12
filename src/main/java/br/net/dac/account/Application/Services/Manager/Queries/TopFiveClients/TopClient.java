package br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients;

public class TopClient {
    private String cpf;
    private String name;
    private Double balance;
    
    public TopClient(String cpf, String name, Double balance) {
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
