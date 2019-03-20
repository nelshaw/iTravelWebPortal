package iTravel.WorkInProgress;

import iTravel.WorkInProgress.ApplicationServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ApplicationServerAdapter {


    Connection connection;

    public ApplicationServerAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet rs = meta.getTables(null, null, "ApplicationServer", null);

            try {
                stmt.execute("DROP TABLE ApplicationServer");
            } catch (SQLException ex) {
            } finally {
                // Create the table of Matches
                stmt.executeUpdate("CREATE TABLE ApplicationServer ("
                        + "CheckupRecord INT NOT NULL PRIMARY KEY, "
                        + "ServerLogsStatus VARCHAR(100) NOT NULL)");
            }
        }
    }

    public void insertApplicationServerInfo(int CheckupRec, String Log) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO WebServer (CheckupRecord, ServerLogsStatus) " + "VALUES ("
                + CheckupRec + " , '"
                + Log + "')");
    }
    public void insertApplicationServerInfo(ApplicationServer applicationServer) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO ApplicationServer (CheckupRecord, ServerLogsStatus)"
                + "VALUES ("
                + applicationServer.getCheckupRecord() + " , '"
                + applicationServer.getServerLogsStatus() + "')");
    }

    public ObservableList<ApplicationServer> getApplicationServerList() throws SQLException {
        ObservableList<ApplicationServer> applicationServers = FXCollections.observableArrayList();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM ApplicationServer");

        while(rs.next()) {
            applicationServers.add(new ApplicationServer(
                    rs.getInt("CheckupRecord"),
                    rs.getString("ServerLogsStatus")));

        }

        return applicationServers;

    }

}

