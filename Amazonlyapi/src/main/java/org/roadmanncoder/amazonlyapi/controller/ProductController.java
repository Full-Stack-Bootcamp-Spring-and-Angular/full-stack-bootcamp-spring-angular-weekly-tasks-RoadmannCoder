package org.roadmanncoder.amazonlyapi.controller;

import jdk.jshell.Snippet;
import org.roadmanncoder.amazonlyapi.model.ProductDomain;
import org.roadmanncoder.amazonlyapi.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDomain> addProduct(@RequestBody ProductDomain productDomain){
        ProductDomain productDomain1 = productService.save(productDomain);
        return new ResponseEntity<>(productDomain1, HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        String response = productService.deleteById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
   }
   @GetMapping("/product")
   public ResponseEntity<Page<ProductDomain>> getAllProducts(@RequestParam int page ){
        Pageable pageable = PageRequest.of(page,5, Sort.by("id"));
        Page<ProductDomain> productDomains = productService.findAll(pageable);
        return new ResponseEntity<>(productDomains, HttpStatus.OK);
   }

   @GetMapping("/product/{id}")
    public ResponseEntity<ProductDomain> getProduct(@PathVariable int id){
        ProductDomain productDomain = productService.findById(id);
        return new ResponseEntity<>(productDomain, HttpStatus.OK);
   }

   @PutMapping("/product/{id}")
    public ResponseEntity<ProductDomain> updateProduct(@RequestBody ProductDomain productDomain, @PathVariable int id){
        ProductDomain productDomainUpdate = productService.update(productDomain,id);
        return new ResponseEntity<>(productDomainUpdate, HttpStatus.OK);
   }


}
