package com.NoCruelty.NoCruelty.models;

import com.NoCruelty.NoCruelty.enums.Rol;
import io.orderup.DateAudit;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends DateAudit implements UserDetails {

    private static final long serialVersionUID = 1L;

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

    public User() {
    }
    
    public User(Long id, String name, String surname, String password, String email, long phone, Rol rol, Zone zone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.rol = rol;
        this.zone = zone;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Zone getZona() {
        return zone;
    }

    public void setZona(Zone zone) {
        this.zone = zone;
    }
}