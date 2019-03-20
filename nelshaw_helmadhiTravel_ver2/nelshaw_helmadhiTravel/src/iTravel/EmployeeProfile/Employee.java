package iTravel.EmployeeProfile;

import javafx.beans.property.*;

public class Employee extends Account{

    public StringProperty Name;
    public IntegerProperty EmployeeID;
    public IntegerProperty PhoneNumber;
    public StringProperty Address;
    public IntegerProperty BankingAccountNumber;

    public Employee(String name, int empID, int phone,
                    String address, int bankNum, String username,
                    String email, String password) {
        this.Name = new SimpleStringProperty(name);
        this.EmployeeID = new SimpleIntegerProperty(empID);
        this.PhoneNumber = new SimpleIntegerProperty(phone);
        this.Address = new SimpleStringProperty(address);
        this.BankingAccountNumber = new SimpleIntegerProperty(bankNum);
        new Account(username, email, password);
    }

    public StringProperty nameProperty() {return Name;}
    public StringProperty addressProperty() {return Address;}
    public IntegerProperty phoneNumberProperty() {return PhoneNumber;}
    public IntegerProperty EmployeeIDProperty() {return EmployeeID;}
    public IntegerProperty bankingProperty() {return BankingAccountNumber;}

    public Employee(){
            this.EmployeeID = new SimpleIntegerProperty();
            this.PhoneNumber = new SimpleIntegerProperty();
            this.BankingAccountNumber = new SimpleIntegerProperty();
            this.Name = new SimpleStringProperty();
            this.Address = new SimpleStringProperty();
            new Account();
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
