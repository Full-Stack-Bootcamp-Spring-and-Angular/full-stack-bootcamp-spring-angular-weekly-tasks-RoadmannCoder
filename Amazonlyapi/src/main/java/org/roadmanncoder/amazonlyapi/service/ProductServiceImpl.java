package org.roadmanncoder.amazonlyapi.service;

import org.roadmanncoder.amazonlyapi.mapper.ProductMapper;
import org.roadmanncoder.amazonlyapi.model.Product;
import org.roadmanncoder.amazonlyapi.model.ProductDomain;
import org.roadmanncoder.amazonlyapi.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDomain findById(Integer integer) {
       ProductDomain productDomain = new ProductDomain();
       Optional<Product> product = productRepository.findById(integer);
       if(product.isPresent())
           productDomain = ProductMapper.toDomain(product.get());
       return productDomain;
    }

    @Override
    public String deleteById(int productId) {
        Optional<ProductDomain> productDomain = Optional.ofNullable(findById(productId));
        if(productDomain.isPresent()){
            productRepository.deleteById(productId);
            return "Successful Deletion";
        }
        return "Product Doesn't Exists";
    }

    @Override
    public Page<ProductDomain> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductMapper::toDomain);
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        Product product = ProductMapper.toEntity(productDomain);
        Product save = productRepository.save(product);
        return ProductMapper.toDomain(save);
    }

    @Override
    public ProductDomain update(ProductDomain productDomain, int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            product.get().setName(productDomain.getProductName());
            product.get().setPrice(productDomain.getPrice());
            product.get().setStock(productDomain.getStock());
            product.get().setManufacturer(productDomain.getManufacturer());
            product.get().setExpirationDate(productDomain.getExpiryDate());
            productRepository.save(product.get());
            return ProductMapper.toDomain(product.get());
        }
        return new ProductDomain();

    }
}
