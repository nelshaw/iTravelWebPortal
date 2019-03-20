package iTravel.EmployeeProfile;

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

public class DeleteProfileController implements Initializable {

    @FXML
    Button cancelButton;
    @FXML
    Button deleteButton;
    @FXML
    ComboBox employeeID;

    final ObservableList<Integer> data = FXCollections.observableArrayList();

    private EmployeeAccountAdapter employeeAccountAdapter;

    public void setModel(EmployeeAccountAdapter employee){
        employeeAccountAdapter = employee;
        buildComboBoxData();
    }

    private void buildComboBoxData() {
        try{
            data.addAll(employeeAccountAdapter.getEmployeesIDList());
        }catch(SQLException e){
        }
    }


    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void remove(){
        try{
            employeeAccountAdapter.removeEmployee(employeeID.getValue());
        }catch(SQLException e){
        }

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeID.setItems(data);
    }
}
