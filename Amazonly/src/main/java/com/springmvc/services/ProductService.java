package com.springmvc.services;

import com.springmvc.mapper.ProductMapper;
import com.springmvc.models.Product;
import com.springmvc.models.ProductDomain;
import com.springmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void addProduct(ProductDomain product){
        productRepository.add(ProductMapper.toEntity(product));
    }

    public void updateProduct(Product product){
        productRepository.update(product);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public Product getProduct(int id){
        return productRepository.findById(id);
    }
    public List<Product> getAllProduct(){
        return productRepository.getAll();
    }

}
