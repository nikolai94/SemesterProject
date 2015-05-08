package rest;
import DTOClasses.AvaiableFligths;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import entity.Kunde;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import newFacade.MyFacade;
/**
 * REST Web Service
 *
 * @author Jonathan
 */
@Path("")
public class GenericResource {

    @Context
    private UriInfo context;
    static Gson gson = new Gson();
    MyFacade facade = new MyFacade();


    public GenericResource() {

    }
    public static void main(String args[]){
        
    }

    @GET
    @Path("/flights")
    @Produces("application/json")
    public String getFlight() {
        //TODO return proper representation object
        String name = "flight number three";
        
        System.out.println(name);
        
        return name;
    }
    
    //startAirport Date DONE
    @GET
    @Path("/flights/{startAirport}/{date}")
    @Produces("application/json")
    public String getFlightDates(@PathParam("startAirport") String startAirport,
            @PathParam("date") String date){
        return gson.toJson(facade.afbudsrejser(startAirport, date));
        
    }
    //DONE
    @GET
    @Path("/flights/{startAirport}/{slutAirport}/{dato}")
    @Produces("application/json")
    public String getStartEndAirport(@PathParam("startAirport")String startAirport,
        @PathParam("slutAirport") String slutAirport, @PathParam("dato") String dato){
        
        return gson.toJson(facade.getFlightsWithAirportsAndDate(startAirport, slutAirport, dato));
        
}
    //DONE
    @GET
    @Path("/flights/{id}")
    @Produces("application/json")
    public String flightDates(@PathParam("id")int id){
        
        return gson.toJson(facade.findReservationOnId(id));
    }
    
    @POST
    @Path("/flights/{id}")
    @Produces("application/json")
    public String createReservation(@PathParam("id") int id,String str){
        
        int findStart = str.indexOf("[");
        int findSlut = str.indexOf("]")+1;
        String newStr = str.substring(findStart,findSlut);
        
        Kunde[] kundeArray = gson.fromJson(newStr, Kunde[].class);
        List<Kunde> kundeList = Arrays.asList(kundeArray);
        
        facade.booking(id, kundeList);
        
        return""+ kundeList;
    }
    
    @DELETE
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("/flights/delete/{reservationid}")
    public String deleteFlight(@PathParam("reservationid")int reservationid){
        //return gson.toJson("Slettet reservation: " + reservationid);
        return gson.toJson(facade.ReservationDelete(reservationid));
    }
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
