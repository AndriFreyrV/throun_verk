package mock;

public class FlightMock {

    private String from;
    private String to;
    private String date;
    private int availability; // availability
    private int cost; // cost per seat

    public FlightMock(String f, String t, String d, int n, int c){
        this.from = f;
        this.to = t;
        this.date = d;
        this.availability = n;
        this.cost = c;
    }

    /**
     * book flight for n persons
     * @param n
     */
    public void book(int n){
        this.availability-=n;
    }

    public int getCost() {
        return cost;
    }

    public int getAvailability() {
        return this.availability;
    }

    public String toString() {
        return String.format("From: %s - To: %s, Date: %s, Price: %d, Available seats: %d", from, to, date, cost, availability);
    }

}
