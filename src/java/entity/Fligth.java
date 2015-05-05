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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Jonathan
 */
@Entity
public class Fligth implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String dato;
    @ManyToOne
    private Fly fly;
    
    @OneToOne
    private Airport fromAirport = new Airport();
    
    @OneToOne
    private Airport toAirport = new Airport();
    

    public Fligth() {
    }

    public Fligth(String dato) {
        this.dato = dato;
    }
    
    
}
