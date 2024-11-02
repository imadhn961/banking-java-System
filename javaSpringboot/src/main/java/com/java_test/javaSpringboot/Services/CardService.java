package com.java_test.javaSpringboot.Services;

import com.java_test.javaSpringboot.Models.Card;
import com.java_test.javaSpringboot.repositeries.cardRipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class CardService {
    @Autowired
    cardRipo cardrepo;
    public Card creatcard(){
        Card card = new Card();
        card.setExpirydate(LocalDate.now().plusYears(3));
        card.setCvv(String.valueOf(new Random().nextInt(999)+100));
        card.setCardnum(generatecard());
        return cardrepo.save(card);
    }
    public String generatecard(){
        String bin ="1234567";
        Random r =new Random();
        StringBuilder randomDigits = new StringBuilder();
        for(int i = 0 ; i<7 ;i++){
            randomDigits.append(r.nextInt(10));
        }
        String cardnum = bin.concat(randomDigits.toString());
        return cardnum;
    }
    public Optional<Card> getcardbyid (UUID id){
        return cardrepo.findById(id);
    }
    public Card updateaccount(Card card){
        return cardrepo.save(card);
    }
    public void deleteaccount(UUID cardid){
       cardrepo.deleteById(cardid);
    }
    public Card findbyucvv(String cvv){
      Card card = cardrepo.findByCvv(cvv);
        return card;
    }
}
