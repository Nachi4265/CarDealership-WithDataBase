package pluralsight.persistance;

import org.apache.commons.dbcp2.BasicDataSource;
import pluralsight.data.ContractDataManager;
import pluralsight.data.DealershipFileManager;
import pluralsight.models.Vehicle;
import pluralsight.userInterface.InputCollector;

public class LeaseContractDao {

    private BasicDataSource dataSource;

    public LeaseContractDao(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void makeLeaseContract() {
        System.out.println("HERE IS A FULL LIST OF VEHICLES!");
        System.out.println("---------------------------------");

        //Display all Vehicles
//        VehicleDao.displayVehiclesHelper();


//        int vin = InputCollector.promptForInt("Enter vehicle VIN you want to sell: ");
//        Vehicle foundVehicle = null;
//
//        // loop through inventory to find VIN
//        for (Vehicle v : dealership.getAllVehicles()){
//
//            if (v.getVIN() == vin) {
//                foundVehicle = v;
//                break;
//            }
//        }
//
//        if (foundVehicle != null) {
//            System.out.println("Vehicle found: " + foundVehicle);
//            String contractDate  = InputCollector.promptForString("Enter Contract Date (YYYY-mm-dd)");
//            String contractName  = InputCollector.promptForString("Enter customer name");
//            String contractEmail = InputCollector.promptForString("Enter email (SomeExample@gmail.com)");
//
//            // Make contract
////            LeaseContract leaseContract = new LeaseContract(contractDate, contractName, contractEmail, foundVehicle);
////            System.out.println("Lease contract created successfully for " + contractName + "!");
//
//            // Make Contract Data Manager
//            ContractDataManager contractDataManager = new ContractDataManager();
//
////            contractDataManager.saveContract(leaseContract);
//            dealership.remove(foundVehicle);
//
//            DealershipFileManager dealershipFileManager = new DealershipFileManager();
//            dealershipFileManager.saveDealership(dealership);
//        }

    }

}
