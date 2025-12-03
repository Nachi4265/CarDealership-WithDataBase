package pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import pluralsight.models.Dealership;
import pluralsight.persistance.DealershipDao;
import pluralsight.persistance.LeaseContractDao;
import pluralsight.persistance.SalesContractDao;
import pluralsight.persistance.VehicleDao;
import pluralsight.userInterface.DealershipConsoleApp;
import pluralsight.userInterface.UserInterface;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args)  {

        if (!ensureArgs(args)) { return; }

        try{

            BasicDataSource dataSource = getDataSource(args);
            VehicleDao vehicleDao = new VehicleDao(dataSource);
            DealershipDao dealershipDao = new DealershipDao(dataSource);
            LeaseContractDao leaseContractDao = new LeaseContractDao(dataSource);
            SalesContractDao salesContractDao = new SalesContractDao(dataSource);

            DealershipConsoleApp app = new DealershipConsoleApp(dataSource,dealershipDao,leaseContractDao,salesContractDao,vehicleDao);

            app.start();

        } catch (Exception e) {
            System.out.println("There was a SQL exception: "+ e.getMessage());
        }

    }

    private static boolean ensureArgs(String[] args){

        if(args.length < 3){
            System.out.println("You need to provide a username, password, and URL when running this command.");
            System.out.println("For example:");
            System.out.println("Main.exe myUsername myPassword myURL");
            return false;
        }
        return true;
    }

    private static BasicDataSource getDataSource(String userName , String password , String URL) throws SQLException {

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(URL);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    private static BasicDataSource getDataSource(String[]args) throws SQLException {
        String username = args[0];
        String password = args[1];
        String URL = args[2];
        return getDataSource(username,password,URL);
    }

}