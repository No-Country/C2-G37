package com.NoCruelty.NoCruelty.models;

import com.NoCruelty.NoCruelty.DTO.CardPaymentDTO;
import com.NoCruelty.NoCruelty.enums.TypeOfPayment;
import com.mercadopago.resources.Payment;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class ShoppingCart implements Serializable {
    
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

//    @ManyToOne()
//    @JoinColumn(name = "payment_id", nullable = false, updatable = false)
//    private Payment payment ;

}