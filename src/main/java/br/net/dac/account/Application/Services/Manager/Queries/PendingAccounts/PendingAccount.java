package br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts;

public class PendingAccount {
    private long accountNumber;
    private String cpf;
    private String name;
    private Double wage;
    
    public PendingAccount(long accountNumber, String cpf, String name, Double wage) {
        this.accountNumber = accountNumber;
        this.cpf = cpf;
        this.name = name;
        this.wage = wage;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
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
    public Double getWage() {
        return wage;
    }
    public void setWage(Double wage) {
        this.wage = wage;
    }

   

    
}
