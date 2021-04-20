package sample;

import Flight.Flight;
import hotels.Hotel;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import mock.FlightMock;
import mock.FlightSearchMock;
import mock.HotelMock;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.scene.control.Label;



public class bookingController implements Initializable {


    @FXML
    private ListView<Flight> flightsList;
    @FXML
    private ListView<Hotel> hotelsList;
    @FXML
    private ListView<String> cartList; // var ListView<FlightMock>
    @FXML
    private Button orderBtn;
    @FXML
    private Button RemoveBtn;
    @FXML
    private Button addFlightBtn;
    @FXML
    private Label costLabel;

    private ObservableList<Flight> flights;
    //private ObservableList<FlightMock> flightsSelected; // selected flights
    private ObservableList<String> objectsSelected; // selected flights

    private ObservableList<Hotel> hotels;

    private CombinedSearch cSearch;

    private int nPersons; // number of individuals to book for

    private int cartPrice; // combined cost of items in cart:

    private SimpleStringProperty cartPriceProp;


    private HashMap<String, Object> cartMap;

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public void setDates(LocalDate dF, LocalDate dT){
        this.dateFrom = dF;
        this.dateTo = dT;
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cartPrice = 0;
        cartPriceProp = new SimpleStringProperty();

        cartPriceProp.setValue(String.valueOf(cartPrice));

        costLabel.textProperty().bind(cartPriceProp);

        cartMap = new HashMap<>();


        objectsSelected = FXCollections.observableArrayList();
        cartList.setItems(objectsSelected);


    }


    public void setFlightsList(ObservableList<Flight> fList) {
        this.flights = fList;
        flightsList.setItems(this.flights);
    }

    public void setHotelsList(ObservableList<Hotel> hList){
        this.hotels = hList;
        hotelsList.setItems(this.hotels);
    }

    public void setNPersons(int n){
        this.nPersons = n;
    }




    public void selectFlightAction(ActionEvent e) {
        Flight flightSelected = flightsList.getSelectionModel().getSelectedItem();
        cartMap.put(flightSelected.toString(), flightSelected);
        cartPrice += flightSelected.getCost()*nPersons;
        int idx = flightsList.getSelectionModel().getSelectedIndex();
        System.out.println(String.format("%s - %d",flightSelected,idx));
        objectsSelected.add(flightSelected.toString());
        flights.remove(idx);
        cartPriceProp.setValue(String.valueOf(cartPrice));

    }


    public void selectHotelAction(ActionEvent e) {
        Hotel hotelSelected = hotelsList.getSelectionModel().getSelectedItem();
        long nNights  = dateFrom.until(dateTo, ChronoUnit.DAYS);
        cartPrice += hotelSelected.getPrice()*nPersons*nNights; // book hotel stay for nPersons many individuals
        cartMap.put(hotelSelected.toString(), hotelSelected);
        int idx = hotelsList.getSelectionModel().getSelectedIndex();
        System.out.println(String.format("%s - %d",hotelSelected,idx));
        objectsSelected.add(hotelSelected.toString());
        hotels.remove(idx);
        cartPriceProp.setValue(String.valueOf(cartPrice));
    }


    public void removeCartAction(ActionEvent e){
        String key = cartList.getSelectionModel().getSelectedItem();
        int idx = cartList.getSelectionModel().getSelectedIndex();
        //flights.add(fOut);
        //System.out.println(cartMap.get(objOut.getClass()));

        Object objOut = cartMap.get(key);
        System.out.println(objOut.getClass());

        if(objOut instanceof Flight){
            System.out.println("flight remove");
            flights.add((Flight) cartMap.get(key));
            objectsSelected.remove(idx);
        }
        else if(objOut instanceof Hotel){
            System.out.println("hotel remove");
            hotels.add((Hotel)cartMap.get(key));
            objectsSelected.remove(idx);
        }

    }

    public void orderAction(ActionEvent e){
        ObservableList<Flight> flightsOut = FXCollections.observableArrayList();
        ObservableList<Hotel> hotelsOut = FXCollections.observableArrayList();


        for(String s:objectsSelected){

            if(cartMap.get(s) instanceof Flight) {
                Flight fl = (Flight) (cartMap.get(s));
                System.out.println(String.format("State before order placed:\n %s", fl));
                try {
                    fl.book(this.nPersons); // book flight, should decrease availability
                    flightsOut.add(fl);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println(String.format("State after order placed:\n %s", fl));
            }

            // vantar virkni fyrir venjulegan Hotel hlut, vitum ekki alveg hvernig bókun fer fram !!
            else if(cartMap.get(s) instanceof Hotel){
                Hotel h = (Hotel)(cartMap.get(s));
                hotelsOut.add(h);

                //System.out.println(String.format("State before order placed: \n%s", h));
                //h.book(this.nPersons);
                //System.out.println(String.format("State after order placed: \n%s", h));
            }
        }

        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bookingConfirmed.fxml"));
            root = loader.load();
            BookingConfirmedController bc = loader.getController();
            bc.setFlights(flightsOut);
            bc.setHotels(hotelsOut);


            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String timeOrder = dtf.format(now);
            bc.writeLabel(String.format("Booking confirmed at %s", timeOrder));
            bc.writeCost(String.format("Total cost: %d kr.", this.cartPrice));
            bc.writeNPersons(String.format("Booking for %d persons", this.nPersons));

            Stage stage = new Stage();
            stage.setTitle("Booking completed");
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch (IOException err) {
            err.printStackTrace();
        }


        // veit ekki hvernig þetta er gert öðruvísi
        Stage stage = (Stage) orderBtn.getScene().getWindow();
        stage.close();
    }

}