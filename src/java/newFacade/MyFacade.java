/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newFacade;
import DTOClasses.AvaiableFligths;
import DTOClasses.ReservationDTO;
import entity.Fligth;
import entity.Fly;		
import entity.Kunde;
import entity.Reservation;
import entity.Seat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;		
import javax.persistence.EntityManagerFactory;		
import javax.persistence.Persistence;
/**
 *
 * @author Jonathan
 */
public class MyFacade {
     EntityManagerFactory emf;		
   EntityManager em; 
      DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.GERMANY);
     public MyFacade(){		
     emf = Persistence.createEntityManagerFactory("SemesterProjectFligthsPU");		
    }
     
     public List<Kunde> booking(int flyId, List<Kunde> kundeArr)		
     {	
        List<Kunde> Kundeliste = new ArrayList<>();
        em = emf.createEntityManager();
        em.getTransaction().begin();		
        Reservation reservation = new Reservation();
        Fligth fligth = em.find(Fligth.class, flyId);
         System.out.println(fligth.getFreeSeats());
        if(fligth.getFreeSeats() >= kundeArr.size())
        {
         
          try {
                
            
                for (int i = 0; i < kundeArr.size(); i++) { 
                    reservation.setTotalPrice(fligth.getPrice()+reservation.getTotalPrice());
                    Seat seat = new Seat();
                    seat.addKunde(kundeArr.get(i));
                    reservation.addToSeats(seat);
                    seat.addReservation(reservation);
                    em.persist(kundeArr.get(i));
                    em.persist(seat);
                    fligth.setFreeSeats(fligth.getFreeSeats()-1);
                   Kundeliste.add(kundeArr.get(i));
                  //  em.persist());
                }
                fligth.addReservation(reservation);
                reservation.addFligth(fligth);
                em.persist(reservation);



                em.getTransaction().commit();		
                em.close();
                return Kundeliste;
            } 
            catch (Exception e) {
                em.getTransaction().rollback();
                em.close();
                return null;
            }
        
        }
        else
        {
            em.close();
            return null;
            
        }
        
     }
     
     public List<AvaiableFligths> getFlightsWithAirportsAndDate(String startAirport, String slutAirport, String dato) 
     {
         em = emf.createEntityManager();
      
         List<AvaiableFligths> DTOFLigths = new ArrayList<>();
          String q = "select f from Fligth f where f.takeOffDate=:takeOffDate and f.fromAirport.airportName=:startLuftnavn and f.toAirport.airportName=:slutAirport";
          List<Fligth> list = em.createQuery(q).setParameter("takeOffDate", dato).setParameter("startLuftnavn", startAirport).setParameter("slutAirport", slutAirport).getResultList();
          
        Date date = null;
        Date date2  = null;
          for (int i = 0; i < list.size(); i++) {
             try {
                 //  String airline, int price, String flightId, String takeOffDate, String landingDate, String depature, String destination, int seats, int avaiableSeats, boolean bookingCode

                 date = format.parse(list.get(i).getTakeOffDate());
                 date2 = format.parse(list.get(i).getLandingDate());
             } catch (ParseException ex) {
                 System.out.println(ex);
             }
         list.get(i).setTakeOffDate(date.getTime()+"");
         list.get(i).setLandingDate(date2.getTime()+"");
              AvaiableFligths dtoFlight = new AvaiableFligths(list.get(i).getFly().getAirline().getFirmName(),list.get(i).getPrice(),list.get(i).getId()+"",list.get(i).getTakeOffDate(),list.get(i).getLandingDate(),list.get(i).getFromAirport().getName(),list.get(i).getToAirport().getName(),list.get(i).getFly().getSeats(), list.get(i).getFreeSeats(), list.get(i).isBookingCode());
             DTOFLigths.add(dtoFlight);
          }
         return DTOFLigths;
     }
     
     
       public List<AvaiableFligths> afbudsrejser(String startAirport,String dato)
     {
         em = emf.createEntityManager();
         List<AvaiableFligths> DTOFLigths = new ArrayList<>();
          String q = "select f from Fligth f where f.takeOffDate=:takeOffDate and f.fromAirport.airportName=:startLuftnavn";
          List<Fligth> list = em.createQuery(q).setParameter("takeOffDate", dato).setParameter("startLuftnavn", startAirport).getResultList();
            Date date = null;
            Date date2  = null;
          for (int i = 0; i < list.size(); i++) {
              
               try {
                 //  String airline, int price, String flightId, String takeOffDate, String landingDate, String depature, String destination, int seats, int avaiableSeats, boolean bookingCode

                 date = format.parse(list.get(i).getTakeOffDate());
                 date2 = format.parse(list.get(i).getLandingDate());
             } catch (ParseException ex) {
                 System.out.println(ex);
             }
         list.get(i).setTakeOffDate(date.getTime()+"");
         list.get(i).setLandingDate(date2.getTime()+"");
              
            //  String airline, int price, String flightId, String takeOffDate, String landingDate, String depature, String destination, int seats, int avaiableSeats, boolean bookingCode
              AvaiableFligths dtoFlight = new AvaiableFligths(list.get(i).getFly().getAirline().getFirmName(),list.get(i).getPrice(),list.get(i).getId()+"",list.get(i).getTakeOffDate(),list.get(i).getLandingDate(),list.get(i).getFromAirport().getCode(),list.get(i).getToAirport().getCode(),list.get(i).getFly().getSeats(), list.get(i).getFreeSeats(), list.get(i).isBookingCode());
             DTOFLigths.add(dtoFlight);
          }
         return DTOFLigths;
     }
       
       public ReservationDTO findReservationOnId(int id)
       {
             em = emf.createEntityManager();
             
              Reservation reservation = em.find(Reservation.class, id);
              System.out.println(reservation);
              Fligth flight = reservation.getFligth();
              List<Seat> seat = reservation.getSeats();
           
             
              ReservationDTO  dto = new ReservationDTO(reservation.getId(),flight.getId()+"", reservation.getTotalPrice());
             
              for (int i = 0; i < seat.size(); i++) {
                //kunder.add(seat.get(i).getKunde());
                dto.AddPassengers(seat.get(i).getKunde().getFirstName(),seat.get(i).getKunde().getLastName(),seat.get(i).getKunde().getCity(),seat.get(i).getKunde().getCountry(),seat.get(i).getKunde().getStreet());
              }
              return dto;
       }
       
       public ReservationDTO ReservationDelete(int id)
       {
             em = emf.createEntityManager();
             
              Reservation reservation = em.find(Reservation.class, id);
              Fligth flight = reservation.getFligth();
              List<Seat> seat = reservation.getSeats();
            
             System.out.println(reservation);
              ReservationDTO  dto = new ReservationDTO(reservation.getId(),flight.getId()+"", reservation.getTotalPrice());
             
              for (int i = 0; i < seat.size(); i++) {
                //kunder.add(seat.get(i).getKunde());
                dto.AddPassengers(seat.get(i).getKunde().getFirstName(),seat.get(i).getKunde().getLastName(),seat.get(i).getKunde().getCity(),seat.get(i).getKunde().getCountry(),seat.get(i).getKunde().getStreet());
              }
              
              flight.setFreeSeats(flight.getFreeSeats()+seat.size());
              em.getTransaction().begin();
              for (int i = 0; i < seat.size(); i++) {
               em.remove(seat.get(i));
                }
              em.remove(reservation);
              em.persist(flight);
              em.getTransaction().commit();
              em.close();
           
           return dto;
       }
}