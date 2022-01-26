package com.NoCruelty.NoCruelty.models;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private String securityCode;
    private String DNI;
    private String expireDate;
    private String responsible;

    public Object setTransactionAmount(Float transactionAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
