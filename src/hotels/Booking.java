package hotels;


import java.time.LocalDate;

public class Booking {
    private Integer numBeds;
    private String hotelName;

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Booking(Integer numBeds, String hotelName, LocalDate dateFrom, LocalDate dateTo) {
        this.numBeds = numBeds;
        this.hotelName = hotelName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Integer getNumBeds() {
        return numBeds;
    }

    public String getHotelName() {
        return hotelName;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

}
