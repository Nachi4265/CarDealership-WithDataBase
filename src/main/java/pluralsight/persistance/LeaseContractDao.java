package pluralsight.persistance;

import org.apache.commons.dbcp2.BasicDataSource;
//import pluralsight.data.ContractDataManager;
//import pluralsight.data.DealershipFileManager;
import pluralsight.models.LeaseContract;
import pluralsight.models.Vehicle;
import pluralsight.userInterface.InputCollector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseContractDao {

    private LeaseContract leaseContract;
    private BasicDataSource dataSource;
    private VehicleDao vehicleDao;

    public LeaseContractDao(BasicDataSource dataSource) {
        this.dataSource = dataSource;
        this.vehicleDao = vehicleDao;
        this.leaseContract = leaseContract;
    }

//    public void LeaseContract(String vin , String customerName ) {
//        try{
//            //Display all Vehicles
//            vehicleDao.getAllVehicles();
//
//            Vehicle foundVehicle = null;
//
//            //loop through inventory to find VIN
//            for (Vehicle v : vehicleDao.getAllVehicles()){
//
//                if (v.getVIN() == vin) {
//                    foundVehicle = v;
//                    break;
//                }
//            }
//
//            if (foundVehicle != null) {
//
//                String vehicleVin = foundVehicle.getVIN();
//                String contractType = "LEASE";
//                String customerName = ""
//
//                try(Connection connection = dataSource.getConnection();
//                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO salescontract (contract_id, VIN , contractType , salesTax , recordingFee , processingFee , financed" +
//                            " VALUES( ? , ? , ? , ? , ? , ? , ? ) ");
//                ){
//
//                    preparedStatement.setString(1, vehicleVin);
//                    preparedStatement.setString(2, contractType);
//                    preparedStatement.setDouble(3, salesTax);
//                    preparedStatement.setDouble(4, recordingFee);
//                    preparedStatement.setDouble(5, processingFee);
//                    preparedStatement.setInt(6, isFinanced);
//
//                    //execute the query
//                    int rows  = preparedStatement.executeUpdate();
//
//                    System.out.println(" ✓ Sales Contract saved!");
//
//                    //confirm update
//                    System.out.printf("Rows updated %d\n ",rows);
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("There was a SQL error: " + e.getMessage());
//        }
//
//    }

}
