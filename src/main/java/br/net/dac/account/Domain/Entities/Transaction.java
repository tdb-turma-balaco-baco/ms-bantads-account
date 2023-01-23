package br.net.dac.account.Domain.Entities;

import java.util.Date;
import java.util.UUID;

import br.net.dac.account.Domain.Enums.Operation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    private UUID id;

    private Double value;

    private Date operationDate;

    @Enumerated(EnumType.STRING)
    private Operation operationType;

    @Column(name = "sourceAccount")
    private Long sourceAccount;

    @Column(name = "destinationAccount", nullable = true)
    private Long destinationAccount;

    private Double previousBalance;

    public Transaction(UUID id, Double value, Date operationDate, Operation operationType, Long sourceAccount,
            Long destinationAccount, Double previousBalance) {
        this.id = id;
        this.value = value;
        this.operationDate = operationDate;
        this.operationType = operationType;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.previousBalance = previousBalance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(Double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public void setOperationType(Operation operationType) {
        this.operationType = operationType;
    }

    public Long getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Long getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Long destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
