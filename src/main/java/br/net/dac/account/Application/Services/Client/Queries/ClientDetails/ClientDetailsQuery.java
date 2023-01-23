package br.net.dac.account.Application.Services.Client.Queries.ClientDetails;

public class ClientDetailsQuery {
    
    private String cpf;

    public ClientDetailsQuery(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
