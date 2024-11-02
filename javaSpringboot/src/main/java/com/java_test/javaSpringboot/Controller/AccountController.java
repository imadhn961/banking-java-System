package com.java_test.javaSpringboot.Controller;

import com.java_test.javaSpringboot.DTO.accountrequestdto;
import com.java_test.javaSpringboot.DTO.accountresponsedto;
import com.java_test.javaSpringboot.Models.Account;
import com.java_test.javaSpringboot.Models.AccountHolder;
import com.java_test.javaSpringboot.Services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    AccountService AS;
    @Autowired
    ModelMapper model;
    @PostMapping("create-account")
    public ResponseEntity<accountresponsedto> createAccount(@Valid @RequestBody accountrequestdto accountreqdto) throws Exception {
        /*Account account = new Account();
        account.setAccountholder(accountreqdto.getAccountholder());
        account.setBalance(accountreqdto.getBalance());
        account.setStatus(accountreqdto.getStatus());*/
        Account account = model.map(accountreqdto,Account.class);
        Account accountrepo = AS.createAccount(account);
        accountresponsedto accountres = model.map(accountrepo,accountresponsedto.class);
        accountres.setAccountholderid(accountrepo.getAccountholder().getId());

        /*accountres.setId(accountrepo.getId());
        accountres.setBalance(accountres.getBalance());
        accountres.setStatus(accountres.getStatus());*/
        return new ResponseEntity<>(accountres, HttpStatus.CREATED);
    }
    @GetMapping("get-account/{id}")
    public ResponseEntity<Account> getaccount(@PathVariable UUID id) throws Exception{
        Account geta = AS.getbyid(id);
        return new ResponseEntity<>(geta ,HttpStatus.FOUND);

    }
    @DeleteMapping("delete_account/{id}")
    public ResponseEntity<Void>  deleteccount(@PathVariable UUID id){
        AS.deleteaccount(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/update_account/{accountid}")
    public void updateaccount(@RequestBody Account account , @PathVariable UUID accountid) throws Exception {
          AS.updateaccount(account,accountid);


    }
    @PatchMapping("patch_account/{accountid}/{balance}")
    public ResponseEntity<Float> patchaccount(@PathVariable UUID accountid , @PathVariable Float balance) throws Exception {
        return  new ResponseEntity<>(AS.modifybalance(balance,accountid), HttpStatus.ACCEPTED);
    }

}
