package iTravel.FinishedEntityClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class WebServerAdapter {


    Connection connection;

    public WebServerAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet rs = meta.getTables(null, null, "WebServer", null);

            try {
                stmt.execute("DROP TABLE WebServer");
            } catch (SQLException ex) {
            } finally {
                // Create the table of Matches
                stmt.executeUpdate("CREATE TABLE WebServer ("
                        + "CheckupRecord INT NOT NULL PRIMARY KEY, "
                        + "ServerLogsStatus VARCHAR(100) NOT NULL)");
            }
        }
    }

    public void insertWebServerInfo(int CheckupRec, String Log) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO WebServer (CheckupRecord, ServerLogsStatus) " + "VALUES ("
                + CheckupRec + " , '"
                + Log + "')");
    }
    public void insertWebServerInfo(WebServer webServer) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO WebServer (CheckupRecord, ServerLogsStatus)"
                + "VALUES ("
                + webServer.getCheckupRecord() + " , '"
                + webServer.getServerLogsStatus() + "')");
    }

    public ObservableList<WebServer> getWebServerList() throws SQLException {
        ObservableList<WebServer> webServers = FXCollections.observableArrayList();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM WebServer");

        while(rs.next()) {
            webServers.add(new WebServer(
                    rs.getInt("CheckupRecord"),
                    rs.getString("ServerLogsStatus")));

        }

        return webServers;

    }
}
