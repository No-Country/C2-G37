package com.NoCruelty.NoCruelty.service.Interfaces;

import com.NoCruelty.NoCruelty.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> listAllProducts();
    Product findProductId(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
}
