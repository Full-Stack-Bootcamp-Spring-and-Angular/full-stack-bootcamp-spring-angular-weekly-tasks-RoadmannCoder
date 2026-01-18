package com.springmvc.models;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
@Scope("prototype")
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String city;

    public Client(int id, String firstName, String lastName, String email, LocalDate dob, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.city = city;
    }
}
