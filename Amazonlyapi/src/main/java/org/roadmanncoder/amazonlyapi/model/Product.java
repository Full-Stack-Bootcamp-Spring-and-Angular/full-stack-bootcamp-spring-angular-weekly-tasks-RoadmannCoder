package org.roadmanncoder.amazonlyapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


    @Entity
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        @NotNull
        private int disable;



    }

