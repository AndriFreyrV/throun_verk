package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<Integer> howMany;

    private final Integer[] num_vals = {1,2,3,4,5,6,7,8,9,10};


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addNums();
    }

    public void addNums(){
        ObservableList<Integer> vals_ls =
                FXCollections.observableArrayList(num_vals);
        howMany.setItems(vals_ls);
    }
}
