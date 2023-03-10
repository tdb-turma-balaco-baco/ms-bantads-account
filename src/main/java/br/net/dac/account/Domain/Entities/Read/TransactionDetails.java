package br.net.dac.account.Domain.Entities.Read;

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
public class TransactionDetails {
    
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "value")
    private Double value;

    @Column(name = "operationDate")
    private Date operationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "operationType")
    private Operation operationType;

    @Column(name = "sourceAccount")
    private Long sourceAccount;

    @Column(name = "sourceClientName")
    private String sourceClientName;

    @Column(name = "destinationAccount", nullable = true)
    private Long destinationAccount;

    @Column(name = "destinationClientName", nullable = true)
    private String destinationClientName;

    @Column(name = "previousBalance")
    private Double previousBalance;

    public TransactionDetails() {
    }

    public TransactionDetails(UUID id, Double value, Date operationDate, Operation operationType, Long sourceAccount,
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

    public Double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(Double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public Double balaceAfterTransaction(){
        if(operationType == Operation.DEPOSIT)
        {
            return this.previousBalance + this.value;
        }
        else
        {
            return this.previousBalance - this.value;
        }
    }

    public String getSourceClientName() {
        return sourceClientName;
    }

    public void setSourceClientName(String sourceClientName) {
        this.sourceClientName = sourceClientName;
    }

    public String getDestinationClientName() {
        return destinationClientName;
    }

    public void setDestinationClientName(String destinationClientName) {
        this.destinationClientName = destinationClientName;
    }
    
}
