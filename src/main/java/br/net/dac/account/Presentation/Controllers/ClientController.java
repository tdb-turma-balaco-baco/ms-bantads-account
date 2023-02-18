package br.net.dac.account.Presentation.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.dac.account.Application.Services.Client.Commands.CreateAccount.CreateAccountCommand;
import br.net.dac.account.Application.Services.Client.Commands.Handler.IClientCommandHandler;
import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetails;
import br.net.dac.account.Application.Services.Client.Queries.ClientDetails.ClientDetailsQuery;
import br.net.dac.account.Application.Services.Client.Queries.Handler.IClientQueriesHandler;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionHistoryResult;
import br.net.dac.account.Application.Services.Client.Queries.TransactionsHistory.TransactionsHistoryQuery;
import br.net.dac.account.Application.Services.Manager.Commands.Handler.IManagerCommandHandler;
import br.net.dac.account.Presentation.Contracts.Client.TransactionHistoryRequest;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    IClientQueriesHandler _clientQueriesHandler;
    
    @Autowired
    IClientCommandHandler _client;

    @Autowired
    IManagerCommandHandler _manager;

    @GetMapping("{accountNumber}/transactionsHistory")
    public ResponseEntity<List<TransactionHistoryResult>> transactionsHistory(@PathVariable("accountNumber") Long accountNumber,
            @RequestBody TransactionHistoryRequest request) {
        try {
            TransactionsHistoryQuery query = new TransactionsHistoryQuery(
                    accountNumber,
                    request.getStartDate(),
                    request.getEndDate());

            List<TransactionHistoryResult> transactionHistory = _clientQueriesHandler.getTransactionsHistory(query);

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
    
    @GetMapping("/list")
    public ResponseEntity<List<ClientDetails>> getAllCLients() {
        try{
            List<ClientDetails> clientDetails = _clientQueriesHandler.getAllClients();

            return ResponseEntity.status(200).body(clientDetails);

        } catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> teste(@RequestBody CreateAccountCommand command) {
        try{
            _client.createAccountClient(command);
            return ResponseEntity.status(200).body("ok");

        } catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
}
