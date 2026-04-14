package org.roadmanncoder.amazonlyapi.repository;

import org.roadmanncoder.amazonlyapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Override
    Optional<Product> findById(Integer integer);


    @Transactional
    @Modifying
    @Query("update Product p set p.disable = 1 where p.id = :productId")
    void deleteById( @Param("productId")int ProductId);


    @Override
    @Query("select p from Product p where p.disable != 1")
    Page<Product> findAll(Pageable pageable);
}
