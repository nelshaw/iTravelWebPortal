package iTravel.Flights;

import iTravel.AlertController;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class FlightScheduleController implements Initializable {
    //TABLE VIEW AND DATA
    private FlightScheduleAdapter flights;

    @FXML
    private TableView<Flight> tableView;
    @FXML
    private TableColumn<Flight, Integer> flightNumber;
    @FXML
    private TableColumn<Flight, Integer> departureTime;
    @FXML
    private TableColumn<Flight, Integer> arrivalTime;
    @FXML
    private TableColumn<Flight, Double> bFare;
    @FXML
    private TableColumn<Flight, Double> eFare;
    @FXML
    private TableColumn<Flight, String> departureLocation;
    @FXML
    private TableColumn<Flight, String> arrivalLocation;
    @FXML
    private TableColumn<Flight, Date> departureDate;
    @FXML
    private TableColumn<Flight, Date> arrivalDate;

    final ObservableList<Flight> data = FXCollections.observableArrayList();

    public void setModel(FlightScheduleAdapter Flights) {

        flights = Flights;
        buildData();

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

    @FXML
    public void buildData() {
        try {
            data.addAll(flights.getFlightsList());
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flightNumber.setCellValueFactory(cellData -> cellData.getValue().flightNumProperty().asObject());
        departureLocation.setCellValueFactory(cellData -> cellData.getValue().dLocationProperty());
        departureTime.setCellValueFactory(cellData -> cellData.getValue().dTimeProperty().asObject());
        arrivalLocation.setCellValueFactory(cellData -> cellData.getValue().aLocationProperty());
        arrivalTime.setCellValueFactory(cellData -> cellData.getValue().aTimeProperty().asObject());
        arrivalDate.setCellValueFactory(cellData -> (ObservableValue<Date>) cellData.getValue().aDateProperty());
        departureDate.setCellValueFactory(cellData -> (ObservableValue<Date>) cellData.getValue().dDateProperty());
        bFare.setCellValueFactory(cellData -> cellData.getValue().busFareProperty().asObject());
        eFare.setCellValueFactory(cellData -> cellData.getValue().execFareProperty().asObject());

        tableView.setItems(data);

    }
}
