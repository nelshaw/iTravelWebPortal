package iTravel.Flights;

import javafx.beans.property.*;

import java.util.Date;

public class Flight {

    private final DoubleProperty Fare;
    private final IntegerProperty FlightNumber;
    private final IntegerProperty DepartureTime;
    private final IntegerProperty ArrivalTime;
    private final StringProperty DepartureLocation;
    private final StringProperty ArrivalLocation;
    private final StringProperty FlightStatus;
    private final DoubleProperty Revenue;
    private final ObjectProperty<Date> DepartureDate;
    private final ObjectProperty<Date> ArrivalDate;
    private final DoubleProperty BusinessClassFare;
    private final DoubleProperty ExecutiveClassFare;

    public Flight(double fare, int flightNum, int dTime, int aTime, String
            dLocation, String aLocation, String status, double revenue,
                  Date dDate, Date aDate, int busFare, int execFare) {
        this.Fare = new SimpleDoubleProperty(fare);
        this.FlightNumber = new SimpleIntegerProperty(flightNum);
        this.DepartureTime = new SimpleIntegerProperty(dTime);
        this.ArrivalTime= new SimpleIntegerProperty(aTime);
        this.DepartureLocation = new SimpleStringProperty(dLocation);
        this.ArrivalLocation = new SimpleStringProperty(aLocation);
        this.FlightStatus = new SimpleStringProperty(status);
        this.Revenue = new SimpleDoubleProperty(revenue);
        this.ArrivalDate = new SimpleObjectProperty<>(aDate);
        this.DepartureDate = new SimpleObjectProperty<>(dDate);
        this.BusinessClassFare = new SimpleDoubleProperty(busFare);
        this.ExecutiveClassFare = new SimpleDoubleProperty(execFare);

    }

    public Flight(int flightNum, int dTime, int aTime, String
            dLocation, String aLocation, Date dDate, Date aDate, int busFare, int execFare) {
        this.FlightNumber = new SimpleIntegerProperty(flightNum);
        this.DepartureTime = new SimpleIntegerProperty(dTime);
        this.ArrivalTime= new SimpleIntegerProperty(aTime);
        this.DepartureLocation = new SimpleStringProperty(dLocation);
        this.ArrivalLocation = new SimpleStringProperty(aLocation);

        this.ArrivalDate = new SimpleObjectProperty<>(aDate);
        this.DepartureDate = new SimpleObjectProperty<>(dDate);

        this.FlightStatus = new SimpleStringProperty();
        this.Revenue = new SimpleDoubleProperty();
        this.Fare = new SimpleDoubleProperty();

        this.BusinessClassFare = new SimpleDoubleProperty(busFare);
        this.ExecutiveClassFare = new SimpleDoubleProperty(execFare);
    }

    public Flight(){
        this.Fare = new SimpleDoubleProperty();
        this.FlightNumber = new SimpleIntegerProperty();
        this.DepartureTime = new SimpleIntegerProperty();
        this.ArrivalTime = new SimpleIntegerProperty();
        this.DepartureLocation = new SimpleStringProperty();;
        this.ArrivalLocation = new SimpleStringProperty();
        this.FlightStatus = new SimpleStringProperty();
        this.Revenue = new SimpleDoubleProperty();
        this.ArrivalDate = new SimpleObjectProperty<>();
        this.DepartureDate = new SimpleObjectProperty<>();
        this.BusinessClassFare = new SimpleDoubleProperty();
        this.ExecutiveClassFare = new SimpleDoubleProperty();
    }

    public void setFare(Double fare) {
        Fare.set(fare);
    }
    public Double getFare() {
        return Fare.get();
    }

    public void setFlightNumber(int flightNum) {
        FlightNumber.set(flightNum);
    }
    public int getFlightNumber() {
        return FlightNumber.get();
    }

    public void setDepartureTime(int dtime) {
        DepartureTime.set(dtime);
    }
    public int getDepartureTime() {
        return DepartureTime.get();
    }

    public void setArrivalTime(int aTime) {
        ArrivalTime.set(aTime);
    }
    public int getArrivalTime() {
        return ArrivalTime.get();
    }

    public void setDepartureLocation(String dLocation) {
        DepartureLocation.set(dLocation);
    }
    public String getDepartureLocation() {
        return DepartureLocation.get();
    }

    public void setArrivalLocation(String aLocation) {
        ArrivalLocation.set(aLocation);
    }
    public String getArrivalLocation() {
        return ArrivalLocation.get();
    }

    public void setFlightStatus(String status) {
        FlightStatus.set(status);
    }
    public String getFlightStatus() {
        return FlightStatus.get();
    }

    public void setRevenue(Double revenue) {
        Revenue.set(revenue);
    }
    public Double getRevenue() {
        return Revenue.get();
    }

    public void setArrivalDate(Date _date) {
        ArrivalDate.set(_date);
    }
    public Date getArrivalDate( ) { return ArrivalDate.get();    }

    public void setDepartureDate(Date _date) {
        DepartureDate.set(_date);
    }
    public Date getDepartureDate( ) { return DepartureDate.get();    }

    public void setBusinessClassFare(int bFare){BusinessClassFare.set(bFare);}
    public double getBusinessClassFare(){return BusinessClassFare.get();}

    public void setExecutiveClassFare(int eFare){ExecutiveClassFare.set(eFare);}
    public double getExecutiveClassFare(){return ExecutiveClassFare.get();}


    public IntegerProperty flightNumProperty() {
        return FlightNumber;
    }
    public IntegerProperty dTimeProperty() { return DepartureTime; }
    public IntegerProperty aTimeProperty() {
        return ArrivalTime;
    }
    public StringProperty dLocationProperty() {
        return DepartureLocation;
    }
    public StringProperty aLocationProperty() {
        return ArrivalLocation;
    }
    public DoubleProperty fareProperty() {return Fare; }
    public StringProperty flightStatusProperty() {return FlightStatus; }
    public DoubleProperty revenueProperty() {return Revenue; }
    public ObjectProperty<Date> dDateProperty() {
        return DepartureDate;
    }
    public ObjectProperty<Date> aDateProperty() {
        return ArrivalDate;
    }
    public DoubleProperty busFareProperty() { return BusinessClassFare; }
    public DoubleProperty execFareProperty() { return ExecutiveClassFare; }

}


