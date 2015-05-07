/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author nikolai
 */
@Entity
public class Airline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firmName;
    
    @OneToMany(mappedBy = "airline")
    private List<Fly> flyvere =  new ArrayList<>();
    
public Airline(){}

    public Airline(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmName() {
        return firmName;
    }
    
    
}


