package com.NoCruelty.NoCruelty.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;
    private String comments;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Product> productList;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id")
    private User user;
  
}
