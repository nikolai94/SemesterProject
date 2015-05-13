/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFacade;

import DTOClasses.ReservationDTO;
import entity.Airline;
import entity.Airport;
import entity.Fligth;
import entity.Fly;
import entity.Kunde;
import entity.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import newFacade.MyFacade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class TestMyFacade {
      EntityManagerFactory emf;
         EntityManager em; 
     
  MyFacade facade = new MyFacade();
    public TestMyFacade() {
         
    }
    
    @BeforeClass
    public static void setUpClass() {
           	 	
  	 
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
         emf = Persistence.createEntityManagerFactory("SemesterProjectFligthsPU");
    
        Airport airport = new Airport("1","Koebenhavn","cph");
        Airport landingAirport = new Airport("2","bornholm","bor");
        Airline airline = new Airline("Sas");
        Fly fly = new Fly(10);
        Fligth fligth = new Fligth("08-05-2015", "15-05-2015", 100, true, 10);
        Fligth fligth1 = new Fligth("10-05-2015", "15-05-2015", 100, true, 10);

         
         
        

        System.out.println("hej");
        em = emf.createEntityManager();
        em.getTransaction().begin();
     
        fligth.setFly(fly);
        fligth.setFromAirport(airport);
        fligth.setToAirport(landingAirport);
        
        fligth1.setFly(fly);
        fligth1.setFromAirport(airport);
        fligth1.setToAirport(landingAirport);
        fly.setAirline(airline);
        
        em.persist(airline);
        em.persist(fly);
        em.persist(airport);
        em.persist(landingAirport);
        em.persist(fligth);
        em.getTransaction().commit();
        
             List<Kunde> bookingKunder = new ArrayList<>();
         Kunde k = new Kunde("aa","bb","her","ger","her");
         bookingKunder.add(k);
         bookingKunder.add(k);
          String q = "select f from Fligth f where f.takeOffDate=:takeOffDate";
          List<Fligth> list = em.createQuery(q).setParameter("takeOffDate", "08-05-2015").getResultList();
          List<Kunde> kunder = facade.booking(list.get(0).getId(), bookingKunder);
        
        em.close();
       
    
        System.out.println("slut");
    }
    
    @After
    public void tearDown() {
        System.out.println("farvel");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
          String q7 = "select s from Seat s";
         List<Fligth> list7 = em.createQuery(q7).getResultList();
         for (int i = 0; i < list7.size(); i++) {
              em.remove(list7.get(i));
        }
         
         
           String q8 = "select r from Reservation r";
         List<Fligth> list8 = em.createQuery(q8).getResultList();
         for (int i = 0; i < list8.size(); i++) {
              em.remove(list7.get(i));
        }
         
           String q9 = "select r from Reservation r";
         List<Fligth> list9 = em.createQuery(q9).getResultList();
         for (int i = 0; i < list9.size(); i++) {
              em.remove(list9.get(i));
        }
         
         String q = "select f from Fligth f";
         List<Fligth> list = em.createQuery(q).getResultList();
         for (int i = 0; i < list.size(); i++) {
              em.remove(list.get(i));
        }
         
         String q1 = "select f from Fly f";
         List<Fly> list1 = em.createQuery(q1).getResultList();
         for (int i = 0; i < list1.size(); i++) {
              em.remove(list1.get(i));
        }
         
         String q2 = "select f from Airline f";
         List<Airline> list2 = em.createQuery(q2).getResultList();
         for (int i = 0; i < list2.size(); i++) {
              em.remove(list2.get(i));
        }
         
          String q3 = "select a from Airport a";
         List<Airline> list3 = em.createQuery(q3).getResultList();
         for (int i = 0; i < list3.size(); i++) {
              em.remove(list3.get(i));
        }
      
        em.getTransaction().commit();
        em.close();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getFlightsWithAirportsAndDate() {
     assertTrue("Skal finde en rejse ved at angive, lufthavnsnavne + dato", facade.getFlightsWithAirportsAndDate("1", "2", "08-05-2015").size()==1);
     }
     
     @Test
     public void afbudsrejser() {
     assertTrue("Skal finde en rejse", facade.afbudsrejser("1","08-05-2015").size()==1); 
     }

      @Test
     public void booking() {
         em = emf.createEntityManager();
         List<Kunde> bookingKunder = new ArrayList<>();
         Kunde k = new Kunde("aa","bb","her","ger","her");
         bookingKunder.add(k);
         bookingKunder.add(k);
         bookingKunder.add(k);
         bookingKunder.add(k);
         
          String q = "select f from Fligth f where f.takeOffDate=:takeOffDate";
          List<Fligth> list = em.createQuery(q).setParameter("takeOffDate", "08-05-2015").getResultList();
          System.out.println("liste" + list);
          System.out.println(list.get(0).getId());
      List<Kunde> kunder = facade.booking(list.get(0).getId(), bookingKunder);
          em.close();
     assertTrue("Skal finde en rejse", kunder.size()==4); 
     }
     
     @Test
     public void FindReservationOnId() {
          em = emf.createEntityManager();
          String q = "select f from Reservation f";
          List<Reservation> list = em.createQuery(q).getResultList();
          ReservationDTO dto = facade.findReservationOnId(list.get(0).getId());
          System.out.println(dto.getPassengers().size());
           assertTrue("Skal finde en reservation ud for et id", dto.getPassengers().size() == 2 );    
     }
     
     @Test
     public void DeleteReservation() {
          em = emf.createEntityManager();
          String q = "select f from Reservation f";
          List<Reservation> list = em.createQuery(q).getResultList();
          ReservationDTO dto = facade.ReservationDelete(list.get(0).getId());
          String q2 = "select f from Reservation f";
          List<Reservation> list2 = em.createQuery(q).getResultList();
           assertFalse("Skal slette en reservation", list.size() == list2.size());    
     }
     
     

}
