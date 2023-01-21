package br.net.dac.account.Presentation.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(){
        return ResponseEntity.ok("");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(){
        return ResponseEntity.ok("");
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(){
        //DTO to Command
        //Send to Service
        //Return
        return ResponseEntity.ok("");
    }
}
