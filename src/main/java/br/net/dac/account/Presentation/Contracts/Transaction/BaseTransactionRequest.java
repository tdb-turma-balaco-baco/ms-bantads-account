package br.net.dac.account.Presentation.Contracts.Transaction;

public abstract class BaseTransactionRequest {
    protected Long accountId;
    protected Double amount;
    
    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    
}
