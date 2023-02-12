package br.net.dac.account.Domain.Entities.Read;

import java.util.Date;

import br.net.dac.account.Domain.Enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

public class AccountDetails {
    
    @Id
    @Column(name = "accountNumber")
    private Long accountNumber;

    @Column(name = "clientName")
    private String clientName;

    @Column(name = "clientCpf")
    private String clientcpf;

    @Column(name = "clientEmail")
    private String clientEmail;

    @Column(name = "managerName")
    private String managerName;

    @Column(name = "managerCpf")
    private String managerCpf;

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

    public AccountDetails(Long accountNumber, String clientName, String clientcpf, String clientEmail,
            String managerName, String managerCpf, Date creationDate, Date updatedDate, Double limit, Double balance,
            Double wage, Status status, String statusReason) {
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.clientcpf = clientcpf;
        this.clientEmail = clientEmail;
        this.managerName = managerName;
        this.managerCpf = managerCpf;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
        this.limit = limit;
        this.balance = balance;
        this.wage = wage;
        this.status = status;
        this.statusReason = statusReason;
    }

    public AccountDetails() {
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientcpf() {
        return clientcpf;
    }

    public void setClientcpf(String clientcpf) {
        this.clientcpf = clientcpf;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerCpf() {
        return managerCpf;
    }

    public void setManagerCpf(String managerCpf) {
        this.managerCpf = managerCpf;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
