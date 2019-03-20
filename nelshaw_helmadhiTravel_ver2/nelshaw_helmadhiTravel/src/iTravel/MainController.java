/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iTravel;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import iTravel.EmployeeProfile.AddProfileController;
import iTravel.EmployeeProfile.DeleteProfileController;
import iTravel.EmployeeProfile.EmployeeAccountAdapter;
import iTravel.EmployeeProfile.ModifyProfileController;
import iTravel.Flights.AddFlightController;
import iTravel.Flights.FlightScheduleAdapter;
import iTravel.Flights.FlightScheduleController;
import iTravel.Flights.RemoveFlightController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Abdelkader
 */
public class MainController implements Initializable {

    @FXML
    private MenuBar mainMenu;

    private FlightScheduleAdapter flights;
    private Connection conn;

    public void showAbout() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent About = (Parent) fxmlLoader.load();

        Scene scene = new Scene(About);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/iTravel/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void showAddFlight() throws Exception{

        FlightScheduleAdapter flights = new FlightScheduleAdapter(conn, true);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Flights/AddFlight.fxml"));
        Parent AddFlight = (Parent) fxmlLoader.load();
        AddFlightController addFlightController = (AddFlightController) fxmlLoader.getController();
        addFlightController.setModel(flights);

        Scene scene = new Scene(AddFlight);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/iTravel/WesternLogo.png"));
        stage.setTitle("Add Flight");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    public void showFlightSchedule() throws Exception{

        FlightScheduleAdapter flights = new FlightScheduleAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Flights/FlightSchedule.fxml"));
        Parent Sched = (Parent) fxmlLoader.load();

        FlightScheduleController flightScheduleController = (FlightScheduleController) fxmlLoader.getController();
        flightScheduleController.setModel(flights);

        Scene scene = new Scene(Sched);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/iTravel/WesternLogo.png"));
        stage.setTitle("Flight Schedule");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }
    public void showRemoveFlight() throws Exception{
        FlightScheduleAdapter flights = new FlightScheduleAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Flights/RemoveFlight.fxml"));
        Parent RemoveFlight = (Parent) fxmlLoader.load();
        RemoveFlightController removeFlightController = (RemoveFlightController) fxmlLoader.getController();
        removeFlightController.setModel(flights);

        Scene scene = new Scene(RemoveFlight);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/iTravel/WesternLogo.png"));
        stage.setTitle("Remove Flight");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    public void showAddProfile() throws Exception{
        EmployeeAccountAdapter employee = new EmployeeAccountAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeProfile/AddProfile.fxml"));
        Parent AddProfile = (Parent) fxmlLoader.load();
        AddProfileController addProfileController = (AddProfileController) fxmlLoader.getController();
        addProfileController.setModel(employee);

        Scene scene = new Scene(AddProfile);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/iTravel/WesternLogo.png"));
        stage.setTitle("Add Employee");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    public void showDeleteProfile() throws Exception{
        EmployeeAccountAdapter employee = new EmployeeAccountAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeProfile/DeleteProfile.fxml"));
        Parent DeleteProfile = (Parent) fxmlLoader.load();
        DeleteProfileController deleteProfileController = (DeleteProfileController) fxmlLoader.getController();
        deleteProfileController.setModel(employee);

        Scene scene = new Scene(DeleteProfile);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/iTravel/WesternLogo.png"));
        stage.setTitle("Delete Employee Profile");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    public void showModifyProfile() throws Exception{
        EmployeeAccountAdapter employee = new EmployeeAccountAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeProfile/ModifyProfile.fxml"));
        Parent ModifyProfile = (Parent) fxmlLoader.load();
        ModifyProfileController modifyProfileController = (ModifyProfileController) fxmlLoader.getController();
        modifyProfileController.setModel(employee);

        Scene scene = new Scene(ModifyProfile);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/iTravel/WesternLogo.png"));
        stage.setTitle("Modify Employee Profile");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }


    public void exit() {

        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:iTravelDB;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);


        } catch (SQLException ex) {
           // displayAlert(ex.getMessage());
        }
    }

}

