package br.net.dac.account.Application.Services.Client.Queries.Handler;

import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetailsQuery;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionsHistoryQuery;

public interface IClientQueriesHandler {
    
    String getTransactionsHistory(TransactionsHistoryQuery query);

    String getClientDetails(ClientDetailsQuery query);
}
