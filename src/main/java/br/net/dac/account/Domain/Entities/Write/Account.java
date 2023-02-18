package br.net.dac.account.Domain.Entities.Write;

import java.util.Date;

import br.net.dac.account.Domain.Enums.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountNumber")
    private Long accountNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "managerId")
    private Manager manager;

    @Column(name = "creationDate")
    private Date creationDate;
    
    @Column(name = "updatedDate")
    private Date updatedDate;
    
    @Column(name = "account_limit")
    private Double limit;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "wage")
    private Double wage;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "statusReason")
    private String statusReason;

    public Account(Long accountNumber, Client client, Manager manager, Date creationDate, Double limit, Double balance,
            Double wage, Status status, String statusReason) {
        this.accountNumber = accountNumber;
        this.client = client;
        this.manager = manager;
        this.creationDate = creationDate;
        this.limit = limit;
        this.balance = balance;
        this.wage = wage;
        this.status = status;
        this.statusReason = statusReason;
    }

    public Account() {
    }


    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
        calculateAccountLimit();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    private void calculateAccountLimit()
    {
        this.limit = this.wage >= 2000.0 ? (this.wage / 2) : 0.0;
    }

    public Double maxOperationValue(){
        return this.balance + this.limit;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    
}
