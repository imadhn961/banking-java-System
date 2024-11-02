package com.java_test.javaSpringboot.Services;

import com.java_test.javaSpringboot.Models.Account;
import com.java_test.javaSpringboot.Models.AccountHolder;
import com.java_test.javaSpringboot.repositeries.AccountRepo;
import com.java_test.javaSpringboot.repositeries.Accountholder_Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class AccountService {
    @Autowired
    AccountRepo accountrepo;
    @Autowired
    Accountholder_Repo ahrepo;
    public Account createAccount(Account account) throws Exception {
        log.debug("creating account {}",account);
        log.debug("getting account holder by id {}", account.getAccountholder().getId());
     Optional <AccountHolder> aholder =ahrepo.findById(account.getAccountholder().getId());
     if(aholder.isPresent()){
      account.setAccountholder(aholder.get());
      Account savedAccount =  accountrepo.save(account);
      return savedAccount;
      }
     else {
         log.debug("account holder is not present{}");
         throw new Exception();
     }
    }

    public Account getbyid(UUID accountID) throws Exception {
        Optional<Account> acount = accountrepo.findById(accountID);
        if(acount.isPresent()){
            return acount.get();
        }
        else {
            throw new Exception();
        }
    }
    public Account updateaccount(Account account , UUID acccountID ) throws Exception {
        Optional<Account> acount = accountrepo.findById(acccountID);
        if(acount.isPresent()){
            account.setId(acccountID);
            return  accountrepo.save(account);
        }
        else {
            throw new Exception();
        }

    }
    public void deleteaccount(UUID aid){
     accountrepo.deleteById(aid);
    }
    public Float modifybalance(Float balance , UUID accountid ) throws Exception{
       Optional<Account> account  = accountrepo.findById(accountid);
       if(account.isPresent()){
           account.get().setBalance(balance);
           accountrepo.save(account.get());
           return account.get().getBalance();
       }
       else{
          throw new  Exception();
       }
    }

}
