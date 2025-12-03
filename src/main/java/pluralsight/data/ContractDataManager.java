package pluralsight.data;

import pluralsight.models.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ContractDataManager {

//    Phase 2
//    Phase 2 should be the construction of your ContractDataManager.  The
//    saveContract() method will accept a Contract parameter, but you will need
//    to use instanceof to check the type of contract because the format of what you
//    write to the file changes depending on the contract type.

    public void saveContract(Contract contract){

        //If it's a Sales Contract
        if(contract instanceof SalesContract){
            try{
                FileWriter fileWriter = new FileWriter("Contracts.csv" , true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                //Casting our contract
              //Type of Variable _ varible name = (Cast Type) original type
                SalesContract sale = (SalesContract) contract;

                //Write the Sales Contract information
                String saleContractData=
                        "SALE"
                        + "|" + sale.getContractDate()
                        + "|" + sale.getCustomerName()
                        + "|" + sale.getCustomerEmail()
                        + "|" + sale.getVehicleSold().getVIN()
                        + "|" + sale.getVehicleSold().getYear()
                        + "|" + sale.getVehicleSold().getMake()
                        + "|" + sale.getVehicleSold().getModel()
                        + "|" + sale.getVehicleSold().getVehicleType()
                        + "|" + sale.getVehicleSold().getColor()
                        + "|" + sale.getVehicleSold().getOdometer()
                        + "|" + sale.getVehicleSold().getPrice()
                        + "|" + sale.getSalesTax()
                        + "|" + sale.getRecordingFee()
                        + "|" + sale.getProcessingFee()
                        + "|" + sale.getTotalPrice()
                        + "|" + sale.isFinance()
                        + "|" + sale.getMonthlyPayment();

                //Write our contract
                bufferedWriter.write(saleContractData);

                //Add a new line so it's not clumped together
                bufferedWriter.newLine();
                bufferedWriter.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //If it's Lease Contract
        if(contract instanceof LeaseContract){
            try{
                FileWriter fileWriter = new FileWriter("Contracts.csv" ,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                LeaseContract lease = (LeaseContract) contract;
                //Write the Sales Contract information
                String leaseContractData =

                            "LEASE"
                            + "|" + lease.getContractDate()
                            + "|" + lease.getCustomerName()
                            + "|" + lease.getCustomerEmail()
                            + "|" + lease.getVehicleSold().getVIN()
                            + "|" + lease.getVehicleSold().getYear()
                            + "|" + lease.getVehicleSold().getMake()
                            + "|" + lease.getVehicleSold().getModel()
                            + "|" + lease.getVehicleSold().getVehicleType()
                            + "|" + lease.getVehicleSold().getColor()
                            + "|" + lease.getVehicleSold().getOdometer()
                            + "|" + lease.getVehicleSold().getPrice()
                            + "|" + lease.getEndingValue()
                            + "|" + lease.getLeaseFee()
                            + "|" + lease.getTotalPrice()
                            + "|" + lease.getMonthlyPayment();

                bufferedWriter.write(leaseContractData);
                bufferedWriter.newLine();
                bufferedWriter.close();


            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }



//    public Contract getContract() {
//
//        Contract contractFromFile = null;
//
//        //first lets read from our file
//        try {
//            FileReader fileReader = new FileReader("Contracts.csv");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//
//            String readLineFromFile;
//            readLineFromFile = bufferedReader.readLine();
//
//            //Now we need to loop through each line of the rest of our file and make vehicles from it.
//            while ((readLineFromFile = bufferedReader.readLine()) != null) {
//
//
//                //Store each of our pieces from out inventory into variables
//                String[] contractParts = readLineFromFile.split("\\|");
//                String contractType = contractParts[0];
//                String contractDate = contractParts[1];
//                String contractCustomer = contractParts[2];
//                String contractEmail = contractParts[3];
//                int contractVehicleVin = Integer.parseInt(contractParts[4]);
//                int contractVehicleYear = Integer.parseInt(contractParts[5]);
//                String contractVehicleMake = contractParts[6];
//                String contractVehicleModel = contractParts[7];
//                String contractVehicleColor = contractParts[8];
//                int contractVehicleOdometer = Integer.parseInt(contractParts[9]);
//                double contractVehiclePrice = Double.parseDouble(contractParts[10]);
//
//                //Using the information from above we are going to make a vehicle and add it to our dealership
//                Vehicle vehicleFromInventory = new Vehicle(VIN, year, make, model, vehicleType, color, odometer, price);
//
//                //Add our vehicle to our inventory
//                dealershipFromFile.addVehicle(vehicleFromInventory);
//
//            }
//            bufferedReader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //return our dealership
//        return dealershipFromFile;
//    }
}
