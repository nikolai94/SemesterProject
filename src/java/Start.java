
import DTOClasses.AvaiableFligths;
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
        
    //ArrayList<Kunde> kunde = new ArrayList<Kunde>();
    //Kunde k = new Kunde("tt","aa", "aa", "bb", "aa");
   // kunde.add(k);
    
  //  facade.booking(1, kunde);
    
       List<AvaiableFligths> list = facade.getFlightsWithAirportsAndDate("Roskilde lufthavn", "Randers flyplads", "13-02-15");
        for (int i = 0; i < list.size(); i++) {
            System.out.println( list.get(i).toString());
        }
     //  Fly fly = new Fly(10);
       // facade.CreateFligth(fly);
    }
}
