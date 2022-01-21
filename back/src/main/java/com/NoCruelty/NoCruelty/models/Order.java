package com.NoCruelty.NoCruelty.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "response")
    private String response;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Product> productList;

    @ManyToOne()
    @JoinColumn(name = "id_user", nullable = false, updatable = false)
    private User user;

}
