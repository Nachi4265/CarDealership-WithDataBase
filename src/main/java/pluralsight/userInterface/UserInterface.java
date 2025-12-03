package pluralsight.userInterface;

import pluralsight.data.ContractDataManager;
import pluralsight.models.Dealership;
import pluralsight.data.DealershipFileManager;
import pluralsight.models.LeaseContract;
import pluralsight.models.SalesContract;
import pluralsight.models.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {

    //Class level variable so all methods can access it
    Dealership dealership;
    DealershipFileManager dealershipFileManager;
//    AdminUserInterface adminUserInterface;



    //User Interface Constructor that should get our dealership
    public UserInterface(){
        //When a user interface is made it should load our dealership so our information is ready.

        //Create an instance of file manager
         this.dealershipFileManager = new DealershipFileManager();

        //Our Class level variable is assigned to our Dealership File Manager which gets our dealership info
        this.dealership =  dealershipFileManager.getDealership();
    }



    //How our user menu is display
    public void display(){


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
            11- Admin Menu\n
            99 - Quit
            """;

            System.out.println(mainMenu);

            int command = InputCollector.promptForInt("Enter a number command");

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
                case 11:
                    adminMenu();
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

    private void adminMenu() {
//        adminUserInterface = new AdminUserInterface();
//
//        adminUserInterface.adminDisplay();
//        adminUserInterface.enterPassword();
    }


    //a private displayVehicles() helper method.  Because you will be
    //displaying many different lists of vehicles, it makes sense to have a helper
    //method that displays the list and can be called from all the get-vehicles
    //type methods.  This method should have a parameter that is passed in
    //containing the vehicles to list.  Within the method, create a loop and
    //display the vehicles!

    private void displayVehiclesHelper(ArrayList<Vehicle>vehicleToList){
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




    //METHODS TO GET REQUEST FROM USER.
    private void processGetByPriceRequest() {
        System.out.println("What is the minimum and maximum price?");
       double minPrice = InputCollector.promptForDouble("Enter minimum price");
       double maxPrice = InputCollector.promptForDouble("Enter maximum price");

       ArrayList<Vehicle>vehiclesByPrice = dealership.getVehiclesByPrice(minPrice,maxPrice);
       displayVehiclesHelper(vehiclesByPrice);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("What is the Make and Model you are looking for?");
        String make = InputCollector.promptForString("Enter Make");
        String model = InputCollector.promptForString("Enter Model");

        ArrayList<Vehicle>vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make,model);
        displayVehiclesHelper(vehiclesByMakeModel);

        //what you want to stream
//        ArrayList<Vehicle>makeAndModel = vehiclesByMakeModel.stream(),.filter( Vehicle -> make,model)
      }

    private void processGetByYearRequest() {
        System.out.println("What is the year you are looking for?");
        int minYear = InputCollector.promptForInt("Enter Minimum Year (YYYY)");
        int maxYear = InputCollector.promptForInt("Enter Maximum Year (YYYY)");

        ArrayList<Vehicle>vehiclesByYear = dealership.getVehiclesByYear(minYear,maxYear);
        displayVehiclesHelper(vehiclesByYear);
    }

    private void processGetByColorRequest() {
        System.out.println("What vehicle color you are looking for?");
        String color = InputCollector.promptForString("Enter color");

        ArrayList<Vehicle>vehiclesByColor = dealership.getVehiclesByColor(color);
        displayVehiclesHelper(vehiclesByColor);



    }//todo add ignore case

    private void processGetByMileageRequest() {
        System.out.println("What vehicle mileage you are looking for?");
        int minMileage = InputCollector.promptForInt("Enter minimum mileage");
        int maxMileage = InputCollector.promptForInt("Enter maximum mileage");

        ArrayList<Vehicle>vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehiclesHelper(vehiclesByMileage);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("What Type of vehicle are you searching for?");
        String vehicleType = InputCollector.promptForString("Enter vehicle type").toUpperCase();

        //this is our Array list of Vehicles by type
        ArrayList<Vehicle>vehiclesByType = dealership.getVehiclesByType(vehicleType);
        displayVehiclesHelper(vehiclesByType);


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

    private void processGetByGetAllVehicleRequest() {
       displayVehiclesHelper(dealership.getAllVehicles());
    }


    //Add and remove request
    private void processAddVehicleRequest() {
        int VIN  = InputCollector.promptForInt("What is the vehicle VIN number");
        int year = InputCollector.promptForInt("What is the Year of your vehicle");
        String make = InputCollector.promptForString("What is the vehicle make?");
        String model = InputCollector.promptForString("What is the vehicle model?");
        String vehicleType = InputCollector.promptForString("What is the vehicle type");
        String color = InputCollector.promptForString("What is the color of the vehicle");
        int odometer = InputCollector.promptForInt("What is the mileage of the vehicle");
        double price = InputCollector.promptForDouble("What is your asking price for the vehicle");

        System.out.println("Vehicle ");
        Vehicle vehicleToAdd = new Vehicle(VIN,year,make,model,vehicleType,color,odometer,price);
        dealership.addVehicle(vehicleToAdd);

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);

    }

    private void processRemoveVehicleRequest() {

        //Put in the information of the vehicle we want to remove
        int VIN  = InputCollector.promptForInt("What is the vehicle VIN number");

        boolean found = false;

        for(Vehicle v : dealership.getAllVehicles()){
            if(VIN == v.getVIN()){
                found = true;
                dealership.remove(v);
                System.out.println("Vehicle Removed!");
                this.dealershipFileManager.saveDealership(dealership);
                break;
            }
        }

        if( found == false){
                System.out.println("Could not find that Vehicles VIN");
        }
    }



    //SELL OR LEASE VEHICLE
    private void processSellLeaseVehicleMenu() {
        System.out.println("Would you like to sell a Vehicle or Lease?");
        System.out.println("1. Sell ");
        System.out.println("2. Lease ");

        int userChoice = InputCollector.promptForInt("Enter a command");

        while(true){
            switch (userChoice){
                case 1:
                    makeSalesContract();
                    return;
                case 2:
                    makeLeaseContract();
                    return;
                default:
                    System.out.println("Invalid entry");
                    return;
            }
        }
    }

    private void makeLeaseContract() {
        System.out.println("HERE IS A FULL LIST OF VEHICLES!");
        System.out.println("---------------------------------");

        //Display all Vehicles
        displayVehiclesHelper(dealership.getAllVehicles());


        int vin = InputCollector.promptForInt("Enter vehicle VIN you want to sell: ");
        Vehicle foundVehicle = null;

        // loop through inventory to find VIN
        for (Vehicle v : dealership.getAllVehicles()){

            if (v.getVIN() == vin) {
                foundVehicle = v;
                break;
            }
        }

        if (foundVehicle != null) {
            System.out.println("Vehicle found: " + foundVehicle);
            String contractDate  = InputCollector.promptForString("Enter Contract Date (YYYY-mm-dd)");
            String contractName  = InputCollector.promptForString("Enter customer name");
            String contractEmail = InputCollector.promptForString("Enter email (SomeExample@gmail.com)");

            // Make contract
            LeaseContract leaseContract = new LeaseContract(contractDate, contractName, contractEmail, foundVehicle);
            System.out.println("Lease contract created successfully for " + contractName + "!");

            // Make Contract Data Manager
            ContractDataManager contractDataManager = new ContractDataManager();

            contractDataManager.saveContract(leaseContract);
            dealership.remove(foundVehicle);

            DealershipFileManager dealershipFileManager = new DealershipFileManager();
            dealershipFileManager.saveDealership(dealership);
        }

    }

    private void makeSalesContract() {

        System.out.println("HERE IS A FULL LIST OF VEHICLES!");
        System.out.println("---------------------------------");

        //Display all Vehicles
        displayVehiclesHelper(dealership.getAllVehicles());

        int vin = InputCollector.promptForInt("Enter vehicle VIN you want to sell: ");
        Vehicle foundVehicle = null;

        // loop through inventory to find VIN
        for (Vehicle v : dealership.getAllVehicles()){

            if (v.getVIN() == vin) {
                foundVehicle = v;
                break;
            }
        }

        if (foundVehicle != null) {
            System.out.println("Vehicle found: " + foundVehicle);
            String contractDate  = InputCollector.promptForString("Enter Contract Date (YYYY-mm-dd)");
            String contractName  = InputCollector.promptForString("Enter customer name");
            String contractEmail = InputCollector.promptForString("Enter email (SomeExample@gmail.com)");
            String financeOption = InputCollector.promptForString("Would you like to finance? (Y/N)");
            boolean isFinanced = financeOption.equalsIgnoreCase("yes") ? true : false;

            // Make contract
            SalesContract salesContract = new SalesContract(contractDate,contractName,contractEmail,foundVehicle,isFinanced);
            System.out.println("Sales contract created successfully for " + contractName + "!");

            // Make Contract Data Manager
            ContractDataManager contractDataManager = new ContractDataManager();

            contractDataManager.saveContract(salesContract);
            dealership.remove(foundVehicle);

            DealershipFileManager dealershipFileManager = new DealershipFileManager();
            dealershipFileManager.saveDealership(dealership);
        }

    }

}
