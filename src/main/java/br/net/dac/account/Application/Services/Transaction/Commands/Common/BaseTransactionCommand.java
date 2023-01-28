package br.net.dac.account.Application.Services.Transaction.Commands.Common;

import br.net.dac.account.Domain.Enums.Operation;

public abstract class BaseTransactionCommand {

    protected double amount;
    protected Long accountId;
    protected Operation operation;
    
    public BaseTransactionCommand(double amount, Long accountId, Operation operation) {
        this.amount = amount;
        this.accountId = accountId;
        this.operation = operation;
    }
    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
}
