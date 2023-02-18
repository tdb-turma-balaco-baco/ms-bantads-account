package br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance;

public class ClientsBalanceResult {
    private Double totalPositiveBalance;
    private Double totalNegativeBalance;

    public ClientsBalanceResult(Double totalPositiveBalance, Double totalNegativeBalance) {
        this.totalPositiveBalance = totalPositiveBalance;
        this.totalNegativeBalance = totalNegativeBalance;
    }
    public Double getTotalPositiveBalance() {
        return totalPositiveBalance;
    }
    public void setTotalPositiveBalance(Double totalPositiveBalance) {
        this.totalPositiveBalance = totalPositiveBalance;
    }
    public Double getTotalNegativeBalance() {
        return totalNegativeBalance;
    }
    public void setTotalNegativeBalance(Double totalNegativeBalance) {
        this.totalNegativeBalance = totalNegativeBalance;
    }

    
}
