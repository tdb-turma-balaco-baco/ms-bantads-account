package br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory;

import java.time.LocalDate;
import java.util.List;

public class TransactionHistoryResult {
    private LocalDate day;
    private Double balance;
    private List<OperationHistory> operations;

    public LocalDate getDay() {
        return day;
    }
    public void setDay(LocalDate day) {
        this.day = day;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public List<OperationHistory> getOperation() {
        return operations;
    }
    public void setOperation(List<OperationHistory> operation) {
        this.operations = operation;
    }

    
}
