package br.net.dac.account.Application.Services.Client.Queries.Handler;

import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetails;
import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetailsQuery;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionHistoryResult;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionsHistoryQuery;

@Service
public class ClientQueriesHandler implements IClientQueriesHandler {

    @Override
    public TransactionHistoryResult getTransactionsHistory(TransactionsHistoryQuery query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClientDetails getClientDetails(ClientDetailsQuery query) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
