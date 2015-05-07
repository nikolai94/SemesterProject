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
    List<Kunde> Passengers = new ArrayList<>();
    int totalPrice;

    public ReservationDTO(int reservationID, String flightID,List<Kunde> Passengers, int totalPrice) {
        this.reservationID = reservationID;
        this.flightID = flightID;
        this.Passengers = Passengers;
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

    public List<Kunde> getPassengers() {
        return Passengers;
    }
    public void AddPassengers(Kunde k)
    {
        Passengers.add(k);
    }

    public void setPassengers(List<Kunde> Passengers) {
        this.Passengers = Passengers;
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
    
    
    
    
}
