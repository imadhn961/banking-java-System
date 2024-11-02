package com.java_test.javaSpringboot.repositeries;

import com.java_test.javaSpringboot.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepo extends JpaRepository<Account, UUID> {

}
