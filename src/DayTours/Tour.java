package DayTours;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Tour
{
    private int tripID;
    private SimpleObjectProperty<TourType> tourType = new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalTime> time = new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private SimpleIntegerProperty price = new SimpleIntegerProperty();

    public Tour (int tripID, TourType tourType, int price, LocalDateTime date)
    {
        this.tripID = tripID;
        this.tourType.setValue(tourType);
        this.date.setValue(date.toLocalDate());
        this.time.setValue(date.toLocalTime());
        this.price.set(price);
    }

    @Override
    public String toString() {
        //String ret = "[Tour: " + this.tripID + "]";
        return String.format("Name: %s  - Price: %d",this.tourType.getValue().toString(), this.price.getValue());
    }

    public TourType getTourType ()
    {
        return tourType.get();
    }

    public int getTripID ()
    {
        return tripID;
    }

    public void setPrice (int price)
    {
        this.price.set(price);
    }

    public int getPrice ()
    {
        return price.get();
    }

    public SimpleIntegerProperty getPriceProperty ()
    {
        return price;
    }

    public ObjectProperty<LocalDate> getLdProperty ()
    {
        return date;
    }

    public ObjectProperty<LocalTime> getLtProperty ()
    {
        return time;
    }

    public ObjectProperty<TourType> getTourTypeProperty ()
    {
        return tourType;
    }


}