package com.practice.hibernate.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
    private String passportNo;
    @Temporal(value = TemporalType.DATE)
    private LocalDate expiryDate;

    @Override
    public String toString(){
        return "Passport Number = "+passportNo+"\n"+" Expiry Date= "+expiryDate+"\n";
    }

}
