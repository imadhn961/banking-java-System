package com.java_test.javaSpringboot.repositeries;

import com.java_test.javaSpringboot.Models.Acount_Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ACREPO extends JpaRepository<Acount_Card, UUID> {
}
