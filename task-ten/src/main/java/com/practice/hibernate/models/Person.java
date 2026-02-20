package com.practice.hibernate.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "person")
    private Passport passport;

    @Temporal(value = TemporalType.DATE)
    private LocalDate birthDate;


    @Override
    public String toString(){
        return "FirstName: "+firstName+"\n"+" LastName: "+lastName+"\n"+" Passport = "+passport+"\n"+" BirthDate = "+birthDate;
    }
}
