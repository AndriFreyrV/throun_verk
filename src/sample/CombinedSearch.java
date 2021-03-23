package sample;

import mock.FlightSearchMock;

public class CombinedSearch {

    public String[] CombinedSearch(boolean findFlight, boolean findHotel, boolean findDayTour, boolean findRoundTripFlight, String from, String to, Date d, int n){
        String[] Flights;
        if (findRoundTripFlight == true) {
            Flights = getFlightSearchMock(from, to, d, n);
        }

    }

    private String[] getFlightSearchMock(String from, String to, Date d, int n){
        String[] FlightA;
        FlightA = FlightSearchMock(from,to,d,n);
        return FlightA;
    }
}
