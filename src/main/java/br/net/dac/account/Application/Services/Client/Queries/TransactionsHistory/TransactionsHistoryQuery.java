package br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory;

import java.time.LocalDate;

public class TransactionsHistoryQuery {
    
    private String cpf;
    private LocalDate startDate;
    private LocalDate endDate;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


}
