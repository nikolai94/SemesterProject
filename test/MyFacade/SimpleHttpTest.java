package MyFacade;
import static com.eclipsesource.restfuse.Assert.assertCreated;
import static com.eclipsesource.restfuse.Assert.assertOk;
import org.junit.Rule;
import org.junit.runner.RunWith;
import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;
    
@RunWith( HttpJUnitRunner.class)
public class SimpleHttpTest{
    @Rule
    public Destination restfuse = new Destination( this, "http://localhost:9090/SemesterProjectFligths/api");
    
    @Context
    private Response response;
    
    @HttpTest( method = Method.GET, path = "/flights")
    
    public void checkAllFlights(){
        assertOk( response );
    }
    
    //test af getFlightsWithstartAirportsEndairportAndDate
    @HttpTest( method = Method.GET, path = "/flights/Roskilde%20lufthavn/Randers%20flyplads/13-02-15")
    
    public void CheckgetStartEndAirportAndDate(){
       assertOk( response );
    } 
   
    //test af afbudsrejser
    @HttpTest( method = Method.GET, path = "/flights/Roskilde%20lufthavn/13-02-15")
    
    public void checkgetFlightDates(){
        assertOk ( response );
    }
    
    //test af reservationsid
    @HttpTest( method = Method.GET, path = "/flights/109")
    
    public void CheckflightDates(){
        assertOk( response );
    }
    
    
    
    
    
    
}

