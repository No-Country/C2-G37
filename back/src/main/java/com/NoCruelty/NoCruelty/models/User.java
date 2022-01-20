package com.NoCruelty.NoCruelty.models;

import com.NoCruelty.NoCruelty.enums.Rol;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private long phone;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Zone zone;

    public User(Object get, String password, List<GrantedAuthority> permisos) {
    this.name = name;
    this.password = password;
    }

    public User() {
    }

} 
