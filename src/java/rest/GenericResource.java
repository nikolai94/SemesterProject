package rest;
import DTOClasses.AvaiableFligths;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import entity.Kunde;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import newFacade.MyFacade;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
/**
 * REST Web Service
 *
 * @author Jonathan
 */
@Path("")
public class GenericResource {

    public String datoSorter(String date)
    {
      String str[] = date.split(" ");
      
      int day = Integer.parseInt(str[0])+1;
      
      String newDay = "";
      if(str[0].length() == 1 ){
          newDay = "0"+day;
      }
      else{
          newDay = ""+day;
      }
      String md = 0+"";
      
      if(str[1].equalsIgnoreCase("Jan"))
      {
          md = "01";
      }
      else if(str[1].equalsIgnoreCase("Feb"))
      {
          md = "02";
      }
       else if(str[1].equalsIgnoreCase("Mar"))
      {
          md = "03";
      }
       
       else if(str[1].equalsIgnoreCase("Apr"))
      {
          md = "04";
      }
       else if(str[1].equalsIgnoreCase("May"))
      {
          md = "05";
      }
       else if(str[1].equalsIgnoreCase("Jun"))
      {
          md = "06";
      }
         else if(str[1].equalsIgnoreCase("Jul"))
      {
          md = "07";
      }
         else if(str[1].equalsIgnoreCase("Aug"))
      {
          md = "08";
      }
      else if(str[1].equalsIgnoreCase("Sep"))
      {
           md = "09";
      }
      else if(str[1].equalsIgnoreCase("Oct"))
      {
           md = "10";
      }
       else if(str[1].equalsIgnoreCase("Nov"))
      {
           md = "11";
      }
       else if(str[1].equalsIgnoreCase("Dec"))
      {
           md = "12";
      }
      
        return newDay+"-"+md+"-"+str[2];
    }
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
            @PathParam("date") long date){
        String dato = "";
        String datoSlut = "";
        Date guf = null;
        try {
         Date hej = new Date(date);
         guf = new Date(date+TimeZone.getDefault().getOffset(hej.getTime()));
       
         dato = guf.toLocaleString();
         datoSlut = dato.substring(0, 10);
        } catch (Exception e) {
           // return e.toString();
        }
             
            
  
        return gson.toJson(facade.afbudsrejser(startAirport, datoSorter(guf.toGMTString())));
        
    }
    //DONE
    @GET
    @Path("/flights/{startAirport}/{slutAirport}/{dato}")
    @Produces("application/json")
    public String getStartEndAirport(@PathParam("startAirport")String startAirport,
        @PathParam("slutAirport") String slutAirport, @PathParam("dato") Long datoUrl){
         String dato = "";
        String datoSlut = "";
        Date guf = null;
        Date hej = null;
        try {
          hej = new Date(datoUrl);
        guf = new Date(datoUrl+TimeZone.getTimeZone("CST").getOffset(hej.getTime()));
       
         dato = guf.toLocaleString();
         datoSlut = dato.substring(0, 10);
        } catch (Exception e) {
            return e.toString();
        }
       //   return "datoslut"+datoSlut + " dato " + dato + "guf "+ guf + " HEJ:"+hej +"herher "+guf.getDay()+"-"+guf.getMonth()+"-"+guf.getYear() + "getdate" +guf.getDate()+ " toString"+guf.toString() + "toGMTString" + guf.toGMTString();
        return gson.toJson(facade.getFlightsWithAirportsAndDate(startAirport, slutAirport,  datoSorter(guf.toGMTString())));
        
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
