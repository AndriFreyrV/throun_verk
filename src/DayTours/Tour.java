package DayTours;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("HH:mm");

        return String.format("Name: %s  - Price: %d - Time: %s %s",this.tourType.getValue().toString(), this.price.getValue(), this.date.getValue().format(fmt1), this.time.getValue().format(fmt2));
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