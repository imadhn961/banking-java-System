package com.java_test.javaSpringboot.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name ="card")
@Getter
@Setter
@Audited
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID id;
    @Column(name = "cvv", length = 3)
    private String cvv;
    @Column(name = "Card_num")
    private String cardnum;
    @Column(name = "expiry_date")
    private LocalDate expirydate;
    @ManyToMany
    private Set<Account> Accounts = new HashSet<>();
}
