package mock;

public class FlightMock {

    private String from;
    private String to;
    private String date;
    private int availability; // availability

    public FlightMock(String f, String t, String d, int n){
        this.from = f;
        this.to = t;
        this.date = d;
        this.availability = n;
    }

    /**
     * book flight for n persons
     * @param n
     */
    public void book(int n){
        this.availability-=n;
    }

    public int getAvailability() {
        return this.availability;
    }

    public String toString() {
        return String.format("%s - %s, %s, %d", from, to, date, availability);
    }

}
