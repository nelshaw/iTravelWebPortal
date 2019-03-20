package iTravel.FinishedEntityClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseServerAdapter {


    Connection connection;

    public DatabaseServerAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet rs = meta.getTables(null, null, "DatabaseServer", null);

            try {
                stmt.execute("DROP TABLE DatabaseServer");
            } catch (SQLException ex) {
            } finally {
                // Create the table of Matches
                stmt.executeUpdate("CREATE TABLE DatabaseServer ("
                        + "CheckupRecord INT NOT NULL PRIMARY KEY, "
                        + "ServerLogsStatus VARCHAR(100) NOT NULL, "
                        + "NetworkUsageStatus VARCHAR(100) NOT NULL)");
            }
        }
    }

    public void insertServerInfo(int CheckupRec, String Log, String Usage) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO DatabaseServer (CheckupRecord, ServerLogsStatus, NetworkUsageStatus) " + "VALUES ("
                + CheckupRec + " , '"
                + Log + "' , '"
                + Usage + "')");
    }
    public void insertServerInfo(DatabaseServer databaseServer) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO DatabaseServer (CheckupRecord, ServerLogsStatus, NetworkUsageStatus)"
                + "VALUES ("
                + databaseServer.getCheckupRecord() + " , '"
                + databaseServer.getServerLogsStatus() + "' , '"
                + databaseServer.getNetworkUsageStatus() + "')");
    }

    public ObservableList<DatabaseServer> getDatabaseServerList() throws SQLException {
        ObservableList<DatabaseServer> databaseServers = FXCollections.observableArrayList();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM DatabaseServer");

        while(rs.next()) {
            databaseServers.add(new DatabaseServer(
                    rs.getInt("CheckupRecord"),
                    rs.getString("ServerLogsStatus"),
                    rs.getString("NetworkUsageStatus")));

        }

        return databaseServers;

    }

}
