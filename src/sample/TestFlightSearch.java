package sample;
import org.junit.*;
import static org.junit.Assert.*;

public class TestFlightSearch {
    FlightSearch fSearch1 = new FlightSearch();

    private final String[] expectedResultFlights1 = {"Flugnr1", "Flugnr2", "Flugnr3"};
    private final String[] expectedResultFlights2 = {"Flugnr2"};
    private final String[] expectedResultFlights3 = {"Flugnr2", "Flugnr3", "Flug4"};
    private final String[] expectedResultFlights4 = {"Flugnr3", "Flugnr5"};

    @Test
    public void testFlight1() {
        // Hér er verið að leita af öllum flugum frá Reykjavík til Akureyrar 24/7/2021 fyrir 4.
        // Here we are looking for all flights from Reykjavík to Akureyri on the 24/7/2021 for 4.
        assertEquals(expectedResultFlights1,fSearch1.flightSearch("Reykjavík","Akureyri", "24/7/2021", 4));
    }

    @Test
    public void testFlight2(){
        // Hér er verið að leita af öllum flugum frá Akureyri til Reykjavík 24/7/2021 fyrir 5.
        // Here we are looking for all flights from Akureyri to Reykjavík on the 24/7/2021 for 5.
        assertEquals(expectedResultFlights2,fSearch1.flightSearch("Akureyri", "Reykjavík","24/7/2021", 5));
    }

    @Test
    public void testFlight3(){
        // Hér er verið að leita af öllum flugum frá Reykjavík 24/7/2021 fyrir 3.
        // Here we are looking for all flights from Reykjavík on the 24/7/2021 for 3.
        assertEquals(expectedResultFlights3,fSearch1.flightSearch("Reykjavík", "","24/7/2021", 3));
    }

    @Test
    public void testFlight4(){
        // Hér er verið að leita af öllum flugum til Reykjavík 24/7/2021 fyrir 5.
        // Here we are looking for all flights to Reykjavík on the 24/7/2021 for 5.
        assertEquals(expectedResultFlights4,fSearch1.flightSearch("", "Reykjavík","24/7/2021", 5));
    }

    @Test
    public void testFlight5(){
        // Hér er verið að leita af öllum flugum Frá Reykjavík til Reykjavík 24/7/2021 fyrir 5. Sem ætti að skila villu.
        // Here we are looking for all flights from Reykjavík to Reykjavík on the 24/7/2021 for 5. This should return an error.
        assertEquals(expectedResultFlights2,fSearch1.flightSearch("Reykjavík", "Reykjavík","24/7/2021", 5));
    }

    @Test
    public void testFlight6(){
        // Hér er verið að leita af flugum með dagsetningu sem er nú þegar liðin. Sem ætti að skila villu.
        // Here we are looking for flights with a date that has already passed. This should return a error.
        assertEquals(expectedResultFlights4,fSearch1.flightSearch("Reykjavík", "Akureyri","24/7/2020", 5));
    }

    @Test
    public void testFlight7(){
        // Hér er verið að leita af flugi með innsláttarvillu. Sem ætti að skila villu.
        // Here we are looking for flights with typo. This should return a error.
        assertEquals(expectedResultFlights4,fSearch1.flightSearch("Reykjavík", "Agureyri","24/7/2021", 1));
    }


}
