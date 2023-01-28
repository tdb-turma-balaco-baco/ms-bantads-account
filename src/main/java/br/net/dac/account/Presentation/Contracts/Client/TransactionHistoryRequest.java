package br.net.dac.account.Presentation.Contracts.Client;

import java.util.Date;

public class TransactionHistoryRequest {
    private Date starDate;
    private Date endDate;
    
    public Date getStarDate() {
        return starDate;
    }
    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
}
