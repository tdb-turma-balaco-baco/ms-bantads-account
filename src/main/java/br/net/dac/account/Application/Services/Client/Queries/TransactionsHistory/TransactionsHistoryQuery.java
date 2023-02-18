package br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory;

import java.util.Date;

public class TransactionsHistoryQuery {
    
    private Long accountId;
    private Date startDate;
    private Date endDate;
    
    public TransactionsHistoryQuery(Long accountId, Date startDate, Date endDate) {
        this.accountId = accountId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }


}
