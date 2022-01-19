package com.NoCruelty.NoCruelty.repositories;

import com.NoCruelty.NoCruelty.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Product findByIdProduct(Long idProduct);
    Product save(Product product);
    void deleteByIdProduct(Long idProduct);
}
