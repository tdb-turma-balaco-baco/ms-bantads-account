package br.net.dac.account.Application.Services.Client.Events;

public class UpdateStatusAccountEvent {
    private long accountNumber;
    private boolean approved;
    private String statusReason;
    
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public boolean isApproved() {
        return approved;
    }
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    public String getStatusReason() {
        return statusReason;
    }
    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    
}
