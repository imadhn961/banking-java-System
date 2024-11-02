package com.java_test.javaSpringboot.Controller;

import com.java_test.javaSpringboot.Models.AccountHolder;
import com.java_test.javaSpringboot.Services.Accountholder_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/account-holder")
public class accountholdercontroller {
    @Autowired
    Accountholder_Service AHS;
    @PostMapping("create-account-holder")
    public ResponseEntity<AccountHolder> createAccountholder(@RequestBody AccountHolder accountholder){
        return new ResponseEntity<>(AHS.createaccountholder(accountholder), HttpStatus.CREATED);
    }
   @GetMapping ("get-account-holder/{id}")
    public ResponseEntity<AccountHolder> getaccount(@PathVariable UUID id) throws Exception{
       AccountHolder getah = AHS.getaccount(id);
       return new ResponseEntity<>(getah ,HttpStatus.FOUND);

   }
   @DeleteMapping("delet_account/{id}")
    public ResponseEntity<Void>  deleteccount(@PathVariable UUID id){
        AHS.deleteaccount(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
   }


}
