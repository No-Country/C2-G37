package com.NoCruelty.NoCruelty.models;

import com.NoCruelty.NoCruelty.enums.Rol;
import java.io.Serializable;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private long phone;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Zone zone;

    public Object get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} 
