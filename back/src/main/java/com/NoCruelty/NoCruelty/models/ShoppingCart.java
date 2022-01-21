package com.NoCruelty.NoCruelty.models;

import com.NoCruelty.NoCruelty.enums.TypeOfPayment;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShoppingCart {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String totalPrice;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Product> productList;

    @Enumerated(EnumType.STRING)
    TypeOfPayment typeOfPayment;

//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
//    private Zone zone;
    @ManyToOne()
    @JoinColumn(name = "zone_id", nullable = false, updatable = false)
    private Zone zone;

//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @ManyToOne()
    @JoinColumn(name = "payment_id", nullable = false, updatable = false)
    private Payment payment;

}
