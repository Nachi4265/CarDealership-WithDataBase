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



}
