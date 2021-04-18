package hotels;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private Integer price;
    private String hotelName;
    private String hotelPlace;
    private Integer numBeds;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Hotel(Integer price, String hotelName, String hotelPlace, Integer numBeds, LocalDate dateFrom,
            LocalDate dateTo) {
        super();
        this.price = price;
        this.hotelName = hotelName;
        this.hotelPlace = hotelPlace;
        this.numBeds = numBeds;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }


    public String toString() {
        return String.format("%s - %s - Number of beds: %d Price: %d", hotelName, hotelPlace, numBeds, price);
    }


    private static List<LocalDate> getDateRange(LocalDate start, LocalDate end) {

        List<LocalDate> ret = new ArrayList<LocalDate>();
        LocalDate tmp = start;
        while (tmp.isBefore(end) || tmp.equals(end)) {
            ret.add(tmp);
            tmp = tmp.plusDays(1);
        }
        return ret;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomNumber() {
        return hotelPlace;
    }

    public void setRoomNumber(String roomNumber) {
        this.hotelPlace = hotelPlace;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getHotelPlace() {
        return hotelPlace;
    }

    public void setHotelPlace(String hotelPlace) {
        this.hotelPlace = hotelPlace;
    }

    public Integer getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(Integer numBeds) {
        this.numBeds = numBeds;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }
}
