package DayTours;

public class BookingControllerTour
{
    public DatabaseUtility dbutil;
    public BookingControllerTour()
    {
        dbutil = new DatabaseUtility();
    }

    public Boolean book(int tripID, int seats)
    {
        int space = dbutil.getAvailability(tripID);
        if(seats > space)
            return false;
        return dbutil.createBooking(tripID, 0, seats);
    }
}
