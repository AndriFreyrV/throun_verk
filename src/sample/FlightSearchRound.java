package sample;

import mock.FlightSearchMock;

public class FlightSearchRound {
    public FlightSearchMock getFlightTo() {
        return flightTo;
    }

    public FlightSearchMock getFlightBack() {
        return flightBack;
    }

    private FlightSearchMock flightTo;
    private FlightSearchMock flightBack;

    public FlightSearchRound(FlightSearchMock f1, FlightSearchMock f2){
        this.flightTo = f1;
        this.flightBack = f2;
    }
}
