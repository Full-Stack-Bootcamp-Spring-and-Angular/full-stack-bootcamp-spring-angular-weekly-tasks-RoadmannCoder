package vehiclesystem.service;

import vehiclesystem.model.Vehicle;
import vehiclesystem.model.VehicleType;

import java.sql.SQLException;

public interface VehicleService {
    void addVehicle(Vehicle vehicle) throws SQLException;
    void searchVehicleById(Vehicle vehicle) throws SQLException;
    void searchVehicleByModelName(Vehicle vehicle) throws SQLException;
    void deleteVehicle(Vehicle vehicle) throws SQLException;
    void updateVehicle(Vehicle vehicle) throws SQLException;
    void findAll() throws SQLException;
    void findByType(Vehicle vehicle) throws SQLException;
}
