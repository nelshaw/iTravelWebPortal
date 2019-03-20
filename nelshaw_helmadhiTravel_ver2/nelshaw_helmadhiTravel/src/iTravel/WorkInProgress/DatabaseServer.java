package iTravel.WorkInProgress;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DatabaseServer {

    private IntegerProperty CheckupRecord;
    private StringProperty ServerLogsStatus;
    private StringProperty NetworkUsageStatus;


    public DatabaseServer(int CheckupRec, String log, String status) {
        this.CheckupRecord = new SimpleIntegerProperty(CheckupRec);
        this.ServerLogsStatus = new SimpleStringProperty(log);
        this.NetworkUsageStatus = new SimpleStringProperty(status);
    }

    public DatabaseServer(){
        this.CheckupRecord = new SimpleIntegerProperty();
        this.ServerLogsStatus = new SimpleStringProperty();
        this.NetworkUsageStatus = new SimpleStringProperty();
    }

    public void setCheckupRecord(int CheckupRec) { CheckupRecord.set(CheckupRec); }
    public int getCheckupRecord() {
        return CheckupRecord.get();
    }

    public void setServerLogsStatus(String log) {
        ServerLogsStatus.set(log);
    }
    public String getServerLogsStatus() {
        return ServerLogsStatus.get();
    }

    public void setNetworkUsageStatus(String status) {
        NetworkUsageStatus.set(status);
    }
    public String getNetworkUsageStatus() {
        return NetworkUsageStatus.get();
    }


}
