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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Jonathan
 */
@Entity
public class Reservation implements Serializable {

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Fligth getFligth() {
        return fligth;
    }

    public void setFligth(Fligth fligth) {
        this.fligth = fligth;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int totalPrice;
    
    @OneToMany(mappedBy = "reservation")
    private List<Seat> seats = new ArrayList();
    @ManyToOne
    private Fligth fligth;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void addToSeats(Seat seat){
        seats.add(seat);
    } 

    public Reservation(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public Reservation()
    {
        
    }
    
    public void addFligth(Fligth f){
        this.fligth = f;
    } 

    public Integer getId() {
        return id;
    }
    
}
