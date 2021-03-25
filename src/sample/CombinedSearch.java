package sample;

import mock.FlightSearchMock;

public class CombinedSearch {


    public String[] CombinedSearch(boolean findFlight, boolean findHotel, boolean findDayTour, boolean findRoundTripFlight, String from, String to, String d, int n){
        String[] Flights;
        String[] Villa = {"EKKERT"};
        if (findFlight == true) {
           Flights = getFlightSearch(from, to, d, n);
            return Flights;
        }
        return Villa;
    }


    private String[] getFlightSearch(String from, String to, String d, int n){
        FlightSearch fSearch = new FlightSearch();
        String[] FlightA;
        FlightA = fSearch.flightSearch(from,to,d,n);
        return FlightA;
    }


}
