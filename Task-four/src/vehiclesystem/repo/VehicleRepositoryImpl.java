package vehiclesystem.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vehiclesystem.dao.DatabaseOperations;
import vehiclesystem.model.Vehicle;
import vehiclesystem.model.VehicleType;

import java.sql.SQLException;
import java.util.List;

@Component
public class VehicleRepositoryImpl implements VehicleRepository{

    private final DatabaseOperations databaseOperations;

    @Autowired
    public VehicleRepositoryImpl(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void createVehicle(Vehicle vehicle) throws SQLException {
        String insertQuery = String.format("INSERT INTO vehicle (id, model, type) VALUES (%d, '%s', '%s')", vehicle.getId(), vehicle.getModel(), vehicle.getVehicleType());
        databaseOperations.executeSingleQuery(insertQuery);
    }

    @Override
    public void findById(int id) throws SQLException {
        String selectQuery = String.format("SELECT * FROM vehicle WHERE id = %d", id);
        databaseOperations.getRecords(selectQuery);
    }

    @Override
    public void findByModel(String model) throws SQLException {
        String selectQuery = String.format("SELECT * FROM vehicle WHERE model = '%s'", model);
        databaseOperations.getRecords(selectQuery);
    }

    @Override
    public void deleteVehicle(int id) throws SQLException {
        String deleteQuery = String.format("DELETE FROM vehicle WHERE id = %d", id);
        databaseOperations.executeSingleQuery(deleteQuery);

    }

    @Override
    public void updateVehicle(Vehicle vehicle) throws SQLException {
        String updateQuery = String.format("UPDATE vehicle SET model = '%s', type = '%s' WHERE id = %d", vehicle.getModel(), vehicle.getVehicleType(), vehicle.getId());
        databaseOperations.executeSingleQuery(updateQuery);
    }

    @Override
    public void findAll() throws SQLException {
        String selectQuery = String.format("SELECT * FROM vehicle");
        databaseOperations.getRecords(selectQuery);
    }

    @Override
    public void findByType(VehicleType type) throws SQLException {
       String selectQuery = String.format("SELECT * FROM VEHICLE WHERE TYPE = '%s'",type.name());
       databaseOperations.getRecords(selectQuery);
    }


}
