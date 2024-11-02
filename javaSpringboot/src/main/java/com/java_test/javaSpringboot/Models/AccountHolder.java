package com.java_test.javaSpringboot.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name="accountholder")
@Getter
@Setter
@Audited
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idah")
    private UUID id;
    @Column(name="fname")
    private String firstname;
    @Column(name="lname")
    private String lastname;
    @Column(name="number")
    private Integer phonenumber;
    @Column(name="email")
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate date;
    @Column(name="mname")
    private String mothername ;

    @OneToMany(mappedBy = "accountholder")
    private List<Account> accounts = new ArrayList<>();
}
