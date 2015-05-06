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
import javax.persistence.OneToOne;

/**
 *
 * @author Jonathan
 */
@Entity
public class Kunde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String street;
    @OneToOne(mappedBy = "kunde")
    private Seat seat;

    public Kunde() {
    }

    public Kunde(String firstName, String lastName, String city, String country,String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
    
}
