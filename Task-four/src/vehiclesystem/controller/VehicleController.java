package vehiclesystem.controller;

import vehiclesystem.model.Vehicle;

import java.sql.SQLException;

public interface VehicleController {
    void addVehicle(Vehicle vehicle) throws SQLException;
    void searchVehicleById(Vehicle vehicle) throws SQLException;
    void searchVehicleByModelName(Vehicle vehicle) throws SQLException;
    void deleteVehicle(Vehicle vehicle) throws SQLException;
    void updateVehicle(Vehicle vehicle) throws SQLException;
    void findAll() throws SQLException;
    void findByType(Vehicle vehicle) throws SQLException;
}
