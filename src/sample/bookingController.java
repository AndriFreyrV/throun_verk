package sample;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import mock.FlightMock;
import mock.FlightSearchMock;
import mock.HotelMock;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.scene.control.Label;



public class bookingController implements Initializable {


    @FXML
    private ListView<FlightMock> flightsList;
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

    private ObservableList<FlightMock> flights;
    //private ObservableList<FlightMock> flightsSelected; // selected flights
    private ObservableList<String> objectsSelected; // selected flights

    private ObservableList<Hotel> hotels;

    private CombinedSearch cSearch;

    private int nPersons; // number of individuals to book for

    private int cartPrice; // combined cost of items in cart:

    private SimpleStringProperty cartPriceProp;


    private HashMap<String, Object> cartMap;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cartPrice = 0;
        cartPriceProp = new SimpleStringProperty();

        cartPriceProp.setValue(String.valueOf(cartPrice));

        costLabel.textProperty().bind(cartPriceProp);

        cartMap = new HashMap<>();


        objectsSelected = FXCollections.observableArrayList();
        cartList.setItems(objectsSelected);


        // þessi kóði var áður í mainController, hreinna að hafa þetta hér.
        /*
        FlightSearchMock fSearch = CSearch.flightSearch();
        ArrayList<FlightMock> flightsOut = fSearch.Search();

        // hér koma niðurstöður, byrjum að prenta, seinna geymum við hluti og
        // birtum í nýjum glugga
        System.out.println("Available flights:\n");
        for(FlightMock fl:flightsOut){
            System.out.println(fl);
        }

         */


    }


    public void setFlightsList(ObservableList<FlightMock> fList) {
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
        FlightMock flightSelected = flightsList.getSelectionModel().getSelectedItem();
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
        cartPrice += hotelSelected.getPrice()*nPersons; // book hotel stay for nPersons many individuals
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

        if(objOut instanceof FlightMock){
            System.out.println("flight remove");
            flights.add((FlightMock) cartMap.get(key));
            objectsSelected.remove(idx);
        }
        else if(objOut instanceof Hotel){
            System.out.println("hotel remove");
            hotels.add((Hotel)cartMap.get(key));
            objectsSelected.remove(idx);
        }
        
    }

    public void orderAction(ActionEvent e){
        for(String s:objectsSelected){

            if(cartMap.get(s) instanceof FlightMock) {
                FlightMock fl = (FlightMock) (cartMap.get(s));
                System.out.println(String.format("State before order placed:\n %s", fl));
                fl.book(this.nPersons); // book flight, should decrease availability
                System.out.println(String.format("State after order placed:\n %s", fl));
            }


            // vantar virkni fyrir venjulegan Hotel hlut, vitum ekki alveg hvernig bókun fer fram !!
            else if(cartMap.get(s) instanceof HotelMock){
                HotelMock h = (HotelMock)(cartMap.get(s));
                System.out.println(String.format("State before order placed: \n%s", h));
                h.book(this.nPersons);
                System.out.println(String.format("State after order placed: \n%s", h));
            }
        }

        // veit ekki hvernig þetta er gert öðruvísi
        Stage stage = (Stage) orderBtn.getScene().getWindow();
        stage.close();
    }

}