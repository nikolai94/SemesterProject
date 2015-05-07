/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newFacade;
import DTOClasses.AvaiableFligths;
import entity.Fligth;
import entity.Fly;		
import entity.Kunde;
import entity.Reservation;
import entity.Seat;
import java.util.ArrayList;
import java.util.List;
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
   
     public MyFacade(){		
     emf = Persistence.createEntityManagerFactory("SemesterProjectFligthsPU");		
    }
     
     public boolean booking(int flyId, ArrayList<Kunde> kundeArr)		
     {	
        em = emf.createEntityManager();
        em.getTransaction().begin();		
        Reservation reservation = new Reservation();
        Fligth fligth = em.find(Fligth.class, flyId);
        if(fligth.getFreeSeats() >= kundeArr.size())
        {
            
        
        for (int i = 0; i < kundeArr.size(); i++) { 
            
            Seat seat = new Seat();
            seat.addKunde(kundeArr.get(i));
            reservation.addToSeats(seat);
            seat.addReservation(reservation);
            em.persist(kundeArr.get(i));
            em.persist(seat);
          //  em.persist());
        }
        fligth.addReservation(reservation);
        reservation.addFligth(fligth);
        em.persist(reservation);
        
        
        
        em.getTransaction().commit();		
        em.close();
        return true;
        }
        else
        {
            em.close();
            return false;
            
        }
        
     }
     
     public List<AvaiableFligths> getFlightsWithAirportsAndDate(String startAirport, String slutAirport, String dato)
     {
         em = emf.createEntityManager();
         List<AvaiableFligths> DTOFLigths = new ArrayList<>();
          String q = "select f from Fligth f where f.takeOffDate=:takeOffDate and f.fromAirport.name=:startLuftnavn and f.toAirport.name=:slutAirport";
          List<Fligth> list = em.createQuery(q).setParameter("takeOffDate", dato).setParameter("startLuftnavn", startAirport).setParameter("slutAirport", slutAirport).getResultList();
          for (int i = 0; i < list.size(); i++) {
            //  String airline, int price, String flightId, String takeOffDate, String landingDate, String depature, String destination, int seats, int avaiableSeats, boolean bookingCode
              AvaiableFligths dtoFlight = new AvaiableFligths(list.get(i).getFly().getAirline().getFirmName(),list.get(i).getPrice(),list.get(i).getId()+"",list.get(i).getTakeOffDate(),list.get(i).getLandingDate(),list.get(i).getFromAirport().getCode(),list.get(i).getToAirport().getCode(),list.get(i).getFly().getSeats(), list.get(i).getFreeSeats(), list.get(i).isBookingCode());
             DTOFLigths.add(dtoFlight);
          }
         return DTOFLigths;
     }
}