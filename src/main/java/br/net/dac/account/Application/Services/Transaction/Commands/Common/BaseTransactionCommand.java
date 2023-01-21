package br.net.dac.account.Application.Services.Transactions.Commands.Common;

public abstract class BaseTransactionCommand {
    
    protected double amount;
    protected int accountId;
    
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
