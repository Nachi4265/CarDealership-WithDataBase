package pluralsight.persistance;

import org.apache.commons.dbcp2.BasicDataSource;
import pluralsight.data.ContractDataManager;
import pluralsight.data.DealershipFileManager;
import pluralsight.models.SalesContract;
import pluralsight.models.Vehicle;
import pluralsight.userInterface.InputCollector;

public class SalesContractDao {

    private BasicDataSource dataSource;

    public SalesContractDao(BasicDataSource dataSource) {
        this.dataSource =  dataSource;
    }

    public static void makeSalesContract() {

//        System.out.println("HERE IS A FULL LIST OF VEHICLES!");
//        System.out.println("---------------------------------");
//
//        //Display all Vehicles
//        vehicleDao.displayVehiclesHelper(.getAllVehicles());
//
//        int vin = InputCollector.promptForInt("Enter vehicle VIN you want to sell: ");
//        Vehicle foundVehicle = null;
//
//        // loop through inventory to find VIN
//        for (Vehicle v : DealershipDao.getAllVehicles()){
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
//            String financeOption = InputCollector.promptForString("Would you like to finance? (Y/N)");
//            boolean isFinanced = financeOption.equalsIgnoreCase("yes") ? true : false;
//
//            // Make contract
//            SalesContract salesContract = new SalesContract(contractDate,contractName,contractEmail,foundVehicle,isFinanced);
//            System.out.println("Sales contract created successfully for " + contractName + "!");
//
//            // Make Contract Data Manager
//            ContractDataManager contractDataManager = new ContractDataManager();
//
//            contractDataManager.saveContract(salesContract);
//            dealership.remove(foundVehicle);
//
//            DealershipFileManager dealershipFileManager = new DealershipFileManager();
//            dealershipFileManager.saveDealership(dealership);
//        }

    }

}
