package br.net.dac.account.Application.Services.Manager.Queries.Handler;

import java.util.List;

import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceResult;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClient;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccountsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccount;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopFiveClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopClient;

public interface IManagerQueriesHandler {
    ClientsBalanceResult getClientsBalance(ClientsBalanceQuery query);

    List<ManagerClient> getManagerClients(ManagerClientsQuery query);

    List<PendingAccount> getPendingAccounts(PendingAccountsQuery query);

    List<TopClient> getTopFiveClients(TopFiveClientsQuery query);
}
