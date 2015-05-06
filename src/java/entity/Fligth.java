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
    private String takeOffDate;
    private String landingDate;
    private int price;
    private boolean bookingCode;
    private int freeSeats;

    
    @OneToOne
    private Airport fromAirport;
    
    @OneToOne
    private Airport toAirport;
    @ManyToOne
    private Fly fly;
    @ManyToOne
    private Reservation reservation;
    
 

    public Fligth() {
    }

    
    
    
}
