package iTravel;

import iTravel.Flights.Flight;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WaitingList extends Flight {

    private StringProperty PassengerName;
    private StringProperty E_mail;
    private IntegerProperty PhoneNumber;
    private StringProperty Address;
    private IntegerProperty CreditCardNumber;
    private IntegerProperty ID_Number;


    public WaitingList(String name, String email, int phone, String address, int creditNum, int ID) {
        this.PassengerName = new SimpleStringProperty(name);
        this.E_mail = new SimpleStringProperty(email);
        this.PhoneNumber = new SimpleIntegerProperty(phone);
        this.Address = new SimpleStringProperty(address);
        this.CreditCardNumber = new SimpleIntegerProperty(creditNum);
        this.ID_Number = new SimpleIntegerProperty(ID);

    }

    public WaitingList(){};

    public void setPassengerName(String name) {
        PassengerName.set(name);
    }

    public String getPassengerName() {
        return PassengerName.get();
    }

    public void setE_mail(String email) {
        E_mail.set(email);
    }

    public String getE_mail() {
        return E_mail.get();
    }
    public void setPhoneNumber(int phone) {
        PhoneNumber.set(phone);
    }

    public int getPhoneNummber() {
        return PhoneNumber.get();
    }

    public void setAddress(String address) {
        Address.set(address);
    }

    public String getAdress() {
        return Address.get();
    }

    public void setCreditCardNumber(int creditNum) {
        CreditCardNumber.set(creditNum);
    }

    public int getCreditCardNumber() {
        return CreditCardNumber.get();
    }

    public void setID_Number(int ID) {
        CreditCardNumber.set(ID);
    }

    public int getID_Number() {
        return ID_Number.get();
    }

}
