package com.java_test.javaSpringboot.Controller;

import com.java_test.javaSpringboot.DTO.cardRequestDto;
import com.java_test.javaSpringboot.DTO.cardresponseDTO;
import com.java_test.javaSpringboot.Models.Card;
import com.java_test.javaSpringboot.Services.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("card_controller")
public class Cardcontroller {
    @Autowired
    CardService CS;
    @Autowired
    ModelMapper model ;
    @PostMapping("/creat_card")
    public ResponseEntity<Card> creadcard(){
        return new ResponseEntity<>(CS.creatcard(), HttpStatus.CREATED);
    }
   /* @GetMapping("/get_card/{id}")
    public ResponseEntity<Card> getcard(@PathVariable UUID id){
        return new ResponseEntity<>(CS.getcardbyid(id).get(),HttpStatus.FOUND);
    }*/
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletecard(@PathVariable UUID id){
        CS.deleteaccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/find-card-by-cvv")
    public ResponseEntity<cardresponseDTO> findbycvv(@RequestBody cardRequestDto cardrequest){

      cardresponseDTO cardresponse = model.map( CS.findbyucvv(cardrequest.getCvv()),cardresponseDTO.class);

       return new ResponseEntity<>(cardresponse,HttpStatus.FOUND);

    }
}
