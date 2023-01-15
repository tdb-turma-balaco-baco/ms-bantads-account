package br.net.dac.account.Presentation.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Test {
    
    @GetMapping("/teste")
    public ResponseEntity<String> getTeste(){
        return ResponseEntity.status(200).body("Boa!");
    }
}
