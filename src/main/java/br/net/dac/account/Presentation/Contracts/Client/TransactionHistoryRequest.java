package br.net.dac.account.Presentation.Contracts.Client;

import java.util.Date;

public class TransactionHistoryRequest {
    private Date startDate;
    private Date endDate;
    
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
}
