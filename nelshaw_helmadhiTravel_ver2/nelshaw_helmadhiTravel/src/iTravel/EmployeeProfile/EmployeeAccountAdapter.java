package iTravel.EmployeeProfile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class EmployeeAccountAdapter {

    Connection connection;

    public EmployeeAccountAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet rs = meta.getTables(null, null, "EmployeeProfile", null);

            try {
                stmt.execute("DROP TABLE EmployeeProfile");
            } catch (SQLException ex) {
            } finally {
                // Create the table of Matches
                stmt.executeUpdate("CREATE TABLE EmployeeProfile ("
                        + "EmployeeID INT NOT NULL PRIMARY KEY, "
                        + "FullName CHAR(100) NOT NULL, "
                        + "Email CHAR(100) NOT NULL, "
                        + "Phone INT,"
                        + "Address CHAR(100) NOT NULL, "
                        + "BankAccount INT,"
                        + "Username CHAR(100), "
                        + "Password CHAR(50))");
            }
            populateSamples();
        }
    }

    public void populateSamples() throws SQLException {
        Employee em = new Employee();
        em.setAddress("123 Apple Street");
        em.setBankingAccountNumber(123456789);
        em.setEmployeeID(000000);
        em.setName("John Doe");
        em.setPhoneNumber(1112223344);
        this.insertProfileInfo(em);
        Employee em2 = new Employee();
        em2.setAddress("123 Apple Street");
        em2.setBankingAccountNumber(123456789);
        em2.setEmployeeID(000000);
        em2.setName("John Doe");
        em2.setPhoneNumber(1112223344);
        this.insertProfileInfo(em2);
    }

    public void insertProfileInfo(int ID, String fullname, String email, int phone, String address, int bankNum, String username, String password) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO EmployeeProfile (EmployeeID, FullName, Email, Phone, Address, BankAccount, Username, Password) " + "VALUES ("
                + ID + " , '"
                + fullname + "' , '"
                + email + "' , "
                + phone + " , '"
                + address + "' , "
                + bankNum + " , '"
                + username + "' , '"
                + password + "')");
    }
    public void insertProfileInfo(Employee employee) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO EmployeeProfile (EmployeeID, FullName, Email, Phone, Address, BankAccount, Username, Password)"
        + "VALUES ("
                + employee.getEmployeeID() + ", '"
                + employee.getName() + "','"
                + employee.getEmail() + "',"
                + employee.getPhoneNummber() +",'"
                + employee.getAddress() + "',"
                + employee.getBankingAccountNumber() + ",'"
                + employee.getUsername() + "','"
                + employee.getPassword() + "')");
    }

    public void removeEmployee(Object ID) throws SQLException {

        Statement stmt = connection.createStatement();

        stmt.executeUpdate("DELETE FROM EmployeeProfile WHERE EmployeeID=" + ID);

    }

    public void update(Object EmployeeID, String fullname, String email, int phone, String address, int bankNum,
                       String username, String password) throws SQLException {
        Statement stmt = connection.createStatement();

        stmt.executeUpdate("UPDATE EmployeeProfile SET FullName='" + fullname + "' WHERE EmployeeID=" + EmployeeID);
        stmt.executeUpdate("UPDATE EmployeeProfile SET Email='" + email + "' WHERE EmployeeID=" + EmployeeID);
        stmt.executeUpdate("UPDATE EmployeeProfile SET Phone=" + phone + " WHERE EmployeeID=" + EmployeeID);
        stmt.executeUpdate("UPDATE EmployeeProfile SET Address='" + address + "' WHERE EmployeeID=" + EmployeeID);
        stmt.executeUpdate("UPDATE EmployeeProfile SET BankAccount=" + bankNum + " WHERE EmployeeID=" + EmployeeID);
        stmt.executeUpdate("UPDATE EmployeeProfile SET Username='" + username + "' WHERE EmployeeID=" + EmployeeID);
        stmt.executeUpdate("UPDATE EmployeeProfile SET Password='" + password + "' WHERE EmployeeID=" + EmployeeID);
    }

    public ObservableList<Employee> getEmployeeList() throws SQLException {
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM EmployeeProfile");

        while(rs.next()) {
            employees.add(new Employee(rs.getString("FullName"),
                    rs.getInt("EmployeeID"),
                    rs.getInt("Phone"),
                    rs.getString("Address"),
                    rs.getInt("BankAccount"),
                    rs.getString("Username"),
                    rs.getString("Email"),
                    rs.getString("Password")));

        }

        return employees;

    }

    public ObservableList<Integer> getEmployeesIDList() throws SQLException {

        ObservableList<Integer> employees = FXCollections.observableArrayList();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM EmployeeProfile");

        while (rs.next()) {
            employees.add(rs.getInt("EmployeeID"));
        }

        return employees;

    }

}