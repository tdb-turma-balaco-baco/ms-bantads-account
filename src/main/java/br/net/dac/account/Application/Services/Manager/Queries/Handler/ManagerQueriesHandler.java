package br.net.dac.account.Application.Services.Manager.Queries.Handler;

import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceResult;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClientsResult;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccountsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccountsResult;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopFiveClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopFiveClientsResult;

@Service
public class ManagerQueriesHandler implements IManagerQueriesHandler {

    @Override
    public ClientsBalanceResult getClientsBalance(ClientsBalanceQuery query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ManagerClientsResult getManagerClients(ManagerClientsQuery query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PendingAccountsResult getPendingAccounts(PendingAccountsQuery query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TopFiveClientsResult getTopFiveClients(TopFiveClientsQuery query) {
        // TODO Auto-generated method stub
        return null;
    }

}
