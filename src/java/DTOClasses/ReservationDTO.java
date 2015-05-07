/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOClasses;

import entity.Kunde;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ReservationDTO {
    int reservationID;
    String flightID;
    List<Kunder> Passengers = new ArrayList<>();
    int totalPrice;

    public ReservationDTO(int reservationID, String flightID, int totalPrice) {
        this.reservationID = reservationID;
        this.flightID = flightID;
       
        
        this.totalPrice = totalPrice;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public List<Kunder> getPassengers() {
        return Passengers;
    }
    public void AddPassengers( String firstName,String lastName, String city, String country, String street)
    {
        Passengers.add(new Kunder(firstName, lastName, city, country, street));
    }

  
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" + "reservationID=" + reservationID + ", flightID=" + flightID + ", Passengers=" + Passengers + ", totalPrice=" + totalPrice + '}';
    }
    
    public static class Kunder{
        private String firstName;
        private String lastName;
        private String city;
        private String country;
        private String street;

        public Kunder(String firstName, String lastName, String city, String country, String street) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.city = city;
            this.country = country;
            this.street = street;
        }
        
        
    }
    
    
}
