package org.roadmanncoder.amazonlyapi.service;

import org.roadmanncoder.amazonlyapi.model.Product;
import org.roadmanncoder.amazonlyapi.model.ProductDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    ProductDomain findById(Integer integer);

    String deleteById(int ProductId);

    Page<ProductDomain> findAll(Pageable pageable);

    ProductDomain save (ProductDomain productDomain);

    ProductDomain update (ProductDomain productDomain, int id);
}
