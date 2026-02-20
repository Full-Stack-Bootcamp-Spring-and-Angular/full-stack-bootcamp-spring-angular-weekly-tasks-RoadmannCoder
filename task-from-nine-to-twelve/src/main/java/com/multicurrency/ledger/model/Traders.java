package com.multicurrency.ledger.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Traders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "trader_seq_gen",
            sequenceName = "trader_seq",
            initialValue = 1,
            allocationSize = 50 // MATCHES BATCH SIZE. This is the key.
    )
    private Long id;
    private String email;
    private String name;
    private BigDecimal balance;

}
