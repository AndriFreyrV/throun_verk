package sample;

import Flight.FlightSearch;
import mock.FlightSearchMock;
import mock.HotelSearchMock;

import java.util.Date;

public class CombinedSearch {
    private boolean findFlight;
    private boolean findHotel;
    private boolean findDayTour;
    private boolean findRoundTripFlight;
    private String from;
    private String to;
    private Date dateFrom;
    private Date dateTo; // for one way flight or only searching day tour we dont need day
    private int nPersons;


    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public boolean isFindRoundTripFlight() {
        return findRoundTripFlight;
    }

    public boolean isFindHotel() { return findHotel; }

    public CombinedSearch(boolean fF, boolean fH, boolean fD, boolean fRT, String f, String t,
                          int n){
        this.findFlight = fF;
        this.findHotel = fH;
        this.findDayTour = fD;
        this.findRoundTripFlight = fRT;
        this.from = f;
        this.to = t;
        this.nPersons = n;
    }

    public boolean isFindFlight() {
        return findFlight;
    }



    // verður skipt út fyrir proper klasa
    // one way flight search
    public FlightSearch flightSearch(){
        return new FlightSearch(this.from, this.to, this.dateFrom, this.nPersons);
    }

    // hér er round trip, búum til tvo instance af flightSearch
    public FlightSearchRound flightSearchRound(){
        FlightSearch f1 = new FlightSearch(this.from, this.to, this.dateFrom, this.nPersons);
        FlightSearch f2 = new FlightSearch(this.to, this.from, this.dateTo, this.nPersons);
        return new FlightSearchRound(f1, f2);
    }

    /*
    public HotelSearchMock hotelSearch(){
        return new HotelSearchMock(this.to,this.dateFrom,this.dateTo,this.nPersons);
    }
    */




}
