package sample;

import javafx.application.Platform;
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



public class bookingController implements Initializable {


    @FXML
    private ListView<FlightMock> flightsList;
    @FXML
    private ListView<HotelMock> hotelsList;
    @FXML
    private ListView<String> cartList; // var ListView<FlightMock>
    @FXML
    private Button orderBtn;
    @FXML
    private Button RemoveBtn;
    @FXML
    private Button addFlightBtn;

    private ObservableList<FlightMock> flights;
    //private ObservableList<FlightMock> flightsSelected; // selected flights
    private ObservableList<String> objectsSelected; // selected flights

    private ObservableList<HotelMock> hotels;

    private CombinedSearch cSearch;

    private int nPersons; // number of individuals to book for

    private HashMap<String, Object> cartMap;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
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

    public void setHotelsList(ObservableList<HotelMock> hList){
        this.hotels = hList;
        hotelsList.setItems(this.hotels);
    }

    public void setNPersons(int n){
        this.nPersons = n;
    }




    public void selectFlightAction(ActionEvent e) {
        FlightMock flightSelected = flightsList.getSelectionModel().getSelectedItem();
        cartMap.put(flightSelected.toString(), flightSelected);
        int idx = flightsList.getSelectionModel().getSelectedIndex();
        System.out.println(String.format("%s - %d",flightSelected,idx));
        objectsSelected.add(flightSelected.toString());
        flights.remove(idx);

    }


    public void selectHotelAction(ActionEvent e) {
        HotelMock hotelSelected = hotelsList.getSelectionModel().getSelectedItem();
        cartMap.put(hotelSelected.toString(), hotelSelected);
        int idx = hotelsList.getSelectionModel().getSelectedIndex();
        System.out.println(String.format("%s - %d",hotelSelected,idx));
        objectsSelected.add(hotelSelected.toString());

        hotels.remove(idx);
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
        else if(objOut instanceof HotelMock){
            System.out.println("hotel remove");
            hotels.add((HotelMock)cartMap.get(key));
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