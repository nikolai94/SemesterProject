/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Jonathan
 */
@Entity
public class Fly implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    //ArrayList<Integer> seats = new ArrayList<>();
   private int seats;
   
    @ManyToOne
    private Airline airline;
 
    
    public int getSeats(){
        return this.seats;
    } 
    
    @OneToMany(mappedBy = "fly")
    private List<Fligth> Fligths = new ArrayList();
    

    public Fly(int seats) {
        this.seats = seats;
    }
    public Fly()
    {
        
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    
    
    
    
    
    
}
