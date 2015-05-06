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
public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    
    @OneToOne
    private Kunde kunde;
    @ManyToOne
    private Reservation reservation;
    
    public void addReservation(Reservation r)
    {
     reservation = r;   
    }

    public Seat() {
    }
    
    public void addKunde(Kunde k)
    {
        kunde = k;
    }
    
    
}
