package com.java_test.javaSpringboot.DTO;

import com.java_test.javaSpringboot.Models.Account;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Data
public class cardRequestDto {
    private String cvv;

}
