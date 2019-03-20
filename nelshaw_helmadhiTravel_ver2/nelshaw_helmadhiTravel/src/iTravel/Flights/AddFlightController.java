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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddFlightController implements Initializable {

    @FXML
    private TextField flightNum;
    @FXML
    private Button cancelButton;
    @FXML
    private ComboBox aircraftCombo;
    @FXML
    private TextField dlocation;
    @FXML
    private DatePicker ddate;
    @FXML
    private TextField dtime;
    @FXML
    private TextField alocation;
    @FXML
    private DatePicker adate;
    @FXML
    private TextField atime;
    @FXML
    private TextField bFare;
    @FXML
    private TextField eFare;
    @FXML
    private Button saveButton;

    private FlightScheduleAdapter flightsAdapter;

    final ObservableList<String> data = FXCollections.observableArrayList();
    public void setModel (FlightScheduleAdapter flight){
        flightsAdapter = flight;
        buildComboBoxData();
    }

    private void buildComboBoxData() {
        try {
           // data.addAll(flightsAdapter.getAircraftList());
            data.addAll("Boeing 747", "Boeing 767", "Boeing 777", "Airbus A300");
        }catch(Exception e){
            displayAlert("ERROR: " +e.getMessage());
        }
    }


    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save() throws SQLException {
        try {
            flightsAdapter.addFlight(Integer.parseInt(flightNum.getText()), dlocation.getText(),
                    Integer.parseInt(dtime.getText()), alocation.getText(),
                    Integer.parseInt(atime.getText()), java.sql.Date.valueOf(this.ddate.getValue()), java.sql.Date.valueOf(this.adate.getValue()),
                    Double.parseDouble(bFare.getText()), Double.parseDouble(eFare.getText()));
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
        //close the stage
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void displayAlert(String msg) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("iTravel/Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aircraftCombo.setItems(data);
    }
}
