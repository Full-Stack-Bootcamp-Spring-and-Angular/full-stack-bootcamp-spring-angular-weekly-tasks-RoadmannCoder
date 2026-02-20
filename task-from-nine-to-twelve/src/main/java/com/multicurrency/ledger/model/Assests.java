package com.multicurrency.ledger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Assests {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String symbol;
    private String name;
}
