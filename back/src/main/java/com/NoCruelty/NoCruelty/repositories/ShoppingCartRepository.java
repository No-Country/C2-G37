package com.NoCruelty.NoCruelty.repositories;

import com.NoCruelty.NoCruelty.models.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
    
    ShoppingCart save(ShoppingCart shoppingCart);
}
