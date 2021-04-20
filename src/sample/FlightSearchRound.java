package sample;

import Flight.FlightSearch;

public class FlightSearchRound {
    public FlightSearch getFlightTo() {
        return flightTo;
    }

    public FlightSearch getFlightBack() {
        return flightBack;
    }

    private FlightSearch flightTo;
    private FlightSearch flightBack;

    public FlightSearchRound(FlightSearch f1, FlightSearch f2){
        this.flightTo = f1;
        this.flightBack = f2;
    }
}
