package com.java_test.javaSpringboot.DTO;

import com.java_test.javaSpringboot.Models.Account;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Data
public class cardresponseDTO {

    private UUID id;

    private String cvv;

    private String cardnum;

    private LocalDate expirydate;

}
