package pluralsight.persistance;

import org.apache.commons.dbcp2.BasicDataSource;
import pluralsight.models.Vehicle;

import java.util.ArrayList;

public class VehicleDao {

    private BasicDataSource dataSource;

    public VehicleDao(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void displayVehiclesHelper(ArrayList<Vehicle> vehicleToList){
        for(Vehicle v : vehicleToList){
            System.out.println(
                    v.getVIN()
                            + " | " +v.getYear()
                            + " | " +v.getMake()
                            + " | " +v.getModel()
                            + " | " +v.getVehicleType()
                            + " | " +v.getColor()
                            + " | " +v.getOdometer()
                            + " | " + v.getPrice());
        }
//         vehicleToList.forEach(System.out::println);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        return null;
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

}
