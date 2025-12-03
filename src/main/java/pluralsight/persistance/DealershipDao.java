package pluralsight.persistance;

import org.apache.commons.dbcp2.BasicDataSource;
import pluralsight.models.Dealership;
import pluralsight.models.Vehicle;

import java.util.ArrayList;
import java.util.Objects;

public class DealershipDao {

    private BasicDataSource dataSource;

    public DealershipDao(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }



    //METHODS
    //ADD OR REMOVE VEHICLE
    public static void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public static void remove(Vehicle vehicle){
        inventory.remove(vehicle);
    }




    //GET VEHICLE BY INFORMATION
    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public static ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice){

        //loop through each vehicle, if it is withing the correct price return the result.
        // ask what is the maximum and minimum price you are looking for.
        //Look at each vehicle in my list,
        //compare the value of that vehicle to the max and min price
        //if it's within that range then show me the vehicle.

        //An ArrayList that will store all of our vehicles that match our
        ArrayList<Vehicle> results = new ArrayList<>();

        for(Vehicle vehicle:inventory){

            //if the vehicle price is less
            if(vehicle.getPrice() > minPrice && vehicle.getPrice() < maxPrice){
                //  System.out.println(vehicle);
                results.add(vehicle);
            }
        }
        //Return the vehicles that are within our range.
        return results;
    }

    public static ArrayList<Vehicle> getVehiclesByMakeModel(String make , String model){
        ArrayList<Vehicle> makeModelResult = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(Objects.equals(vehicle.getMake(), make) && Objects.equals(vehicle.getModel(), model)){
                makeModelResult.add(vehicle);
            }
        }
        return makeModelResult;
    }

    public static ArrayList<Vehicle> getVehiclesByYear(int minYear,int maxYear){
        ArrayList<Vehicle>yearResults = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear){
                yearResults.add(vehicle);
            }
        }
        return yearResults;
    }

    public static ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> colorResult = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(vehicle.getColor().equals(color)){
                colorResult.add(vehicle);
            }
        }
        return colorResult;
    }

    public static ArrayList<Vehicle> getVehiclesByMileage(int minMiles, int maxMiles ){
        ArrayList<Vehicle> mileageResult = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(vehicle.getOdometer() >= minMiles && vehicle.getOdometer() <= maxMiles){
                mileageResult.add(vehicle);
            }
        }
        return mileageResult;
    }

    public static ArrayList<Vehicle> getVehiclesByType(String vehicleType){

        ArrayList<Vehicle>vehiclesTypeResult = new ArrayList<>();

        for (Vehicle vehicle: inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType.toLowerCase())){
                vehiclesTypeResult.add(vehicle);
            }
        }
        return vehiclesTypeResult;
    }

}
