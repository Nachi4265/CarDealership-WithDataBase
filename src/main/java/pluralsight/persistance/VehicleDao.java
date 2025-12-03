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
                    "SELECT film.film_id, title, length, rating FROM film join film_actor on film.film_id = film_actor.film_id where film_actor.actor_id = ? ")
        ){
            preparedStatement.setDouble(1,minPrice);
            preparedStatement.setDouble(2,maxPrice);


            try(ResultSet result = preparedStatement.executeQuery()){

                if(result.next()){
                    System.out.println("Your matches are: \n");

                    do{
                        int VIN = result.getInt("VIN");
                        int year = result.getInt("Vehicle_Year");
                        String make = result.getString("Make");
                        String model = result.getString("Model");
                        String vehicleType = result.getString("VehicleType");
                        String color = result.getString("Color");
                        int odometer = result.getInt("Odometer");
                        double price = result.getDouble("Price");
                        int sold = result.getInt("Sold");
                        String saleDate = result.getString("saleDate");

                        Vehicle vehicle = new Vehicle(VIN,year,make,model,vehicleType,color,odometer,price,sold,saleDate);
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

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return null;
    }


    //todo fix connection
    public void addVehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price, int sold, String saleDate) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vehicles(VIN, Vehicle_Year, Make, Model, VehicleType, Color, Odometer, Price, Sold, saleDate)\n" +
                    "VALUES( ?, ? , ? , ? , ? , ? , ? , ? , ? );");
        ){

            preparedStatement.setInt(1, vin);
            preparedStatement.setInt(2, year);  // Assuming this is Vehicle_Year
            preparedStatement.setString(3, make);
            preparedStatement.setString(4, model);
            preparedStatement.setString(5, vehicleType);
            preparedStatement.setString(6, color);
            preparedStatement.setInt(7, odometer);
            preparedStatement.setDouble(8, price);
            preparedStatement.setInt(9, sold);
            preparedStatement.setString(10,saleDate);

            preparedStatement.executeUpdate();

            //execute the query
            int rows  = preparedStatement.executeUpdate();

            //confirm update
            System.out.printf("Rows updated %d\n ",rows);
        }
        catch (SQLException e){
            System.out.println("There was an error: " +  e.getMessage());
            e.printStackTrace();
        }

    }
}
