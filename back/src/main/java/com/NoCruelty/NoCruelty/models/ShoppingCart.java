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
    private String fechaYHora;
    private String totalPrice;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Product> productList;

    @Enumerated(EnumType.STRING)
    TypeOfPayment typeOfPayment;

    @ManyToOne()
    @JoinColumn(name = "zone_id", nullable = false, updatable = false)
    private Zone zone;

    @ManyToOne()
    @JoinColumn(name = "payment_id", nullable = false, updatable = false)
    private Payment payment;

}
