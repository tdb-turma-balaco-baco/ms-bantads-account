package br.net.dac.account.Presentation.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

    @GetMapping("{cpf}/transactionsHistory")
    public ResponseEntity<?> transactionsHistory(@PathVariable("cpf") String cpf){
        //CPF + StartDate + EndDate
        return ResponseEntity.ok("");

    }

    @GetMapping("/{cpf}/accountDetails")
    public ResponseEntity<?> accountDetails(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok(cpf);
    }
    
}
