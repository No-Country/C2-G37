package com.NoCruelty.NoCruelty.controllers;

import com.NoCruelty.NoCruelty.models.Product;
import com.NoCruelty.NoCruelty.service.Interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.stereotype.Controller;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    //Buscar un producto por id
    @GetMapping("/{id-product}")
    public ResponseEntity<Object> findProductId(@PathVariable("id-product") Long id) {
        System.out.println("Holaaa");
        return new ResponseEntity<>(iProductService.findProductId(id), HttpStatus.OK);
    }

    //Listar todos los productos
    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return new ResponseEntity<>(iProductService.listAllProducts(), HttpStatus.OK);
//        
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(iProductService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id-product}")
    public String updateProductId(@PathVariable("id-product") Long id) {
        return "Buscar un solo producto" + id;
    }

    @DeleteMapping("/{id-product}")
    public ResponseEntity<String> deleteProductId(@PathVariable("id-product") Long id) {
            iProductService.deleteProduct(id);
        return new ResponseEntity<>("Producto con id: " + id + "Eliminado con exito", HttpStatus.OK);
    }
}
