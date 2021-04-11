package mock;
import java.util.ArrayList;
import java.util.Random;

/**
 * mockar imported flight klasann
 * hefur aðferð sem skilar FlightMock hlutum fyrir einhver dat
 */

public class FlightSearchMock {

    private final String[] locations = {"Reykjavík", "Akureyri", "Egilstaðir", "Ísafjörður"};



    private String LocationFrom;
    private String LocationTo;
    private String date;
    private int n_passengers;

    public FlightSearchMock(String from, String to, String d, int n){
        this.LocationFrom = from;
        this.LocationTo = to;
        this.date = d;
        this.n_passengers = n;
    }


    /**
     * býr til flug object fyrir einhvern dag frá LocationFrom til LocationTo
     * @return
     */
    public ArrayList<FlightMock> genFlights(){
        Random r = new Random();
        ArrayList<FlightMock> flightsOut = new ArrayList<FlightMock>();

        int n_flights = r.nextInt(8); // at most 5 flights
        for(int i = 0;i<n_flights;i++){
            FlightMock flight = new FlightMock(this.LocationFrom, this.LocationTo, this.date, r.nextInt(30));
            flightsOut.add(flight);
        }
        return flightsOut;
    }

    /**
     * Sækir flug fyrir dag og síar út ef nóg pláss fyrir farþega sem beðið er um(n_passengers)
     * @return
     */
    public ArrayList<FlightMock> Search(){
        ArrayList<FlightMock> flightsOut = new ArrayList<FlightMock>();
        ArrayList<FlightMock> flightsGen = genFlights();
        for(FlightMock f: flightsGen){
            if(this.n_passengers<f.getAvailability()){
                flightsOut.add(f);
            }
        }
        return flightsOut;
    }

    public static void main(String[] args){

        System.out.println("debug");
        String[] locations = {"Reykjavík", "Akureyri", "Egilstaðir", "Ísafjörður"};

        FlightSearchMock f = new FlightSearchMock(locations[0], locations[1], "26/03/2021", 9);
        ArrayList<FlightMock> flights = f.Search();
        for(FlightMock fl:flights){
            System.out.println(fl);
        }
    }

}
