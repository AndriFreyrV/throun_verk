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
    private ListView<String> cartList; // var ListView<FlightMock>
    @FXML
    private Button orderBtn;
    @FXML
    private Button RemoveBtn;
    @FXML
    private Button addFlightBtn;

    private ObservableList<FlightMock> flights;
    //private ObservableList<FlightMock> flightsSelected; // selected flights
    private ObservableList<String> flightsSelected; // selected flights

    private CombinedSearch cSearch;

    private int nPersons; // number of individuals to book for

    private HashMap<String, Object> cartMap;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cartMap = new HashMap<>();


        flightsSelected = FXCollections.observableArrayList();
        cartList.setItems(flightsSelected);


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

    public void setcSearch(CombinedSearch cSearch) {
        this.cSearch = cSearch;
    }

    public void setFlightsList(ObservableList<FlightMock> fList) {
        this.flights = fList;
        flightsList.setItems(this.flights);
    }
    public void setNPersons(int n){
        this.nPersons = n;
    }




    public void selectFlightAction(ActionEvent e) {
        FlightMock flightSelected = flightsList.getSelectionModel().getSelectedItem();
        cartMap.put(flightSelected.toString(), flightSelected);
        int idx = flightsList.getSelectionModel().getSelectedIndex();
        System.out.println(String.format("%s - %d",flightSelected,idx));
        flightsSelected.add(flightSelected.toString());
        flights.remove(idx);

    }
    public void removeFlightAction(ActionEvent e){
        String fOut = cartList.getSelectionModel().getSelectedItem();
        int idx = cartList.getSelectionModel().getSelectedIndex();
        //flights.add(fOut);
        System.out.println(cartMap.get(fOut.getClass()));

        flights.add((FlightMock) cartMap.get(fOut));
        flightsSelected.remove(idx);
    }

    public void orderAction(ActionEvent e){
        for(String fl:flightsSelected){

            /*
            if (cartMap.get(fl) instanceof FlightMock) {
                // kóði til að bóka flightMock svipað og hér undir
            }
            else if(cartMap.get(fl) instanceof HotelMock) {
                // kastað yfir í hotelMock ofl.
            }

             */


            System.out.println(String.format("State before order placed:\n %s", fl));
            FlightMock flObj = (FlightMock)(cartMap.get(fl));
            flObj.book(this.nPersons); // book flight, should decrease availability
            System.out.println(String.format("State after order placed:\n %s", fl));
        }
        // veit ekki hvernig þetta er gert öðruvísi
        Stage stage = (Stage) orderBtn.getScene().getWindow();
        stage.close();
    }

}