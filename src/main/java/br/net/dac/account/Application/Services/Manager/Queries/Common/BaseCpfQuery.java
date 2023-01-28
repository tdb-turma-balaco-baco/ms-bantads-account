package br.net.dac.account.Application.Services.Manager.Queries.Common;

public abstract class BaseCpfQuery {
    protected String cpf;

    public BaseCpfQuery(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
