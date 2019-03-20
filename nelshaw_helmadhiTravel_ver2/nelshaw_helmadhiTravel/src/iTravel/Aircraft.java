package iTravel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aircraft {

    private StringProperty AircraftType;
    private IntegerProperty BusinessClassCapacity;
    private IntegerProperty FirstClassCapacity;
    private IntegerProperty EconomyClassCapacity;

    public Aircraft(String type, int BusCap, int FirstCap, int EconCap) {
        this.AircraftType = new SimpleStringProperty(type);
        this.BusinessClassCapacity = new SimpleIntegerProperty(BusCap);
        this.FirstClassCapacity = new SimpleIntegerProperty(FirstCap);
        this.EconomyClassCapacity = new SimpleIntegerProperty(EconCap);

    }

    public Aircraft(){};

    public void setAircraftType(String type) {
        AircraftType.set(type);
    }

    public String getAircraftType() {
        return AircraftType.get();
    }

    public void setBusinessClassCapacity(int BusCap) {
        BusinessClassCapacity.set(BusCap);
    }

    public int getBusinesClassCapacity() {
        return BusinessClassCapacity.get();
    }
    public void setFirstClassCapacity(int FirstCap) {
        FirstClassCapacity.set(FirstCap);
    }

    public int getFirstClassCapacity() {
        return FirstClassCapacity.get();
    }

    public void setEconomyClassCapacity(int EconCap) {
        EconomyClassCapacity.set(EconCap);
    }

    public int getEconomyClassCapacity() {
        return EconomyClassCapacity.get();
    }
}
