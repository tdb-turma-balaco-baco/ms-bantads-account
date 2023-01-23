package br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory;

import java.util.Date;

public class TransactionsHistoryQuery {
    
    private String cpf;
    private Date startDate;
    private Date endDate;

    public TransactionsHistoryQuery(String cpf, Date startDate, Date endDate) {
        this.cpf = cpf;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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


}
