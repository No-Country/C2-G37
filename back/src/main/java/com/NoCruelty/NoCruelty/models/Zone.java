package com.NoCruelty.NoCruelty.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table (name = "zone")
public class Zone {
    
private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Country")
    private String country;

    @Column(name = "Province")
    private String province;

    public Zone(String country, String province) {
        this.country = country;
        this.province = province;
    }

    public Zone() {
    }

 

}