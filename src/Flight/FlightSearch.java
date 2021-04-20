package Flight;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;

/**
 * calls flightSearch for params
 * @author Andri Freyr
 */

public class FlightSearch {


    private String LocationFrom;
    private String LocationTo;
    private Date date;
    private int n_passengers;

    public FlightSearch(String from, String to, Date d, int n) {
        this.LocationFrom = from;
        this.LocationTo = to;
        this.date = d;
        this.n_passengers = n;
    }

    public List<Flight> search() throws SQLException, ParseException{
        return QueryDB.searchFlight(this.LocationTo, this.LocationFrom, this.date, this.n_passengers);
    }
}