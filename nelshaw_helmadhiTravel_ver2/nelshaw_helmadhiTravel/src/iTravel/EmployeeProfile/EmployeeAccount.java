package iTravel.EmployeeProfile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeAccount extends Employee{

    public EmployeeAccount(String name, int empID, int phone,
                    String address, int bankNum, String username,
                    String email, String password) {
        new Employee(name, empID, phone, address, bankNum, username, email, password);
    }

    public StringProperty nameProperty() {return super.Name;}
    public StringProperty addressProperty() {return super.Address;}
    public IntegerProperty phoneNumberProperty() {return super.PhoneNumber;}
    public IntegerProperty EmployeeIDProperty() {return super.EmployeeID;}
    public IntegerProperty bankingProperty() {return super.BankingAccountNumber;}

    public EmployeeAccount(){
        new Employee();
    }

    public void setName(String name) { Name.set(name); }
    public String getName() { return Name.get(); }

    public void setEmployeeID(int empID) { EmployeeID.set(empID); }
    public int getEmployeeID() { return EmployeeID.get(); }

    public void setPhoneNumber(int phone) { PhoneNumber.set(phone); }
    public int getPhoneNummber() { return PhoneNumber.get(); }

    public void setAddress(String address) { Address.set(address); }
    public String getAddress() { return Address.get(); }

    public void setBankingAccountNumber(int bankNum) { BankingAccountNumber.set(bankNum); }
    public int getBankingAccountNumber() { return BankingAccountNumber.get(); }

    public void setUsername(String username) {super.setUsername(username);}
    public String getUsername(){return super.getUsername();}

    public void setEmail(String email) {super.setE_mail(email);}
    public String getEmail(){return super.getE_mail();}

    public void setPassword(String password) {super.setPassword(password);}
    public String getPassword(){return super.getPassword();}


}
