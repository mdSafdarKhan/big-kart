package com.example.productservicetdd.repository;

import com.example.productservicetdd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findProductsByQuantityBetween(int min, int max);

    Optional<Product> findProductById(Long id);
}
