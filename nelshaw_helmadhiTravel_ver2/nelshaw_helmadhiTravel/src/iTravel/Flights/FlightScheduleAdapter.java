package iTravel.Flights;

import java.sql.*;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class FlightScheduleAdapter {

    Connection connection;

    public FlightScheduleAdapter(Connection conn, Boolean reset) throws SQLException {
         connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet rs = meta.getTables(null, null, "Flights", null);

            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                // We drop Matches first because it refrences the table Teams
                stmt.execute("DROP TABLE Flights");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of teams
                stmt.executeUpdate("CREATE TABLE Flights ("
                        + "FlightNumber INT NOT NULL PRIMARY KEY, "
                        + "DepartureLocation CHAR(15) NOT NULL, " + "DepartureTime INT, "
                        + "ArrivalLocation CHAR(15) NOT NULL," + "ArrivalTime INT, "
                        + "DepDate DATE,"
                        + "ArrDate DATE,"
                        + "BFare DOUBLE NOT NULL,"
                        + "EFare DOUBLE NOT NULL)");
            }
            populateSamples();
        }
    }

    public void populateSamples() throws SQLException {
        Flight oneFlight = new Flight();
        oneFlight.setFlightNumber(123456789);
        oneFlight.setArrivalLocation("London");
        oneFlight.setDepartureLocation("Gaza");
        oneFlight.setArrivalTime(1030);
        oneFlight.setDepartureTime(2070);

        java.util.Date uDate = new java.util.Date();
        oneFlight.setArrivalDate(new java.sql.Date(uDate.getTime()));
        oneFlight.setDepartureDate(new java.sql.Date(uDate.getTime()));

        this.addFlight(oneFlight);

        Flight twoFlight = new Flight();
        twoFlight.setFlightNumber(234567890);
        twoFlight.setArrivalLocation("Toronto");
        twoFlight.setDepartureLocation("London");
        twoFlight.setArrivalTime(1930);
        twoFlight.setDepartureTime(230);

        java.util.Date tDate = new java.util.Date();
        twoFlight.setArrivalDate(new java.sql.Date(tDate.getTime()));
        twoFlight.setDepartureDate(new java.sql.Date(tDate.getTime()));

        this.addFlight(twoFlight);

    }

    public void addFlight(int flightN, String dLocation, int dTime, String aLocation, int aTime,
    Date dDate, Date aDate, double bFare, double eFare) throws SQLException {
        Statement stmt = connection.createStatement();
      //  System.out.println("stmt.executeUpdate(INSERT INTO Flights (FlightNumber, DepartureLocation, DepartureTime, ArrivalLocation, ArrivalTime,DepDate, ArrDate) VALUES (" + flightN + ", '" + dLocation + "', " + dTime + ", '" + aLocation + "', " + aTime + ", '" + dDate + "', '" + aDate +"')");


       stmt.executeUpdate("INSERT INTO Flights (FlightNumber, DepartureLocation, DepartureTime, ArrivalLocation, ArrivalTime,DepDate, ArrDate, BFare, EFare) VALUES (" + flightN + ", '" + dLocation + "', " + dTime + ", '" + aLocation + "', " + aTime + ", '" + dDate + "', '" + aDate +"'," + bFare + "," + eFare + ")");
    }

    public void addFlight(Flight data) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Flights (FlightNumber, DepartureLocation, DepartureTime, ArrivalLocation, ArrivalTime,DepDate, ArrDate, BFare, EFare) "
                + "VALUES ("
                + data.getFlightNumber() + ", '"
                + data.getDepartureLocation() + "', "
                + data.getDepartureTime() + ", '"
                + data.getArrivalLocation() + "', "
                + data.getArrivalTime() + ", '"
                + data.getDepartureDate() + "', '"
                + data.getArrivalDate() + "',"
                + data.getBusinessClassFare() + ","
                + data.getExecutiveClassFare() + ")"
        );
    }

    // Get all flights Data
    public ObservableList<Flight> getFlightsList() throws SQLException {
        ObservableList<Flight> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "SELECT * FROM Flights";


        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);


        while (rs.next()) {

            list.add(new Flight(rs.getInt("FlightNumber"),
                    rs.getInt("DepartureTime"),
                    rs.getInt("ArrivalTime"),
                    rs.getString("DepartureLocation"),
                    rs.getString("ArrivalLocation"),
                    rs.getDate("DepDate"),
                    rs.getDate("ArrDate"),
                    rs.getInt("BFare"),
                    rs.getInt("EFare")));
        }
        return list;
    }

    public ObservableList<Integer> getFlightNumber() throws SQLException {
        ObservableList<Integer> flight = FXCollections.observableArrayList();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM Flights");

        while(rs.next()){
            flight.add(rs.getInt("FlightNumber"));
        }
        return flight;
    }

    public int getNumFlights() throws SQLException{
        return this.getFlightNumber().size();
    }

    public void removeFlight(Object flightNum) throws SQLException{
        Statement stmt = connection.createStatement();

        stmt.executeUpdate("DELETE FROM Flights WHERE FlightNumber =" + flightNum);
    }

    public ObservableList<String> getAircraftList() throws SQLException{
        ObservableList<String> flight = FXCollections.observableArrayList();
        return flight;
    }
}