package pluralsight.userInterface;

import org.apache.commons.dbcp2.BasicDataSource;
import pluralsight.data.DealershipFileManager;
import pluralsight.models.Vehicle;
import pluralsight.persistance.DealershipDao;
import pluralsight.persistance.LeaseContractDao;
import pluralsight.persistance.SalesContractDao;
import pluralsight.persistance.VehicleDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DealershipConsoleApp {

    private BasicDataSource basicDataSource;
    private DealershipDao dealershipDao;
    private LeaseContractDao leaseContractDao;
    private SalesContractDao salesContractDao;
    private VehicleDao vehicleDao;


    public DealershipConsoleApp(BasicDataSource basicDataSource , DealershipDao dealershipDao ,LeaseContractDao leaseContractDao, SalesContractDao salesContractDao,VehicleDao vehicleDao){
        this.basicDataSource = basicDataSource;
        this.dealershipDao = dealershipDao;
        this.leaseContractDao = leaseContractDao;
        this.salesContractDao = salesContractDao;
        this.vehicleDao = vehicleDao;
    }

    public void start(){

        System.out.println("==WELCOME TO CAR DEALERSHIP==");
        System.out.println();

        while (true){
            String mainMenu = """
            ===================| MENU |======================
            1 - Find vehicles within a price range\n
            2 - Find vehicles by make / model\n
            3 - Find vehicles by year range\n
            4 - Find vehicles by color\n
            5 - Find vehicles by mileage range\n
            6 - Find vehicles by type (truck, SUV, van)\n
            7 - List ALL vehicles\n
            8 - Add a vehicle\n
            9 - Remove a vehicle\n
            10- Sell/Lease Vehicle\n
            99 - Quit
            """;

            System.out.println(mainMenu);

            int command = InputCollector.promptForInt("Enter Here");

            switch (command){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetByGetAllVehicleRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSellLeaseVehicleMenu();
                    break;
                case 99:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }


    }



    //VEHICLE METHODS
    public void processGetByPriceRequest() {

        try{

            System.out.println("What is the minimum and maximum price?");
            double minPrice = InputCollector.promptForDouble("Enter minimum price");
            double maxPrice = InputCollector.promptForDouble("Enter maximum price");

            ArrayList<Vehicle> vehiclesByPrice = vehicleDao.getVehiclesByPrice(minPrice,maxPrice);
            vehicleDao.displayVehiclesHelper(vehiclesByPrice);

        }catch(SQLException e){
            System.out.println("Error: " +  e.getMessage());
            e.printStackTrace();
        }

    }

    public  void processGetByMakeModelRequest() {
        System.out.println("What is the Make and Model you are looking for?");
        String make = InputCollector.promptForString("Enter Make");
        String model = InputCollector.promptForString("Enter Model");

        ArrayList<Vehicle>vehiclesByMakeModel = vehicleDao.getVehiclesByMakeModel(make,model);
        vehicleDao.displayVehiclesHelper(vehiclesByMakeModel);

        //what you want to stream
//        ArrayList<Vehicle>makeAndModel = vehiclesByMakeModel.stream(),.filter( Vehicle -> make,model)
    }

    public  void processGetByYearRequest() {
        System.out.println("What is the year you are looking for?");
        int minYear = InputCollector.promptForInt("Enter Minimum Year (YYYY)");
        int maxYear = InputCollector.promptForInt("Enter Maximum Year (YYYY)");

        ArrayList<Vehicle>vehiclesByYear = vehicleDao.getVehiclesByYear(minYear,maxYear);
        vehicleDao.displayVehiclesHelper(vehiclesByYear);
    }

    public  void processGetByColorRequest() {
        System.out.println("What vehicle color you are looking for?");
        String color = InputCollector.promptForString("Enter color");

        ArrayList<Vehicle>vehiclesByColor = vehicleDao.getVehiclesByColor(color);
        vehicleDao.displayVehiclesHelper(vehiclesByColor);


    }//todo add ignore case

    public  void processGetByMileageRequest() {
        System.out.println("What vehicle mileage you are looking for?");
        int minMileage = InputCollector.promptForInt("Enter minimum mileage");
        int maxMileage = InputCollector.promptForInt("Enter maximum mileage");

        ArrayList<Vehicle>vehiclesByMileage = vehicleDao.getVehiclesByMileage(minMileage, maxMileage);
        vehicleDao.displayVehiclesHelper(vehiclesByMileage);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("What Type of vehicle are you searching for?");
        String vehicleType = InputCollector.promptForString("Enter vehicle type").toUpperCase();

        //this is our Array list of Vehicles by type
        ArrayList<Vehicle>vehiclesByType = vehicleDao.getVehiclesByType(vehicleType);
        vehicleDao.displayVehiclesHelper(vehiclesByType);


//        //LAMBDA EXPRESSION
//
//        //New list for us to store our Vehicles
//        List<String> results = vehiclesByType.stream()
//
//                //Filters our list if the Vehicle equals the type of Vehicle we typed
//                .filter(Vehicle -> vehicleType.equals(Vehicle.getVehicleType()))
//
//                //Changes All Vehicles "Strings"
//                .map(Vehicle -> vehicleType.toUpperCase())
//
//                //Collect those Vehicles to a list.
//                .collect(Collectors.toList());
//
//                //SHOW OUR RESULTS!
//                System.out.println(results);
    }

    public void processGetByGetAllVehicleRequest() {
        vehicleDao.displayVehiclesHelper(vehicleDao.getAllVehicles());
    }



    //Add and remove request
    public void processAddVehicleRequest() {
        int VIN  = InputCollector.promptForInt("What is the vehicle VIN number");
        int year = InputCollector.promptForInt("What is the Year of your vehicle");
        String make = InputCollector.promptForString("What is the vehicle make?");
        String model = InputCollector.promptForString("What is the vehicle model?");
        String vehicleType = InputCollector.promptForString("What is the vehicle type");
        String color = InputCollector.promptForString("What is the color of the vehicle");
        int odometer = InputCollector.promptForInt("What is the mileage of the vehicle");
        double price = InputCollector.promptForDouble("What is your asking price for the vehicle");
        int sold = InputCollector.promptForInt("Enter 0 if not Sold , Enter 1 if sold");
        String date = String.valueOf(InputCollector.promptForDate("What is the Date it was acquired? "));

        vehicleDao.addVehicle(VIN,year,make,model,vehicleType,color,odometer,price,sold,date);


//        DealershipFileManager dealershipFileManager = new DealershipFileManager();
//        dealershipFileManager.saveDealership(dealership);

    }

    public void processRemoveVehicleRequest() {

        //Put in the information of the vehicle we want to remove
//        int VIN  = InputCollector.promptForInt("What is the vehicle VIN number");
//
//        boolean found = false;
//
//        for(Vehicle v : vehicleDao.getAllVehicles()){
//            if(VIN == v.getVIN()){
//                found = true;
//                dealership.remove(v);
//                System.out.println("Vehicle Removed!");
//                this.dealershipFileManager.saveDealership(dealership);
//                break;
//            }
//        }
//
//        if( found == false){
//            System.out.println("Could not find that Vehicles VIN");
//        }
    }




    //SELL OR LEASE VEHICLE
    private void processSellLeaseVehicleMenu() {
        System.out.println("Would you like to sell a Vehicle or Lease?");
        System.out.println("1. Sell ");
        System.out.println("2. Lease ");
        System.out.println("3. Exit ");

        int userChoice = InputCollector.promptForInt("Enter a command");

        while(true){
            switch (userChoice){
                case 1:
                    SalesContractDao.makeSalesContract();
                    return;
                case 2:
                    LeaseContractDao.makeLeaseContract();
                    return;
                case 3:
                    return;
                default:
                    System.out.println("Invalid entry");
                    return;
            }
        }
    }

}
