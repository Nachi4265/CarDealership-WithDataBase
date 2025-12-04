package pluralsight.persistance;

import org.apache.commons.dbcp2.BasicDataSource;
import pluralsight.models.SalesContract;
import pluralsight.models.Vehicle;
import pluralsight.userInterface.InputCollector;
import pluralsight.userInterface.LoanCalculator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesContractDao {

    
    private BasicDataSource dataSource;
    private VehicleDao vehicleDao;
    private SalesContract salesContract;

    public SalesContractDao(BasicDataSource dataSource, VehicleDao vehicleDao) {
        this.dataSource =  dataSource;
        this.vehicleDao = vehicleDao;
        
    }

    public void SalesContract(String vin) throws SQLException {

        try{

            Vehicle foundVehicle = null;

            foundVehicle = vehicleDao.getVehicleByVin(vin);

            if (foundVehicle != null) {

            String vehicleVin = foundVehicle.getVIN();
            String contractType = "SALE";
            double salesTax = salesContract.getSalesTax();
            double recordingFee = salesContract.getRecordingFee();
            double processingFee = salesContract.getProcessingFee();
            int isFinanced = InputCollector.promptForInt("Would you like to finance (1 = yes / 0 = no ");

                try(Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO salescontract (contract_id, VIN , contractType , salesTax , recordingFee , processingFee , financed" +
                            " VALUES( ? , ? , ? , ? , ? , ? , ? ) ");
                ){

                    preparedStatement.setString(1, vehicleVin);
                    preparedStatement.setString(2, contractType);
                    preparedStatement.setDouble(3, salesTax);
                    preparedStatement.setDouble(4, recordingFee);
                    preparedStatement.setDouble(5, processingFee);
                    preparedStatement.setInt(6, isFinanced);

                    //execute the query
                    int rows  = preparedStatement.executeUpdate();

                    System.out.println(" ✓ Sales Contract saved!");

                    //confirm update
                    System.out.printf("Rows updated %d\n ",rows);
                }
            }
        } catch (SQLException e) {
            System.out.println("There was a SQL error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
