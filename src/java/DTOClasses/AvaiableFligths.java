/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOClasses;


/**
 *
 * @author nikolai
 */
public class AvaiableFligths {
    String airline;
    int price;
    String flightId;
    String takeOffDate;
    String landingDate;
    String depature;
    String destination;
    int seats;
    int avaiableSeats;
    boolean bookingCode;

    public AvaiableFligths(String airline, int price, String flightId, String takeOffDate, String landingDate, String depature, String destination, int seats, int avaiableSeats, boolean bookingCode) {
        this.airline = airline;
        this.price = price;
        this.flightId = flightId;
        this.takeOffDate = takeOffDate;
        this.landingDate = landingDate;
        this.depature = depature;
        this.destination = destination;
        this.seats = seats;
        this.avaiableSeats = avaiableSeats;
        this.bookingCode = bookingCode;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getTakeOffDate() {
        return takeOffDate;
    }

    public void setTakeOffDate(String takeOffDate) {
        this.takeOffDate = takeOffDate;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public String getDepature() {
        return depature;
    }

    public void setDepature(String depature) {
        this.depature = depature;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getAvaiableSeats() {
        return avaiableSeats;
    }

    public void setAvaiableSeats(int avaiableSeats) {
        this.avaiableSeats = avaiableSeats;
    }

    public boolean isBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(boolean bookingCode) {
        this.bookingCode = bookingCode;
    }

    @Override
    public String toString() {
        return "AvaiableFligths{" + "airline=" + airline + ", price=" + price + ", flightId=" + flightId + ", takeOffDate=" + takeOffDate + ", landingDate=" + landingDate + ", depature=" + depature + ", destination=" + destination + ", seats=" + seats + ", avaiableSeats=" + avaiableSeats + ", bookingCode=" + bookingCode + '}';
    }
    
    
    
    
}
