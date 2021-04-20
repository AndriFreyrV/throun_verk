package sample;

import DayTours.Tour;
import Flight.Flight;
import hotels.Hotel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BookingConfirmedController implements Initializable {

    @FXML
    private ListView<Flight> flightsList;
    @FXML
    private ListView<Hotel> hotelsList;
    @FXML
    private ListView<Tour> toursList;
    @FXML
    private Label confirmLabel;
    @FXML
    private Label costLabel;
    @FXML
    private Label labelNPersons;


    private ObservableList<Hotel> hotels;
    private ObservableList<Flight> flights;
    private ObservableList<Tour> tours;

    public void setFlights(ObservableList<Flight> flights) {
        this.flights = flights;
        this.flightsList.setItems(this.flights);
    }

    public void setHotels(ObservableList<Hotel> hotels) {
        this.hotels = hotels;
        this.hotelsList.setItems(this.hotels);
    }
    public void setTours(ObservableList<Tour> tours){
        this.tours = tours;
        this.toursList.setItems(this.tours);
    }

    public void writeLabel(String s){
        confirmLabel.setText(s);
    }
    public void writeCost(String s){
        costLabel.setText(s);
    }
    public void writeNPersons(String s){
        labelNPersons.setText(s);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
