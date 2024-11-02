package com.java_test.javaSpringboot.repositeries;

import com.java_test.javaSpringboot.Models.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Accountholder_Repo extends JpaRepository<AccountHolder, UUID> {
}
