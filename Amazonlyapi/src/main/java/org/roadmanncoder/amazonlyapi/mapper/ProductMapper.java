package org.roadmanncoder.amazonlyapi.mapper;

import org.roadmanncoder.amazonlyapi.model.Product;
import org.roadmanncoder.amazonlyapi.model.ProductDomain;

public class ProductMapper {

    public static Product toEntity(ProductDomain productDomain){
        Product product = new Product();
        return product.builder()
                .name(productDomain.getProductName())
                .manufacturer(productDomain.getManufacturer())
                .expirationDate(productDomain.getExpiryDate())
                .price(productDomain.getPrice())
                .stock(productDomain.getStock())
                .build();
    }
    public static Product toEntity(ProductDomain productDomain, int id){
        Product product = new Product();
        return product.builder()
                .id(id)
                .name(productDomain.getProductName())
                .manufacturer(productDomain.getManufacturer())
                .expirationDate(productDomain.getExpiryDate())
                .price(productDomain.getPrice())
                .stock(productDomain.getStock())
                .build();
    }
    public static ProductDomain toDomain(Product product){
        ProductDomain productDomain = new ProductDomain();
        return productDomain.builder()
                .productName(product.getName())
                .expiryDate(product.getExpirationDate())
                .manufacturer(product.getManufacturer())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

}
