package br.net.dac.account.Application.Services.Client.Commands.UpdateStatusAccount;

import br.net.dac.account.Domain.Enums.Status;

public class UpdateStatusAccountCommand {
    private long accountNumber;
    private Status status;
    private String statusReason;

    public UpdateStatusAccountCommand(long accountNumber, Status status, String statusReason) {
        this.accountNumber = accountNumber;
        this.status = status;
        this.statusReason = statusReason;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
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
