package com.java_test.javaSpringboot.Controller;

import com.java_test.javaSpringboot.Models.Acount_Card;
import com.java_test.javaSpringboot.Services.Account_card_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("Account_Card")
public class AccountCard {
    @Autowired
    Account_card_Service ACS;
    @PostMapping("create_A_C/{acountid}/{cardid}")
    public ResponseEntity<UUID> createaccountcard(@PathVariable UUID acountid, @PathVariable UUID cardid) throws Exception {
     return  new ResponseEntity<>(ACS.Linkaccountcard(acountid,cardid), HttpStatus.CREATED);


    }
    @GetMapping("/get_accountCard/{accountcardid}")
    public ResponseEntity<UUID> getaccountcard(@PathVariable UUID accountcardid){
        return  new ResponseEntity<>( ACS.getcardbyid(accountcardid).get().getId(),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteaccount(UUID id) throws Exception {
        ACS.UNLINKACCOUNTCARD(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
