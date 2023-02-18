package br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory;

import java.util.Date;

import br.net.dac.account.Domain.Enums.Operation;

public class OperationHistory {
    private Operation operationType;
    private Double totalValue;
    private Date operationDate;
    private String sourceClient;
    private String destinationClient;
    
    public Operation getOperationType() {
        return operationType;
    }
    public void setOperationType(Operation operationType) {
        this.operationType = operationType;
    }
    public Double getTotalValue() {
        return totalValue;
    }
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
    public Date getOperationDate() {
        return operationDate;
    }
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }
    public String getSourceClient() {
        return sourceClient;
    }
    public void setSourceClient(String sourceClient) {
        this.sourceClient = sourceClient;
    }
    public String getDestinationClient() {
        return destinationClient;
    }
    public void setDestinationClient(String destinationClient) {
        this.destinationClient = destinationClient;
    }

    
}
