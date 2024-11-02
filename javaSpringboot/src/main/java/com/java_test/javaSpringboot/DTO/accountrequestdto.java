package com.java_test.javaSpringboot.DTO;

import com.java_test.javaSpringboot.Models.AccountHolder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class accountrequestdto {
    @NotNull(message = "balance not null")
    @Positive(message="balance cannot be negative")
    private float balance;
    @NotBlank
    private String Status;
    private AccountHolder accountholder;
}
