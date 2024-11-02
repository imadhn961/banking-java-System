package com.java_test.javaSpringboot.Services;

import com.java_test.javaSpringboot.Models.Account;
import com.java_test.javaSpringboot.Models.Acount_Card;
import com.java_test.javaSpringboot.Models.Card;
import com.java_test.javaSpringboot.repositeries.ACREPO;
import com.java_test.javaSpringboot.repositeries.AccountRepo;
import com.java_test.javaSpringboot.repositeries.cardRipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class Account_card_Service {
@Autowired
    ACREPO AccountCard;
@Autowired
AccountRepo AR;
@Autowired
cardRipo CR;
public UUID Linkaccountcard(UUID accountid, UUID cardid) throws Exception{
    Optional<Account> account = AR.findById(accountid);
    Optional<Card> card =CR.findById(cardid);
    if(!account.isPresent() || !card.isPresent()){
        throw new Exception();
    }
    Acount_Card accountcard = new Acount_Card();
    accountcard.setAccount(account.get());
    accountcard.setCard(card.get());
    Acount_Card saveACCOUNTCARD =AccountCard.save(accountcard);
    return saveACCOUNTCARD.getId();


}
public void UNLINKACCOUNTCARD(UUID Accountcardid) throws Exception {
        Optional<Acount_Card> account = AccountCard.findById(Accountcardid);
        if(!account.isPresent()){
            throw new Exception();
        }
        AccountCard.deleteById(account.get().getId());
}
    public UUID Updateaccountcard(UUID accountid, UUID cardid) throws Exception{
        Optional<Account> account = AR.findById(accountid);
        Optional<Card> card =CR.findById(cardid);
        if(!account.isPresent() || !card.isPresent()){
            throw new Exception();
        }
        Acount_Card accountcard = new Acount_Card();
        accountcard.setAccount(account.get());
        accountcard.setCard(card.get());
        Acount_Card saveACCOUNTCARD =AccountCard.save(accountcard);
        return saveACCOUNTCARD.getId();


    }
    public Optional<Acount_Card> getcardbyid (UUID id){
        return AccountCard.findById(id);
    }

}
