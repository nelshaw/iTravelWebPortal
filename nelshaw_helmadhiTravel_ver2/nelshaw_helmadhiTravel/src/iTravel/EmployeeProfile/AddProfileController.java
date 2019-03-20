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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddProfileController implements Initializable {

    @FXML
    TextField name;
    @FXML
    Button cancelButton;
    @FXML
    Button saveBtn;
    @FXML
    TextField phone;
    @FXML
    TextField banknum;
    @FXML
    TextField address;
    @FXML
    TextField employeeID;
    @FXML
    TextField position;
    @FXML
    TextField workEmail;
    @FXML
    TextField username;
    @FXML
    TextField password;

    private EmployeeAccountAdapter employeeAccountAdapter;

    final ObservableList<String> data = FXCollections.observableArrayList();

    public void setModel(EmployeeAccountAdapter employee){
        employeeAccountAdapter = employee;
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void save() throws SQLException {
        try{
            employeeAccountAdapter.insertProfileInfo(Integer.parseInt(employeeID.getText()),name.getText(),workEmail.getText(), Integer.parseInt(phone.getText()),
                    address.getText(), Integer.parseInt(banknum.getText()), username.getText(), password.getText());
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
