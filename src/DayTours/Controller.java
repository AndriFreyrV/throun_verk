package DayTours;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

// import javafx.scene.control.

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private SearchModel model;
    private SearchController controller;

    @FXML
    private Button searchButton;
    @FXML
    private Label personsLabel;
    @FXML
    private Spinner<Integer> personsSpinner;
    @FXML
    private DatePicker fromDatePicker;
    @FXML
    private DatePicker toDatePicker;
    @FXML
    private ChoiceBox<PriceRange> priceRangeChoiceBox;
    @FXML
    private ChoiceBox<TimeFrame> timeFrameChoiceBox;
    @FXML
    private ChoiceBox<Duration> durationChoiceBox;
    @FXML
    private ChoiceBox<TourType> tourTypeChoiceBox;
    @FXML
    private TableView<Tour> toursTableView;


    public void searchButtonOnAction(ActionEvent event)
    {
        controller.searchTour(model);
        ObservableList<Tour> res = controller.searchTour(model);
        toursTableView.setItems(FXCollections.observableArrayList(res));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new SearchModel();
        controller = new SearchController();
        searchButton.setOnAction(this::searchButtonOnAction);

        toursTableView.setRowFactory(tv ->
        {
            TableRow<Tour> row = new TableRow<>();
            {
                row.setOnMouseClicked(e ->
                {
                    if (e.getClickCount() == 2 && (!row.isEmpty()))
                    {
                        Tour tour = row.getItem();
                        System.out.println(tour.getPrice());
                    }
                });
            }
            return row;
        });

        // toursTableView.setOnMouseClicked(new EventHandler<MouseEvent>()
        // {
        //     @Override
        //     public void handle (MouseEvent e)
        //     {
        //         if (e.getClickCount() == 2)
        //         {
        //             e.
        //             Tour t = toursTableView.getSelectionModel().getSelectedItem();
        //             System.out.print(t.getTripID());
        //         }
        //     }
        // });

        TableColumn<Tour, String> tourID = new TableColumn<>("Price");
        tourID.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Tour, LocalDate> date = new TableColumn<>("Date");
        date.setCellValueFactory((cellValue) -> cellValue.getValue().getLdProperty());
        date.setCellFactory(
                (column) ->
                {
                    TableCell<Tour, LocalDate> cell = new TableCell<>()
                    {
                        @Override
                        protected void updateItem (LocalDate item, boolean empty)
                        {
                            // this.updateItem(item, empty);
                            if(empty)
                            {
                                this.setText(null);
                            }
                            else
                            {
                                String formattedDate = item.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                                this.setText(formattedDate);
                            }
                        }
                    };
                    return cell;
                }
        );

        TableColumn<Tour, LocalTime> time = new TableColumn<>("Time");
        time.setCellValueFactory((cellValue) -> cellValue.getValue().getLtProperty());
        time.setCellFactory(
                (column) ->
                {
                    TableCell<Tour, LocalTime> cell = new TableCell<>()
                    {
                        @Override
                        protected void updateItem (LocalTime item, boolean empty)
                        {
                            // this.updateItem(item, empty);
                            if(empty)
                            {
                                this.setText(null);
                            }
                            else
                            {
                                String formattedTime = item.format(DateTimeFormatter.ofPattern("HH:mm"));
                                this.setText(formattedTime);
                            }
                        }
                    };

                    return cell;
                }
        );

        TableColumn<Tour, TourType> type = new TableColumn<>("Name");
        type.setCellValueFactory((cellValue) -> cellValue.getValue().getTourTypeProperty());

        List<TableColumn<Tour, ?>> columns = new ArrayList<>();
        columns.add(type);
        columns.add(tourID);
        columns.add(date);
        columns.add(time);

        toursTableView.getColumns().setAll(columns);

        personsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
        personsSpinner.setEditable(false);

        personsSpinner.valueProperty().addListener((obs, oldValue, newValue) ->
                {
                    String people;
                    if (newValue > 1)
                        people = "Persons";
                    else
                        people = "Person";
                    personsLabel.setText(people);
                    model.setPersons(newValue);
                }
        );

        LocalDate now = LocalDate.now();
        fromDatePicker.setEditable(false);
        fromDatePicker.setValue(now);

        fromDatePicker.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t)
            {
                LocalDate newNow = fromDatePicker.getValue();
                newNow = newNow.plusDays(1);
                toDatePicker.setValue(newNow);
                model.setFromDate(newNow);
                model.setToDate(newNow);
            }
        });

        toDatePicker.setEditable(false);
        toDatePicker.setValue(now.plusDays(1));

        toDatePicker.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t)
            {
                model.setToDate(toDatePicker.getValue());
            }
        });

        ObservableList<TimeFrame> timeFrames = SearchModel.TIME_FRAMES;
        timeFrameChoiceBox.setValue(timeFrames.get(0));
        timeFrameChoiceBox.setItems(timeFrames);
        timeFrameChoiceBox.valueProperty().addListener((obs, oldValue, newValue) ->
                {
                    model.setTimeFrame(newValue);
                    System.out.println(model.getTimeFrame());
                }
        );

        ObservableList<PriceRange> priceRanges = SearchModel.PRICE_RANGES;
        priceRangeChoiceBox.setValue(priceRanges.get(0));
        priceRangeChoiceBox.setItems(priceRanges);
        priceRangeChoiceBox.valueProperty().addListener((obs, oldValue, newValue) ->
                {
                    model.setPriceRange(newValue);
                    System.out.println(model.getPriceRange());
                }
        );

        ObservableList<Duration> durations = SearchModel.DURATIONS;
        durationChoiceBox.setValue(durations.get(0));
        durationChoiceBox.setItems(durations);
        durationChoiceBox.valueProperty().addListener((obs, oldValue, newValue) ->
                {
                    model.setDuration(newValue);
                    System.out.println(model.getDuration());
                }
        );

        ObservableList<TourType> tourTypes = SearchModel.TOUR_TYPES;
        tourTypeChoiceBox.setValue(tourTypes.get(0));
        tourTypeChoiceBox.setItems(tourTypes);
        tourTypeChoiceBox.valueProperty().addListener((obs, oldValue, newValue) ->
                {
                    model.setTourType(newValue);
                    System.out.println(model.getTourType());
                }
        );
    }

    // public void listViewMouseClicked(MouseEvent mouseEvent){
    //     User selectedItem = (User) usersListView.getSelectionModel().getSelectedItem();
    //     usernameTextField.setText(selectedItem.getName());
    //     emailTextField.setText(selectedItem.getEmail());

    //     reservationsListView.setItems(getReservedBooks(selectedItem));
    // }

    // private ObservableList<Book> getReservedBooks(User user){
    //     ObservableList<Book> reservedBooks = FXCollections.observableArrayList();
    //     ArrayList<Reservation> reservations = user.getReservations();
    //     for(Reservation reservation: reservations){
    //         reservedBooks.add(reservation.getBook());
    //     }
    //     return reservedBooks;
    // }

}