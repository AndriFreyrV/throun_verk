package sample;

import hotels.Hotel;
import hotels.HotelSearch;
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
import mock.HotelSearchMock;

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


    public void searchAction(ActionEvent e) {
        // þarf að handle-a empty field í dateTo

        ObservableList<FlightMock> fListOut;
        fListOut = FXCollections.observableArrayList(); // list of bookable flights

        ObservableList<Hotel> hListOut;
        hListOut = FXCollections.observableArrayList(); // list of bookable hotels

        //boolean findFlight, boolean findHotel, boolean findDayTour, boolean findRoundTripFlight, String from, String to, String d, int n
        CombinedSearch CSearch = new CombinedSearch(
                flightRadio.isSelected(),
                hotelRadio.isSelected(),
                dayTripRadio.isSelected(),
                roundTripRadio.isSelected(),
                locationFrom.getText(),
                locationTo.getText(),
                howMany.getValue()
        );


        if(CSearch.isFindRoundTripFlight()){
            if(locationFrom.getText().equals("") || locationTo.getText().equals("") || dateTo.getValue() == null || dateFrom.getValue() == null){
                System.out.println("...debug...");
                errorLabel.setText("To search for round trip you need locationFrom, locationTo and dateTo, dateFrom");
                return;
            }

            CSearch.setDateFrom(dateFrom.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            CSearch.setDateTo(dateTo.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            errorLabel.setText("");// clean error message


            FlightSearchRound flightRound = CSearch.flightSearchRound();
            FlightSearchMock flightSearchTo = flightRound.getFlightTo();
            FlightSearchMock flightSearchBack = flightRound.getFlightBack();

            ArrayList<FlightMock> flightsTo = flightSearchTo.Search();
            for(FlightMock fl:flightsTo){
                fListOut.add(fl);
            }

            ArrayList<FlightMock> flightsBack = flightSearchBack.Search();
            for(FlightMock fl:flightsBack){
                fListOut.add(fl);
            }
        }

        else if(CSearch.isFindFlight()){
            if(locationFrom.getText().equals("") || locationTo.getText().equals("") || dateFrom.getValue() == null ) {
                errorLabel.setText("To search for one way trip you need locationFrom, locationTo and dateFrom");
                return;
            }
            CSearch.setDateFrom(dateFrom.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            errorLabel.setText("");// clean error label

            FlightSearchMock fSearch = CSearch.flightSearch();
            ArrayList<FlightMock> flightsOut = fSearch.Search();

            for(FlightMock fl:flightsOut){
                fListOut.add(fl);
            }
        }

        if(CSearch.isFindHotel()){
            System.out.println("ok search hotel");
            if(locationTo.equals("") || dateFrom.getValue() == null || dateTo.getValue() == null){
                errorLabel.setText("To search for hotel the fields locationTo, dateFrom and dateTo need to be filled");
                return;
            }
            CSearch.setDateFrom(dateFrom.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            CSearch.setDateTo(dateTo.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            errorLabel.setText("");// clean error message

            HotelSearchMock hSearch = CSearch.hotelSearch();
            ArrayList<HotelMock> hotelsOut = hSearch.Search();

            HotelSearch hSearch1 = new HotelSearch();
            ArrayList<Hotel> h_list = hSearch1.search(null, null, this.locationTo.getText(), howMany.getValue(), dateFrom.getValue(),dateTo.getValue());

            System.out.println("List of hotels from H group");
            for(Hotel h: h_list){
                System.out.println(h);
                hListOut.add(h);
            }


            /*
            for(HotelMock h: hotelsOut){
                hListOut.add(h);
            }

             */

        }



        // load booking Controller with results from search
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("booking.fxml"));
            root = loader.load();
            bookingController bc = loader.getController();
            bc.setFlightsList(fListOut);
            bc.setHotelsList(hListOut);
            bc.setNPersons(howMany.getValue());

            Stage stage = new Stage();
            stage.setTitle("Booking window");
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch (IOException err) {
            err.printStackTrace();
        }
    }
}