package com.NoCruelty.NoCruelty.repositories;

import com.NoCruelty.NoCruelty.models.Product;
import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findAll();
    Optional <Product> findById(Long id);
    Product save(Product product);

    void deleteById(Long id);
}
