package iTravel.EmployeeProfile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Account {

    public StringProperty Username;
    public StringProperty E_mail;
    public StringProperty Password;

    public Account(String username, String email, String password) {
        this.Username = new SimpleStringProperty(username);
        this.E_mail = new SimpleStringProperty(email);
        this.Password = new SimpleStringProperty(password);

    }

    public Account() {
        this.Username = new SimpleStringProperty();
        this.E_mail = new SimpleStringProperty();
        this.Password = new SimpleStringProperty();

    }

    public void setUsername(String name) {
        Username.set(name);
    }
    public String getUsername() {
        return Username.get();
    }

    public void setE_mail(String email) {
        E_mail.set(email);
    }
    public String getE_mail() {
        return E_mail.get();
    }

    public void setPassword(String password) {
        Password.set(password);
    }
    public String getPassword() {
        return Password.get();
    }

    public StringProperty usernameProperty() {return Username;}
    public StringProperty emailProperty() {return E_mail;}
    public StringProperty passwordProperty() {return Password;}
}
