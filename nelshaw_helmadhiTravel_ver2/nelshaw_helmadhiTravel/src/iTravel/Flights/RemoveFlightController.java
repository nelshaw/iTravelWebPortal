package iTravel.Flights;

import iTravel.AlertController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class RemoveFlightController implements Initializable {
    @FXML
    Button cancelBtn;
    @FXML
    ComboBox flightNumber;
    @FXML
    Button removeBtn;

    final ObservableList<Integer> data = FXCollections.observableArrayList();

    private FlightScheduleAdapter flightsAdapter;

    public void setModel(FlightScheduleAdapter flights) {
        flightsAdapter = flights;
        buildComboBoxData();
    }

    private void buildComboBoxData() {
        try {
            data.addAll(flightsAdapter.getFlightNumber());
        } catch (SQLException e) {
            displayAlert("ERROR: " + e.getMessage());
        }
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void remove() {
        try {
            flightsAdapter.removeFlight(flightNumber.getValue());
        } catch (SQLException e) {
            displayAlert("ERROR: " + e.getMessage());
        }

        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    private void displayAlert(String s) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
            controller.setAlertText(s);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flightNumber.setItems(data);
    }
}
