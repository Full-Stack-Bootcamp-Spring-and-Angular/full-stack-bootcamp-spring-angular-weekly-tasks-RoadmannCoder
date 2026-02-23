package com.springmvc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Product Name is required")
    private String name;
    private LocalDate expirationDate;
    @NotBlank(message = "manufacturer is required for product information")
    private String manufacturer;
    @NotNull(message = "price is required")
    @Min(value = 0, message = "price cannot be zero")
    private double price;
    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock cannot be zero")
    private int stock;



}
