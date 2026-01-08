package vehiclesystem.repo;


import vehiclesystem.model.Vehicle;
import vehiclesystem.model.VehicleType;

import java.sql.SQLException;
import java.util.List;

public interface VehicleRepository {
    void createVehicle(Vehicle vehicle) throws SQLException;
    void findById(int id) throws SQLException;
    void findByModel(String model) throws SQLException;
    void deleteVehicle(int id) throws SQLException;
    void updateVehicle(Vehicle vehicle) throws SQLException;
    void findAll() throws SQLException;
    void findByType(VehicleType type) throws SQLException;



}
