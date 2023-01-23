package br.net.dac.account.Domain.Entities;

import java.util.Date;

import br.net.dac.account.Domain.Enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    private Client client;

    private Manager manager;

    private Date creationDate;

    private Double limit;

    private Double balance;

    private Double wage;

    @Enumerated(EnumType.STRING)
    private Status status;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    
}
