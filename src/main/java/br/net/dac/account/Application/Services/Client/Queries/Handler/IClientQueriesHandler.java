package br.net.dac.account.Application.Services.Client.Queries.Handler;

import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetails;
import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetailsQuery;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionHistoryResult;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionsHistoryQuery;

public interface IClientQueriesHandler {
    
    TransactionHistoryResult getTransactionsHistory(TransactionsHistoryQuery query);

    ClientDetails getClientDetails(ClientDetailsQuery query);
}
