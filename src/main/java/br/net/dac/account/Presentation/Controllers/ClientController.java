package br.net.dac.account.Presentation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetails;
import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetailsQuery;
import br.net.dac.account.Application.Services.Client.Queries.Handler.IClientQueriesHandler;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionHistoryResult;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionsHistoryQuery;
import br.net.dac.account.Presentation.Contracts.Client.TransactionHistoryRequest;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    IClientQueriesHandler _clientQueriesHandler;

    @GetMapping("{cpf}/transactionsHistory")
    public ResponseEntity<TransactionHistoryResult> transactionsHistory(@PathVariable("cpf") String cpf,
            @RequestBody TransactionHistoryRequest request) {
        try {
            TransactionsHistoryQuery query = new TransactionsHistoryQuery(
                    cpf,
                    request.getStarDate(),
                    request.getEndDate());

            TransactionHistoryResult transactionHistory = _clientQueriesHandler.getTransactionsHistory(query);

            return ResponseEntity.status(200).body(transactionHistory);
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{cpf}/clientDetails")
    public ResponseEntity<ClientDetails> clientDetails(@PathVariable("cpf") String cpf) {
        try{
            ClientDetailsQuery query = new ClientDetailsQuery(cpf);

            ClientDetails clientDetails = _clientQueriesHandler.getClientDetails(query);

            return ResponseEntity.status(200).body(clientDetails);

        } catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
        
    }

}
