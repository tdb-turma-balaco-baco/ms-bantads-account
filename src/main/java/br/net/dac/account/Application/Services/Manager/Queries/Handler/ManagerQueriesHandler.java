package br.net.dac.account.Application.Services.Manager.Queries.Handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceResult;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClient;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccount;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccountsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopFiveClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopClient;
import br.net.dac.account.Domain.Entities.Read.AccountDetails;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesRead.AccountReadRepository;

@Service
public class ManagerQueriesHandler implements IManagerQueriesHandler {

    @Autowired
    AccountReadRepository _accountRepository;

    @Override
    public ClientsBalanceResult getClientsBalance(ClientsBalanceQuery query) {
        List<AccountDetails> managerClients = _accountRepository.findClientsManager(query.getCpf());

        Double totalPositiveBalance = managerClients.stream().mapToDouble(m -> m.getBalance()).filter(balance -> balance > 0.0).sum();
        Double totalNegativeBalance = managerClients.stream().mapToDouble(m -> m.getBalance()).filter(balance -> balance < 0.0).sum();

        ClientsBalanceResult clientsBalance =  new ClientsBalanceResult(totalPositiveBalance, totalNegativeBalance);

        return clientsBalance;
    }

    @Override
    public List<ManagerClient> getManagerClients(ManagerClientsQuery query) {
        List<AccountDetails> managerClients = _accountRepository.findClientsManager(query.getCpf());

        List<ManagerClient> managerClientsResult = new ArrayList<>();
        for (AccountDetails account : managerClients) {
            var client = new ManagerClient(account.getClientCpf(),
                                 account.getClientName(),
                                 account.getBalance());
        
            managerClientsResult.add(client);
        }

        return managerClientsResult;

    }

    @Override
    public List<PendingAccount> getPendingAccounts(PendingAccountsQuery query) {
        List<AccountDetails> pendingAccounts = _accountRepository.findPendingAccountByManagerCpf(query.getCpf());
       
        List<PendingAccount> pendingAccountsResult = new ArrayList<>();
        for (AccountDetails account : pendingAccounts) {
            var pendingAccount = new PendingAccount(account.getAccountNumber(),
                                 account.getClientCpf(),
                                 account.getClientName(),
                                 account.getWage());
        
            pendingAccountsResult.add(pendingAccount);
        }

        return pendingAccountsResult;
    }

    @Override
    public List<TopClient> getTopFiveClients(TopFiveClientsQuery query) {
        List<AccountDetails> topAccountClients = _accountRepository.findTopFiveClientsManager(query.getCpf());

        List<TopClient> topFiveClients = new ArrayList<>();
        for (AccountDetails client : topAccountClients) {
            var topClient = new TopClient(client.getClientCpf(),
             client.getClientName(), 
             client.getBalance());
        
             topFiveClients.add(topClient);
        }

        return topFiveClients;
    }

}
