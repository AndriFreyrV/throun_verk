package sample;

import mock.FlightSearchMock;
import mock.HotelSearchMock;

public class CombinedSearch {
    private boolean findFlight;
    private boolean findHotel;
    private boolean findDayTour;
    private boolean findRoundTripFlight;
    private String from;
    private String to;
    private String dateFrom;
    private String dateTo; // for one way flight or only searching day tour we dont need day
    private int nPersons;


    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(String dateTo) {
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
    public FlightSearchMock flightSearch(){
        return new FlightSearchMock(this.from, this.to, this.dateFrom, this.nPersons);
    }

    // hér er round trip, búum til tvo instance af flightSearch
    public FlightSearchRound flightSearchRound(){
        FlightSearchMock f1 = new FlightSearchMock(this.from, this.to, this.dateFrom, this.nPersons);
        FlightSearchMock f2 = new FlightSearchMock(this.to, this.from, this.dateTo, this.nPersons);
        return new FlightSearchRound(f1, f2);
    }


    public HotelSearchMock hotelSearch(){
        return new HotelSearchMock(this.to,this.dateFrom,this.dateTo,this.nPersons);
    }

    public String toString() {
        // núna bara notað fyrir staðfestingu á að hlutur sé til
        return "blaaa";
    }


}
