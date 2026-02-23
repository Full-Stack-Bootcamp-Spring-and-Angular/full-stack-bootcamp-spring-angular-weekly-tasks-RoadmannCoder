package com.springmvc.mapper;

import com.springmvc.models.Product;
import com.springmvc.models.ProductDomain;

public class ProductMapper {

    public static Product toEntity(ProductDomain productDomain){
        Product product = new Product();
        return product.builder()
                .name(productDomain.getProductName())
                .manufacturer(product.getManufacturer())
                .expirationDate(productDomain.getExpiryDate())
                .price(productDomain.getPrice())
                .stock(productDomain.getStock())
                .build();
    }

}
