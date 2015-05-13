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
  
    
   
    @OneToMany(mappedBy = "fligth")
    private List<Reservation> reservations = new ArrayList<Reservation>();

    public Fly getFly() {
        return fly;
    }

    public Integer getId() {
        return id;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }
    
    
    public boolean isBookingCode() {
        return bookingCode;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }
    

    public int getPrice() {
        return price;
    }

    public String getTakeOffDate() {
        return takeOffDate;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public Fligth(String takeOffDate, String landingDate, int price, boolean bookingCode, int freeSeats) {
        this.takeOffDate = takeOffDate;
        this.landingDate = landingDate;
        this.price = price;
        this.bookingCode = bookingCode;
        this.freeSeats = freeSeats;
    }

    public void setTakeOffDate(String takeOffDate) {
        this.takeOffDate = takeOffDate;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    
    
 

    public Fligth() {
    }

    public void addReservation(Reservation reservation ){
        reservations.add(reservation);
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }
    
    

    @Override
    public String toString() {
        return 
                "airline :"+fly.getAirline().getFirmName()+"Fligth{" + "id=" + id + ", takeOffDate=" + takeOffDate + ", landingDate=" + landingDate + ", price=" + price + ", bookingCode=" + bookingCode + ", freeSeats=" + freeSeats + ", fromAirport=" + fromAirport.getName() + ", toAirport=" + toAirport.getName() + ", fly=" + fly.getSeats() ;
    }
    
    
    
}
