package iTravel.FinishedEntityClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WebServer {

    private IntegerProperty CheckupRecord;
    private StringProperty ServerLogsStatus;


    public WebServer(int CheckupRec, String log) {
        this.CheckupRecord = new SimpleIntegerProperty(CheckupRec);
        this.ServerLogsStatus = new SimpleStringProperty(log);
    }

    public WebServer(){
        this.CheckupRecord = new SimpleIntegerProperty();
        this.ServerLogsStatus = new SimpleStringProperty();
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
}

