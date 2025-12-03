package pluralsight.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    //CONSTRUCTOR
    public Dealership(String name, String address, String phone) {
        this.inventory = new ArrayList<>();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }



    //GETTERS AND SETTERS.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }





    //METHODS

    //ADD OR REMOVE VEHICLE
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void remove(Vehicle vehicle){
        inventory.remove(vehicle);
    }




    //GET VEHICLE BY INFORMATION
    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice){

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

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make , String model){
        ArrayList<Vehicle> makeModelResult = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(Objects.equals(vehicle.getMake(), make) && Objects.equals(vehicle.getModel(), model)){
                makeModelResult.add(vehicle);
            }
        }
        return makeModelResult;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int minYear,int maxYear){
        ArrayList<Vehicle>yearResults = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear){
                yearResults.add(vehicle);
            }
        }
        return yearResults;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> colorResult = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(vehicle.getColor().equals(color)){
                colorResult.add(vehicle);
            }
        }
        return colorResult;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMiles, int maxMiles ){
        ArrayList<Vehicle> mileageResult = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(vehicle.getOdometer() >= minMiles && vehicle.getOdometer() <= maxMiles){
                 mileageResult.add(vehicle);
            }
        }
         return mileageResult;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){

        ArrayList<Vehicle>vehiclesTypeResult = new ArrayList<>();

        for (Vehicle vehicle: inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType.toLowerCase())){
                vehiclesTypeResult.add(vehicle);
            }
        }
        return vehiclesTypeResult;
    }

//    //todo bug not working properly
//    public Vehicle getVehiclesByVIN(int vin) {
//
//        Vehicle vehicleByVin;
//
//        for(Vehicle v : inventory){
//            if(vin == v.getVIN()){
//                vehicleByVin =  v;
//            } else {
//                System.out.println("Vehicle Not found");
//            }
//        }
//
////        if(vinFound == false){
////            System.out.println("Vehicle Not found");
////        }
//
//        return null;
//    }

//    public Vehicle getVehiclesByVIN(int vin) {
//
//        // empty placeholder for when we find a vehicle
//        Vehicle foundVehicle = null;
//
//        //look for vehicle
//        for(Vehicle v : inventory){
//            if(vin == v.getVIN()){
//                // store the found vehicle
//                foundVehicle = v;
//                break;
//            }
//        }
//        if (foundVehicle != null) {
//            System.out.println("Vehicle found: " + foundVehicle);
//
//
//        }else {
//            System.out.println("Vehicle with VIN: " + vin + " not found!");
//        }
//
//        return foundVehicle;
//
//
//
//
//
//        return null;
//    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }



}
