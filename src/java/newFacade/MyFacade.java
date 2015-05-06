/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newFacade;
import entity.Fligth;
import entity.Fly;		
import entity.Kunde;
import entity.Reservation;
import entity.Seat;
import java.util.ArrayList;
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
        return false;
     }
}