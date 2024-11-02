package com.java_test.javaSpringboot.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="AC")
@Getter
@Setter
@Audited
public class Acount_Card {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="ACID")
        private UUID id;

        @ManyToOne
        @JoinColumn(name = "id")
        private Account account ;

        @ManyToOne
        @JoinColumn(name ="idc",referencedColumnName = "id")
        private Card card;

}
