
import DTOClasses.AvaiableFligths;
import com.google.gson.Gson;
import entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import newFacade.MyFacade;


public class Start {
    public static void main(String[] args) {
//Persistence.generateSchema("SemesterProjectFligthsPU", null);    
    MyFacade facade = new MyFacade();
        
    ArrayList<Kunde> kunde = new ArrayList<Kunde>();
    Kunde k = new Kunde("tt","aa", "aa", "bb", "aa");
     Kunde k1 = new Kunde("tt","aa", "aa", "bb", "aa");
      Kunde k2 = new Kunde("tt","aa", "aa", "bb", "aa");
    kunde.add(k);
    kunde.add(k1);
    kunde.add(k2);
      kunde.add(k2);
        kunde.add(k2);

      Gson g = new Gson();
      //  System.out.println(facade.booking(2, kunde));
    
       // System.out.println(g.toJson(facade.getFlightsWithAirportsAndDate("Roskilde lufthavn", "Randers flyplads", "13-02-15")));
       
        
     //   System.out.println("hej" + facade.afbudsrejser("Roskilde lufthavn", "13-02-15"));
     //  Fly fly = new Fly(10);
       // facade.CreateFligth(fly);
      
    //    System.out.println(g.toJson(facade.findReservationOnId(357)));
        
        
        System.out.println(g.toJson(facade.ReservationDelete(759)));
    }
}
