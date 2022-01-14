package com.NoCruelty.NoCruelty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.NoCruelty.NoCruelty.models.ShoppingCart;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    
}
