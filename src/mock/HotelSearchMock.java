package mock;
import java.util.ArrayList;
import java.util.Random;

public class HotelSearchMock {

    private final String[] places = {"Reykjavík", "Akureyri", "Egilstaðir", "Ísafjörður"};

    private int hotelID;
    private String hotelName;
    private String location;
    private String dateTo;
    private String dateFrom;
    private int n_beds;
    private int n_rooms;

    public HotelSearchMock(String loc, String fd, String td, int s) {
        this.location = loc;
        this.dateTo = td;
        this.dateFrom = fd;
        this.n_beds = s;
    }

    /**
     * býr til hotel objects
     * @return
     */
    public ArrayList<HotelMock> genHotel(){
        Random r = new Random();
        ArrayList<HotelMock> hotelsInTown = new ArrayList<HotelMock>();

        int n_hotels = r.nextInt(10);
        for(int i = 0;i<n_hotels;i++) {
            HotelMock hotel = new HotelMock(i, this.location+String.format("- Hotel %d", i), this.location, this.dateFrom, this.dateTo, this.n_beds, r.nextInt(25));
            hotelsInTown.add(hotel);
        }
        return hotelsInTown;
    }

    /**
     * Sækir hótel og síar út ef það er pláss fyrir fólkið(n_beds)
     * @return
     */
    public ArrayList<HotelMock> Search(){
        ArrayList<HotelMock> hotelsInTown = new ArrayList<HotelMock>();
        ArrayList<HotelMock> hotelsGen = genHotel();
        for(HotelMock h: hotelsGen) {
            if(this.n_rooms<=h.getAvailability()) {
                hotelsInTown.add(h);
            }
        }
        return hotelsInTown;
    }

    public static void main(String[] args){

    }
}
