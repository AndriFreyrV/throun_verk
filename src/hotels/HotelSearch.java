package hotels;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelSearch {
    private DataFactory df = new DataFactory();

    private List<Hotel> availibleHotels;
    private List<Booking> bookings;

    public HotelSearch() {
        availibleHotels = df.getHotels();
        bookings = new ArrayList<Booking>();
    }

    public boolean isHotelAvailable(Hotel hotel, Integer numberOfBeds, LocalDate dateFrom, LocalDate dateTo) {
        int occupiedNumberOfBeds = 0;

        for (Booking b : bookings) {
            if (!b.getHotelName().equals(hotel.getHotelName()))
                continue;
            if (!(b.getDateFrom().compareTo(dateFrom) <= 0 && dateTo.compareTo(b.getDateTo()) <= 0))
                continue;

            occupiedNumberOfBeds += b.getNumBeds();
        }

        // Ætti að ítra yfir alla daga í tímabilinu og finna max fjölda upptekinna rúma
        // og bera það saman við fjölda rúma í hótelinu til að passa að það sé alltaf
        // nóg af rúmum laus fyrir bókunina.

        // Þetta er lata leiðin sem virkar eiginlega bara alls ekki en lítur út eins og
        // við séum að gera eitthvað. :P
        return hotel.getNumBeds() >= numberOfBeds + occupiedNumberOfBeds;
    }

    public ArrayList<Hotel> search(Integer price, String hotelName, String hotelPlace, Integer numBeds, LocalDate dateFrom,
            LocalDate dateTo) {
        ArrayList<Hotel> results = new ArrayList<>();
        // finna viðeigandi hotel
        for (Hotel h : availibleHotels) {
            if (price != null && h.getPrice() > price)
                continue; // Ekki skila hóteli ef það er of dýrt
            if (hotelName != null && !h.getHotelName().toLowerCase().contains(hotelName.toLowerCase()))
                continue; // Ekki skila hóteli ef nafn þess passar ekki við leitarstreng
            if (hotelPlace != null && !h.getHotelPlace().toLowerCase().contains(hotelPlace.toLowerCase()))
                continue; // Ekki skila hóteli ef staðsetning þess passar ekki við leitarstreng
            if (numBeds != null && h.getNumBeds() < numBeds)
                continue;

            if ((dateFrom != null && dateTo != null && numBeds != null)
                    && !isHotelAvailable(h, numBeds, dateFrom, dateTo))
                continue;

            results.add(h);
        }
        return results;
    }

    // Skilar Booking ef það gekk að bóka annars null
    public Booking book(Hotel h, Integer numBeds, LocalDate dateFrom, LocalDate dateTo) {
        if (h == null || numBeds == null || dateFrom == null || dateTo == null)
            return null;

        if (!isHotelAvailable(h, numBeds, dateFrom, dateTo))
            return null;

        Booking booking = new Booking(numBeds, h.getHotelName(), dateFrom, dateTo);
        bookings.add(booking);
        return booking;
    }
}
