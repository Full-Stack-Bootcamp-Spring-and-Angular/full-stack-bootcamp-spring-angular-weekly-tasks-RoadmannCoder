package com.springmvc.repository;

import com.springmvc.models.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(int id);
    void add (Product product);
    void deleteById(int id);
    void update(Product product);
    List<Product> getAll();
}