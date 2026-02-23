package com.springmvc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDomain {
    private String productName;
    private String manufacturer;
    private double price;
    private int stock;
    private LocalDate expiryDate;
}
