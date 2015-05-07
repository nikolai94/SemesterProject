package rest;
import com.google.gson.Gson;
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

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {

       //MyFacade facade = new MyFacade();
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
    @GET
    @Path("/flights/{startdate}/{enddate}")
    @Produces("application/json")
    public String getFlightDates(@PathParam("startdate") int startdate,
            @PathParam("enddate") int enddate){
        return gson.toJson("startdate: " + startdate + " " + "enddate: " + enddate);
        
    }
    
    @GET
    @Path("/flights/{startairport}/{endairport}/{dateid}")
    @Produces("application/json")
    public String getStartEndAirport(@PathParam("startairport")String airport,
        @PathParam("endairport") String endair, @PathParam("dateid") int dateid){
        return gson.toJson("startairport: " + airport + " " + "endairport: " + endair + " "
                + "date: " + dateid);
        
}
    
    @GET
    @Path("/flights/{reservationid}")
    @Produces("application/json")
    public String flightDates(@PathParam("reservationid")int id){
        return gson.toJson("Reservationsid: " + id);
    }
    
    @POST
    @Path("/flights/{flightid}")
    @Produces("application/json")
    public String createReservation(@PathParam("flightid")int fid){
        return gson.toJson("flightid: " + fid);
    }
    
    @DELETE
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("/flights/delete/{reservationid}")
    public String deleteFlight(@PathParam("reservationid")int reservationid){
        return gson.toJson("Slettet reservation: " + reservationid);
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
