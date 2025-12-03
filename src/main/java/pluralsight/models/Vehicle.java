package pluralsight.models;

import java.util.Date;

public class Vehicle {

    //Private class variables
    private int VIN;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;
    private int sold;
    private String saleDate;


    //CONSTRUCTOR
    public Vehicle(int VIN, int year, String make, String model, String vehicleType, String color, int odometer, double price,int sold , String saleDate) {
        this.VIN = VIN;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.sold = sold;
        this.saleDate = saleDate;
    }



    //GETTERS AND SETTERS.
    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return  getVIN()
                + " | " + getYear()
                + " | " + getMake()
                + " | " + getModel()
                + " | " + getVehicleType()
                + " | " + getColor()
                + " | " + getOdometer()
                + " | " + getPrice()
                + " | " + getSold()
                + " | " + getSaleDate();
    }

}
