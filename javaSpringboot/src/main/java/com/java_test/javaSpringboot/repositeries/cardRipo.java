package com.java_test.javaSpringboot.repositeries;

import com.java_test.javaSpringboot.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface cardRipo extends JpaRepository<Card,UUID> {
Card findByCvv(String CVV);
}
