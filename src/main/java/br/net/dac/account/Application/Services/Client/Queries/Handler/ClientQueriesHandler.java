package br.net.dac.account.Application.Services.Client.Queries.Handler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetails;
import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetailsQuery;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.OperationHistory;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionHistoryResult;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionsHistoryQuery;
import br.net.dac.account.Domain.Entities.Read.AccountDetails;
import br.net.dac.account.Domain.Entities.Read.TransactionDetails;
import br.net.dac.account.Domain.Enums.Status;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesRead.AccountReadRepository;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesRead.TransactionReadRepository;

@Service
public class ClientQueriesHandler implements IClientQueriesHandler {

    @Autowired
    AccountReadRepository _accountRepository;

    @Autowired
    TransactionReadRepository _transactionReadRepository;

    @Override
    public List<TransactionHistoryResult> getTransactionsHistory(TransactionsHistoryQuery query) {
        List<TransactionDetails> transactionsHistory = _transactionReadRepository.findTransactionsByClientAndDate(query.getAccountId(),
                query.getStartDate(), query.getEndDate());

        LocalDate currentDt = LocalDate.ofInstant(query.getStartDate().toInstant(), ZoneId.systemDefault());
        LocalDate dtEnd = LocalDate.ofInstant(query.getEndDate().toInstant(), ZoneId.systemDefault());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        var transactionByDay = transactionsHistory.stream().collect(Collectors.groupingBy(t -> dateFormat.format(t.getOperationDate()), LinkedHashMap::new, Collectors.toList()));
        
        List<TransactionHistoryResult> transactionsHistoryResult = new ArrayList<>();
        Double lastBalance = 0.0;
        while(currentDt.isBefore(dtEnd))
        {
            TransactionHistoryResult transHistory = new TransactionHistoryResult();
            transHistory.setDay(currentDt);

            if(transactionByDay.containsKey(currentDt.toString()))
            {
                var transactions = transactionByDay.get(currentDt.toString());
                List<OperationHistory> operations = new ArrayList<>();
                for (TransactionDetails trans : transactions) 
                {
                    OperationHistory op = mapToOperationHistory(trans);
                    operations.add(op);
                }
                transHistory.setOperation(operations);

                TransactionDetails lastOperation = transactions.get(transactions.size() - 1);
                lastBalance = lastOperation.balaceAfterTransaction();
            }

            transHistory.setBalance(lastBalance);
            transactionsHistoryResult.add(transHistory);
            currentDt = currentDt.plusDays(1);
        }

        return transactionsHistoryResult;
    }

    @Override
    public ClientDetails getClientDetails(ClientDetailsQuery query) {
        AccountDetails account = _accountRepository.findByClientCpf(query.getCpf());
        ClientDetails client = mapEntityToDTOResult(account);
        return client;
    }

    @Override
    public List<ClientDetails> getAllClients() {
        List<AccountDetails> accounts = _accountRepository.findAllByStatusOrderByClientNameDesc(Status.APPROVED);

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

    private OperationHistory mapToOperationHistory(TransactionDetails trans) {
        OperationHistory op = new OperationHistory();
        op.setTotalValue(trans.getValue());
        op.setOperationDate(trans.getOperationDate());
        op.setOperationType(trans.getOperationType());
        op.setDestinationClient(trans.getDestinationClientName());
        op.setSourceClient(trans.getSourceClientName());
        return op;
    }
    
}
