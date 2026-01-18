package com.springmvc.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.springmvc.validation.PasswordMatch;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@PasswordMatch(
        field = "password",
        fieldMatch = "confirmPassword"
)
public class User {

    @NotNull(message = "username cannot be empty or null")
    private String username;

    @NotNull(message = "email is required")
    @Email(message = "please enter a valid email address")
    private String email;

    @NotNull(message = "password cannot be empty or null")
    private String password;

    private String confirmPassword;
}

