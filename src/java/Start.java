
import entity.*;
import facade.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    Facade facade = new Facade();
        
     //  Fly fly = new Fly(10);
       // facade.CreateFligth(fly);
    }
}
