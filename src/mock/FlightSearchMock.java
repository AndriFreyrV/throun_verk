package mock;


import java.util.Date;

public class FlightSearchMock {
    private String LocationFrom;
    private String LocationTo;
    private Date date;
    private int n_passengers;

    public FlightSearchMock(String from, String to, Date d, int n){
        this.LocationFrom = from;
        this.LocationTo = to;
        this.date = d;
        this.n_passengers = n;
    }

}
