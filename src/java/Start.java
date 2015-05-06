
import entity.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import newFacade.MyFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class Start {
    public static void main(String[] args) {
//Persistence.generateSchema("SemesterProjectFligthsPU", null);    
    MyFacade facade = new MyFacade();
        
     //  Fly fly = new Fly(10);
       // facade.CreateFligth(fly);
    }
}
