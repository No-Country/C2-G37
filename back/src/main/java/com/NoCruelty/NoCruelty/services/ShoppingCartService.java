package com.NoCruelty.NoCruelty.services;

import com.NoCruelty.NoCruelty.models.Product;
import com.NoCruelty.NoCruelty.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.NoCruelty.NoCruelty.models.ShoppingCart;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    // crud > create, read, update, delete
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public ShoppingCart create(String totalPrice, List<Product> productList) throws Exception {
        validate(totalPrice, productList);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTotalPrice(totalPrice);
        shoppingCart.setProductList(productList);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Transactional(readOnly = true)
    public List<ShoppingCart> read() {
        return shoppingCartRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public ShoppingCart update(Long id, String totalPrice, List<Product> productList) throws Exception {
        validate(totalPrice, productList);
        Optional<ShoppingCart> answer = shoppingCartRepository.findById(id);
        if (answer.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
            shoppingCart.setTotalPrice(totalPrice);
            shoppingCart.setProductList(productList);
            return shoppingCartRepository.save(shoppingCart);
        } else {
            throw new Error("No se encontro el carrito");
        }
    }

    public void delete(Long id) {
        Optional<ShoppingCart> answer = shoppingCartRepository.findById(id);
        if (answer.isPresent()) {
            ShoppingCart shoppingCart = answer.get();
            shoppingCartRepository.delete(shoppingCart);
        }
    }

    @Transactional
    private void validate(String totalPrice, List<Product> productList) throws Error {
        if (totalPrice == null || totalPrice.isEmpty() || totalPrice.contains("   ")) {
            throw new Error("Price must not contain spaces or be empty.");
        }
        if (productList == null || productList.isEmpty()) {
            throw new Error("Product list must not be empty.");
        }
    }
}
