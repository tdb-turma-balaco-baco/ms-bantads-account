package br.net.dac.account.Presentation.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ClientsBalance.ClientsBalanceResult;
import br.net.dac.account.Application.Services.Manager.Queries.Handler.IManagerQueriesHandler;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.ManagerClients.ManagerClientsResult;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccountsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.PendingAccounts.PendingAccount;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopFiveClientsQuery;
import br.net.dac.account.Application.Services.Manager.Queries.TopFiveClients.TopClient;

@CrossOrigin
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    IManagerQueriesHandler _managerQueriesHandler;

    @GetMapping("/{cpf}/pendingAccounts")
    public ResponseEntity<List<PendingAccount>> pendingAccounts(@PathVariable("cpf") String managerCpf) {
        try {
            PendingAccountsQuery query = new PendingAccountsQuery(managerCpf);
            List<PendingAccount> result = _managerQueriesHandler.getPendingAccounts(query);
            return ResponseEntity.status(200).body(result);
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{cpf}/clients")
    public ResponseEntity<ManagerClientsResult> getClients(@PathVariable("cpf") String managerCpf) {
        try {
            ManagerClientsQuery query = new ManagerClientsQuery(managerCpf);
            ManagerClientsResult result = _managerQueriesHandler.getManagerClients(query);
            return ResponseEntity.status(200).body(result);
        } catch (Exception ex) { //Mudar dps
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{cpf}/topFiveClients")
    public ResponseEntity<List<TopClient>> getTopFiveClients(@PathVariable("cpf") String managerCpf) {
        try {
            TopFiveClientsQuery query = new TopFiveClientsQuery(managerCpf);
            List<TopClient> result = _managerQueriesHandler.getTopFiveClients(query);
            return ResponseEntity.status(200).body(result);
        } catch (Exception ex) { 
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{cpf}/clientsBalance")
    public ResponseEntity<ClientsBalanceResult> clientsBalance(@PathVariable("cpf") String managerCpf) {
        try {
            ClientsBalanceQuery query = new ClientsBalanceQuery(managerCpf);
            ClientsBalanceResult result = _managerQueriesHandler.getClientsBalance(query);
            return ResponseEntity.status(200).body(result);
        } catch (Exception ex) { //Mudar dps
            return ResponseEntity.status(500).build();
        }
    }

}
