package mock;

public class HotelMock {
    private int hotelID;
    private String name;
    private String location; //Location
    private String fromDate;
    private String toDate;
    private int size;
    private int availability; // availability

    public HotelMock(int id, String nameHotel, String loc, String fd,String td, int s, int n) {
        this.hotelID = id;
        this.name = nameHotel;
        this.location = loc;
        this.fromDate = fd;
        this.toDate = td;
        this.size = s;
        this.availability = n;
    }



    /**
     * book n hotel rooms
     * @param n
     */
    public void book(int n){
        this.availability-=n;
    }

    public int getAvailability() {
        return this.availability;
    }

    public String toString() {
        return String.format("%s, %s - %s, %s, %d, %d",name,location, fromDate,toDate, size, availability);
    }

}
