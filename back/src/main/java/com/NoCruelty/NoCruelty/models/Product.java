package com.NoCruelty.NoCruelty.models;

import com.NoCruelty.NoCruelty.enums.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id_product")
    private Long id;
    private String name;
    private double price;
    private String description;
    private Category category;
    private int stock;
    private String urlImage;

}
