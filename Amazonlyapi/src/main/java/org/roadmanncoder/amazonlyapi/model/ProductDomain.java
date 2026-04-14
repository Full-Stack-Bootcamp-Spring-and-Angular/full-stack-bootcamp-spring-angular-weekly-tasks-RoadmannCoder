package org.roadmanncoder.amazonlyapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDomain {
    @NotBlank(message = "Product Name is required")
    private String productName;

    @NotBlank(message = "Manufacturer is required for product information")
    private String manufacturer;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate expiryDate;
}
