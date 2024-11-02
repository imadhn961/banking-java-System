package com.java_test.javaSpringboot.Models;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name ="account")
@Getter
@Setter
@Audited
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private UUID id ;
    @Column(name ="balance")
    private float balance;

    @Column
    private String Status;


    @ManyToOne
    @JoinColumn(name="idah")
    private AccountHolder accountholder;

    @ManyToMany
    private Set<Card> cards = new HashSet<>();


}
