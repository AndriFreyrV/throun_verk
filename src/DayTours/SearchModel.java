package DayTours;

import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class SearchModel
{
    public static ObservableList<TimeFrame> TIME_FRAMES = FXCollections.observableArrayList(
            TimeFrame.ANY,
            TimeFrame.MORNING,
            TimeFrame.AFTERNOON,
            TimeFrame.EVENING,
            TimeFrame.NIGHT
    );

    public static ObservableList<Duration> DURATIONS = FXCollections.observableArrayList(
            Duration.SHORT,
            Duration.MEDIUM,
            Duration.LONG,
            Duration.VERY_LONG,
            Duration.EXTREMELY_LONG
    );

    public static ObservableList<TourType> TOUR_TYPES = FXCollections.observableArrayList(
            TourType.ANY,
            TourType.CITY_TOUR,
            TourType.GLACIER_TOUR,
            TourType.HIKING_TOUR,
            TourType.ICECAVE_TOUR,
            TourType.PUFFIN_TOUR,
            TourType.WHALEWATCHING_TOUR
    );

    public static ObservableList<PriceRange> PRICE_RANGES = FXCollections.observableArrayList(
            new PriceRange(),
            new PriceRange(0, 500),
            new PriceRange(500, 2000),
            new PriceRange(2000, 5000),
            new PriceRange(5000, 15000),
            new PriceRange(15000, 50000)
    );

    private int persons;
    private LocalDate fromDate;
    private LocalDate toDate;
    private TimeFrame timeFrame;
    private PriceRange priceRange;
    private TourType tourType;
    private Duration duration;

    public void setToDate (LocalDate toDate)
    {
        this.toDate = toDate;
    }

    public LocalDate getToDate ()
    {
        return toDate;
    }

    public void setFromDate (LocalDate fromDate)
    {
        this.fromDate = fromDate;
    }

    public LocalDate getFromDate ()
    {
        return fromDate;
    }

    public TourType getTourType ()
    {
        return tourType;
    }

    public void setTourType (TourType tourType)
    {
        this.tourType = tourType;
    }

    public void setPriceRange (PriceRange priceRange)
    {
        this.priceRange = priceRange;
    }

    public PriceRange getPriceRange ()
    {
        return priceRange;
    }

    public Duration getDuration ()
    {
        return duration;
    }

    public void setDuration (Duration duration)
    {
        this.duration = duration;
    }

    public void setTimeFrame (TimeFrame timeFrame)
    {
        this.timeFrame = timeFrame;
    }

    public TimeFrame getTimeFrame ()
    {
        return timeFrame;
    }

    public int getPersons ()
    {
        return persons;
    }

    public void setPersons (int persons)
    {
        this.persons = persons;
    }
}