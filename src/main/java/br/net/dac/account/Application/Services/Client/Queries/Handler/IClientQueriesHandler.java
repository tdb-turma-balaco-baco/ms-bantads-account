package br.net.dac.account.Application.Services.Client.Queries.Handler;

import java.util.List;

import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetails;
import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetailsQuery;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionHistoryResult;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionsHistoryQuery;

public interface IClientQueriesHandler {
    
    List<TransactionHistoryResult> getTransactionsHistory(TransactionsHistoryQuery query);

    ClientDetails getClientDetails(ClientDetailsQuery query);

    List<ClientDetails> getAllClients();
}
