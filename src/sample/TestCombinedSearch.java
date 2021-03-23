package sample;

public class TestCombinedSearch {
    //boolean findFlight, boolean findHotel, boolean findDayTour, boolean findRoundTripFlight, String from, String to, Date d, int n
    CombinedSearch search1 = new CombinedSearch();
    private String[] expectedResultFlights = "Flugnr1, Flugnr2, Flugnr3";
    private String[] expectedResultHotels = "Hotel1, Hotel2, Hotel3";
    private String[] expectedResultDayTours = "DayTour1, DayTour2, DayTour3";

    @Test
    public void testFlight() {
        assertEquals(expectedResultFlights,search1.CombinedSearch(true, false, false, false,
                "Reykjavík","Akureyri", "dagsetning", 4));
    }

    @Test
    public void testHotel() {
        assertEquals(expectedResultHotels,search1.CombinedSearch(false, true, false, false,
                "Reykjavík","Akureyri", "dagsetning", 4));
    }

    @Test
    public void testDayTours() {
        assertEquals(expectedResultHotels,search1.CombinedSearch(false, false, true, false,
                "Reykjavík","Akureyri", "dagsetning", 4));
    }
}
