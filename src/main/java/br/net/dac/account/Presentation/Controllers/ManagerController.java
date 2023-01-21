package br.net.dac.account.Presentation.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/manager")
public class ManagerController {
    
    @GetMapping("/{cpf}/pendingAccounts")
    public ResponseEntity<?> pendingAccounts(@PathVariable("cpf") String managerCpf){
        return ResponseEntity.ok(managerCpf);
    }

    @GetMapping("/{cpf}/clients")
    public ResponseEntity<?> getClients(@PathVariable("cpf") String managerCpf){
        return ResponseEntity.ok(managerCpf);
    }

    @GetMapping("/{cpf}/topFiveClients")
    public ResponseEntity<?> getTopFiveClients(@PathVariable("cpf") String managerCpf){
        return ResponseEntity.ok(managerCpf);
    }

    @GetMapping("/{cpf}/clientsBalance")
    public ResponseEntity<?> clientsBalance(@PathVariable("cpf") String managerCpf){
        return ResponseEntity.ok(managerCpf);
    }

}
