package com.NoCruelty.NoCruelty.service;

import com.NoCruelty.NoCruelty.models.Product;
import com.NoCruelty.NoCruelty.repositories.ProductRepository;
import com.NoCruelty.NoCruelty.service.Interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> listAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        if(allProducts.isEmpty())return null;
        return allProducts;
    }

    @Override
    public Optional<Product> findProductId(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findProductId(String idproduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findFirstByCodigo(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
