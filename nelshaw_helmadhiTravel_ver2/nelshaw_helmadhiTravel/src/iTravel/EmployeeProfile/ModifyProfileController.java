package iTravel.EmployeeProfile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifyProfileController implements Initializable {

    @FXML
    TextField name;
    @FXML
    Button cancelButton;
    @FXML
    Button saveButton;
    @FXML
    TextField phone;
    @FXML
    TextField banknum;
    @FXML
    TextField address;
    @FXML
    ComboBox employeeID;
    @FXML
    TextField position;
    @FXML
    TextField workEmail;
    @FXML
    TextField username;
    @FXML
    TextField password;

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
            System.out.println("ERROR: " +e.getMessage());
        }
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void update() throws SQLException {
        try{
            employeeAccountAdapter.update(employeeID.getValue(), name.getText(),
                    workEmail.getText(), Integer.parseInt(phone.getText()), address.getText(),
                    Integer.parseInt(banknum.getText()), username.getText(), password.getText());
            //int EmployeeID, String fullname, String email, int phone, String address, int bankNum,
            //                       String username, int password) throws SQLException {
            //
        }catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println(employeeAccountAdapter.getEmployeeList());

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeID.setItems(data);
    }
}