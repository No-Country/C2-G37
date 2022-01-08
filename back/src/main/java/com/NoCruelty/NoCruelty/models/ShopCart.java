package com.NoCruelty.NoCruelty.models;

import com.NoCruelty.NoCruelty.enums.TypeOfPayment;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShopCart {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String totalPrice;
    private List<Product> productList;
    
    @Enumerated(EnumType.STRING)
    TypeOfPayment typeOfPayment;
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Zone zone;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Payment payment;
}
