package com.java_test.javaSpringboot.Services;

import com.java_test.javaSpringboot.Models.AccountHolder;
import com.java_test.javaSpringboot.repositeries.Accountholder_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class Accountholder_Service {
@Autowired
    Accountholder_Repo accounthrepo;
public AccountHolder createaccountholder(AccountHolder accounholder){
    AccountHolder saveaccount = accounthrepo.save(accounholder);
    return saveaccount;
}
public AccountHolder getaccount(UUID id ) throws Exception {
    Optional<AccountHolder> accounth = accounthrepo.findById(id);
    if(accounth.isPresent()){
        AccountHolder ah = accounth.get();
        return ah;
    }
    else{
        throw new Exception();
    }
}
public AccountHolder updateaccount(AccountHolder account){
    return accounthrepo.save(account);
}
public void deleteaccount(UUID acounthid){
    accounthrepo.deleteById(acounthid);
}
}
