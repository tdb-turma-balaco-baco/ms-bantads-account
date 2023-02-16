package br.net.dac.account.Application.Services.Client.Queries.Handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetails;
import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetailsQuery;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionHistoryResult;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionsHistoryQuery;
import br.net.dac.account.Domain.Entities.Read.AccountDetails;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesRead.AccountReadRepository;

@Service
public class ClientQueriesHandler implements IClientQueriesHandler {

    AccountReadRepository _accountRepository;

    @Override
    public TransactionHistoryResult getTransactionsHistory(TransactionsHistoryQuery query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClientDetails getClientDetails(ClientDetailsQuery query) {
        AccountDetails account = _accountRepository.findByClientCpf(query.getCpf());
        ClientDetails client = mapEntityToDTOResult(account);
        return client;
    }

    @Override
    public List<ClientDetails> getAllClients() {
        List<AccountDetails> accounts = _accountRepository.findAllByOrderByClientNameDesc();

        List<ClientDetails> clients = new ArrayList<>();

        for (AccountDetails account : accounts) {
            ClientDetails client = mapEntityToDTOResult(account);
            clients.add(client);
        }
        return clients;
    }

    private ClientDetails mapEntityToDTOResult(AccountDetails account){
        ClientDetails client = new ClientDetails();
        client.setBalance(account.getBalance());
        client.setCpf(account.getClientCpf());
        client.setLimit(account.getLimit());
        client.setManagerName(account.getManagerName());
        client.setName(account.getClientName());
        return client;
    }
    
}
