/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newFacade;
import entity.Fly;		
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
     
      public void CreateFligth(Fly fly)		
     {		
       em.getTransaction().begin();		
       em.persist(fly);		
      em.getTransaction().commit();		
      em.close();	
     }
}