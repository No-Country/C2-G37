package com.NoCruelty.NoCruelty.service.Interfaces;

import com.NoCruelty.NoCruelty.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> listAllProducts();
    Optional <Product> findProductId(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
}
