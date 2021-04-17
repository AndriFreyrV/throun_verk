package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mock.FlightMock;
import mock.FlightSearchMock;
import mock.HotelMock;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ComboBox<Integer> howMany; // number of persons to use in search, n_persons param
    @FXML
    private TextField locationFrom;
    @FXML
    private TextField locationTo;
    @FXML
    private DatePicker dateFrom;
    @FXML
    private DatePicker dateTo;
    @FXML
    private ToggleGroup flightsGroup;
    @FXML
    private RadioButton hotelRadio;
    @FXML
    private RadioButton dayTripRadio;
    @FXML
    private RadioButton flightRadio;
    @FXML
    private RadioButton roundTripRadio;
    @FXML
    private Button submitButton;
    @FXML
    private Label errorLabel;


    private final Integer[] num_vals = {1,2,3,4,5,6,7,8,9,10};

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        addNums();

        /*
        submitButton.disableProperty()
                .bind(locationFrom.textProperty().isEmpty().
                        or(dateFrom.valueProperty().isNull())
                .or(howMany.valueProperty().isNull())
                .or((flightsGroup.selectedToggleProperty().isNull())
                    .and(hotelRadio.selectedProperty().not()
                    .and(dayTripRadio.selectedProperty().not()))));

         */
        submitButton.disableProperty()
                .bind(howMany.valueProperty().isNull().or(
                        (flightsGroup.selectedToggleProperty().isNull())
                                .and(hotelRadio.selectedProperty().not()
                                        .and(dayTripRadio.selectedProperty().not()))
                ));



        // have to select dataFrom to select DateTo
        dateTo.disableProperty().bind(dateFrom.valueProperty().isNull());

        // disable dates from past
        dateTo.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate d = dateFrom.getValue();
                setDisable(empty || date.compareTo(d) <= 0 );
            }
        });


    }


    /**
     * Sets values to list of number of persons
     */
    public void addNums(){
        ObservableList<Integer> vals_ls =
                FXCollections.observableArrayList(num_vals);
        howMany.setItems(vals_ls);
    }
}
