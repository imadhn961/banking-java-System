package com.java_test.javaSpringboot.DTO;

import com.java_test.javaSpringboot.Models.AccountHolder;
import com.java_test.javaSpringboot.Models.Card;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Data
public class accountresponsedto {

    private UUID id ;
    private float balance;
    private String Status;
    private UUID accountholderid;
}
