package br.net.dac.account.Application.Services.Manager.Queries.Handler;

import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceResult;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClientsResult;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccountsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccountsResult;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopFiveClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopFiveClientsResult;

public interface IManagerQueriesHandler {
    ClientsBalanceResult getClientsBalance(ClientsBalanceQuery query);

    ManagerClientsResult getManagerClients(ManagerClientsQuery query);

    PendingAccountsResult getPendingAccounts(PendingAccountsQuery query);

    TopFiveClientsResult getTopFiveClients(TopFiveClientsQuery query);
}
