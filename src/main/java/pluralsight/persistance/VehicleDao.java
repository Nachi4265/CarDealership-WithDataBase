package pluralsight.persistance;

import org.apache.commons.dbcp2.BasicDataSource;
import pluralsight.models.Vehicle;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void displayVehiclesHelper(ArrayList<Vehicle> vehicleToList){
//        for(Vehicle v : vehicleToList){
//            System.out.println(
//                    v.getVIN()
//                            + " | " +v.getYear()
//                            + " | " +v.getMake()
//                            + " | " +v.getModel()
//                            + " | " +v.getVehicleType()
//                            + " | " +v.getColor()
//                            + " | " +v.getOdometer()
//                            + " | " + v.getPrice());
//        }
        vehicleToList.forEach(System.out::println);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) throws SQLException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    //todo fix SQL statment
                    "SELECT * FROM vehicles WHERE Price BETWEEN ? AND ?")
        ){
            preparedStatement.setDouble(1,minPrice);
            preparedStatement.setDouble(2,maxPrice);


            try(ResultSet result = preparedStatement.executeQuery()){

                if(result.next()){
                    System.out.println("Your matches are: \n");

                    do{
                        String VIN = result.getString("VIN");
                        int year = result.getInt("Vehicle_Year");
                        String make = result.getString("Make");
                        String model = result.getString("Model");
                        String vehicleType = result.getString("VehicleType");
                        String color = result.getString("Color");
                        int odometer = result.getInt("Odometer");
                        double price = result.getDouble("Price");
                        int sold = result.getInt("Sold");


                        Vehicle vehicle = new Vehicle(VIN,year,make,model,vehicleType,color,odometer,price,sold);
                        vehicles.add(vehicle);
                    }

                    while(result.next());
                }else{
                    System.out.println("no matches!");
                }
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String vehicleMake, String vehicleModel) throws SQLException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    //todo fix SQL statment
                    "SELECT * FROM vehicles WHERE Make = ? AND Model = ?")
        ){
            preparedStatement.setString(1,vehicleMake);
            preparedStatement.setString(2,vehicleModel);


            try(ResultSet result = preparedStatement.executeQuery()){

                if(result.next()){
                    System.out.println("Your matches are: \n");

                    do{
                        String VIN = result.getString("VIN");
                        int year = result.getInt("Vehicle_Year");
                        String make = result.getString("Make");
                        String model = result.getString("Model");
                        String vehicleType = result.getString("VehicleType");
                        String color = result.getString("Color");
                        int odometer = result.getInt("Odometer");
                        double price = result.getDouble("Price");
                        int sold = result.getInt("Sold");


                        Vehicle vehicle = new Vehicle(VIN,year,make,model,vehicleType,color,odometer,price,sold);
                        vehicles.add(vehicle);
                    }

                    while(result.next());
                }else{
                    System.out.println("no matches!");
                }
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) throws SQLException {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(

                    "SELECT * FROM vehicles WHERE Vehicle_year between ? AND ? ")
        ){
            preparedStatement.setInt(1,minYear);
            preparedStatement.setInt(2,maxYear);


            try(ResultSet result = preparedStatement.executeQuery()){

                if(result.next()){
                    System.out.println("Your matches are: \n");

                    do{
                        String VIN = result.getString("VIN");
                        int year = result.getInt("Vehicle_Year");
                        String make = result.getString("Make");
                        String model = result.getString("Model");
                        String vehicleType = result.getString("VehicleType");
                        String color = result.getString("Color");
                        int odometer = result.getInt("Odometer");
                        double price = result.getDouble("Price");
                        int sold = result.getInt("Sold");


                        Vehicle vehicle = new Vehicle(VIN,year,make,model,vehicleType,color,odometer,price,sold);
                        vehicles.add(vehicle);
                    }

                    while(result.next());
                }else{
                    System.out.println("no matches!");
                }
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) throws SQLException {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM vehicles WHERE Color = ?")
        ){
            preparedStatement.setString(1, color);

            try(ResultSet result = preparedStatement.executeQuery()){

                if(result.next()){
                    System.out.println("Your matches are: \n");

                    do{
                        String VIN = result.getString("VIN");
                        int year = result.getInt("Vehicle_Year");
                        String make = result.getString("Make");
                        String model = result.getString("Model");
                        String vehicleType = result.getString("VehicleType");
                        String vehicleColor = result.getString("Color");
                        int odometer = result.getInt("Odometer");
                        double price = result.getDouble("Price");
                        int sold = result.getInt("Sold");


                        Vehicle vehicle = new Vehicle(VIN, year, make, model, vehicleType, vehicleColor, odometer, price, sold);
                        vehicles.add(vehicle);
                    }
                    while(result.next());
                } else {
                    System.out.println("No matches!");
                }
            }
        }
        return vehicles;

    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) throws SQLException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM vehicles WHERE Odometer BETWEEN ? AND ?")
        ){
            preparedStatement.setInt(1, minMileage);
            preparedStatement.setInt(2, maxMileage);

            try(ResultSet result = preparedStatement.executeQuery()){

                if(result.next()){
                    System.out.println("Your matches are: \n");

                    do{
                        String VIN = result.getString("VIN");
                        int year = result.getInt("Vehicle_Year");
                        String make = result.getString("Make");
                        String model = result.getString("Model");
                        String vehicleType = result.getString("VehicleType");
                        String color = result.getString("Color");
                        int odometer = result.getInt("Odometer");
                        double price = result.getDouble("Price");
                        int sold = result.getInt("Sold");


                        Vehicle vehicle = new Vehicle(VIN, year, make, model, vehicleType, color, odometer, price, sold);
                        vehicles.add(vehicle);
                    }
                    while(result.next());
                } else {
                    System.out.println("No matches!");
                }
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) throws SQLException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM vehicles WHERE UPPER(VehicleType) = UPPER(?)")
        ){
            preparedStatement.setString(1, vehicleType);

            try(ResultSet result = preparedStatement.executeQuery()){

                if(result.next()){
                    System.out.println("Your matches are: \n");

                    do{
                        String VIN = result.getString("VIN");
                        int year = result.getInt("Vehicle_Year");
                        String make = result.getString("Make");
                        String model = result.getString("Model");
                        String type = result.getString("VehicleType");
                        String color = result.getString("Color");
                        int odometer = result.getInt("Odometer");
                        double price = result.getDouble("Price");
                        int sold = result.getInt("Sold");


                        Vehicle vehicle = new Vehicle(VIN, year, make, model, type, color, odometer, price, sold);
                        vehicles.add(vehicle);
                    }
                    while(result.next());
                } else {
                    System.out.println("No matches!");
                }
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getAllVehicles() throws SQLException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM vehicles")
        ){
            // No parameters needed for SELECT ALL

            try(ResultSet result = preparedStatement.executeQuery()){

                if(result.next()){
                    System.out.println("All vehicles: \n");

                    do{
                        String VIN = result.getString("VIN");
                        int year = result.getInt("Vehicle_Year");
                        String make = result.getString("Make");
                        String model = result.getString("Model");
                        String vehicleType = result.getString("VehicleType");
                        String color = result.getString("Color");
                        int odometer = result.getInt("Odometer");
                        double price = result.getDouble("Price");
                        int sold = result.getInt("Sold");


                        Vehicle vehicle = new Vehicle(VIN, year, make, model, vehicleType, color, odometer, price, sold);
                        vehicles.add(vehicle);
                    }
                    while(result.next());
                } else {
                    System.out.println("No vehicles in inventory!");
                }
            }
        }
        return vehicles;
    }


    //todo fix connection
    public void addVehicle(String vin, int year, String make, String model, String vehicleType, String color, int odometer, double price, int sold) throws SQLException {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vehicles(VIN, Vehicle_Year, Make, Model, VehicleType, Color, Odometer, Price, Sold)\n" +
                    "VALUES( ?, ? , ? , ? , ? , ? , ? , ? , ? );");
        ){

            preparedStatement.setString(1, vin);
            preparedStatement.setInt(2, year);  // Assuming this is Vehicle_Year
            preparedStatement.setString(3, make);
            preparedStatement.setString(4, model);
            preparedStatement.setString(5, vehicleType);
            preparedStatement.setString(6, color);
            preparedStatement.setInt(7, odometer);
            preparedStatement.setDouble(8, price);
            preparedStatement.setInt(9, sold);

            preparedStatement.executeUpdate();

            //execute the query
            int rows  = preparedStatement.executeUpdate();

            //confirm update
            System.out.printf("Rows updated %d\n ",rows);
        }
    }
}
