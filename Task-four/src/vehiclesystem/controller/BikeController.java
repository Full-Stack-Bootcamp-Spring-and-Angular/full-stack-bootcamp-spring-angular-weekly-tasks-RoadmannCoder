package vehiclesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vehiclesystem.model.Vehicle;
import vehiclesystem.service.VehicleService;

import java.sql.SQLException;

@Component
public class BikeController implements VehicleController{

    @Autowired
    private VehicleService vehicleService;

    @Override
    public void addVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.addVehicle(vehicle);
    }

    @Override
    public void searchVehicleById(Vehicle vehicle) throws SQLException {
        vehicleService.searchVehicleById(vehicle);
    }

    @Override
    public void searchVehicleByModelName(Vehicle vehicle) throws SQLException {
        vehicleService.searchVehicleByModelName(vehicle);
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.deleteVehicle(vehicle);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.updateVehicle(vehicle);
    }

    @Override
    public void findAll() throws SQLException {
        vehicleService.findAll();
    }

    @Override
    public void findByType(Vehicle vehicle) throws SQLException {
        vehicleService.findByType(vehicle);
    }
}
