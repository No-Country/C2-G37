/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NoCruelty.NoCruelty.models;

import com.NoCruelty.NoCruelty.enums.Category;
import lombok.*;

import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id_product")
    private Long idProduct;
    private String name;
    private double price;
    private String description;
    private Category category;
    private int stock;
    private String urlImage;

}
