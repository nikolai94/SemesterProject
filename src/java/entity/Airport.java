/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jonathan
 */
@Entity
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String airportName;
    private String city;
    private String code;

    public Airport() {
    }

    public Airport(String name, String city, String code) {
        this.airportName = name;
        this.city = city;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return airportName;
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }
    
    
    
    
}
