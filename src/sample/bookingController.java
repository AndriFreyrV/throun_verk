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

import java.net.URL;
import java.util.ResourceBundle;



public class bookingController implements Initializable {


    @FXML
    private ListView<FlightMock> flightsList;
    @FXML
    private ListView<FlightMock> cartList;
    @FXML
    private Button orderBtn;
    @FXML
    private Button RemoveBtn;

    private ObservableList<FlightMock> flights;
    private ObservableList<FlightMock> flightsSelected; // selected flights

    private int nPersons; // number of individuals to book for

    // þetta er listinn af flugunum
    /*
    private ObservableList<FlightMock> fList; // þarf sennilega ekki að nota
    */


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        flightsSelected = FXCollections.observableArrayList();
        cartList.setItems(flightsSelected);

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
        int idx = flightsList.getSelectionModel().getSelectedIndex();
        System.out.println(String.format("%s - %d",flightSelected,idx));
        flightsSelected.add(flightSelected);
        flights.remove(idx);

    }
    public void removeFlightAction(ActionEvent e){
        FlightMock fOut = cartList.getSelectionModel().getSelectedItem();
        int idx = cartList.getSelectionModel().getSelectedIndex();
        flights.add(fOut);
        flightsSelected.remove(idx);
    }

    public void orderFlightsAction(ActionEvent e){
        for(FlightMock fl:flightsSelected){
            System.out.println(String.format("State before order placed:\n %s", fl));
            fl.book(this.nPersons); // book flight, should decrease availability
            System.out.println(String.format("State after order placed:\n %s", fl));
        }
        // ógeðsleg lausn
        Stage stage = (Stage) orderBtn.getScene().getWindow();
        stage.close();
    }

}