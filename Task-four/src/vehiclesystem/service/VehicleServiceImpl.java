package vehiclesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vehiclesystem.model.Vehicle;
import vehiclesystem.repo.VehicleRepository;

import java.sql.SQLException;

@Component
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository){

        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws SQLException {
        vehicleRepository.createVehicle(vehicle);
    }

    @Override
    public void searchVehicleById(Vehicle vehicle) throws SQLException {
        vehicleRepository.findById(vehicle.getId());
    }

    @Override
    public void searchVehicleByModelName(Vehicle vehicle) throws SQLException {
        vehicleRepository.findByModel(vehicle.getModel());
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) throws SQLException {
        vehicleRepository.deleteVehicle(vehicle.getId());
    }

    @Override
    public void updateVehicle(Vehicle vehicle) throws SQLException {
        vehicleRepository.updateVehicle(vehicle);
    }

    @Override
    public void findAll() throws SQLException {
        vehicleRepository.findAll();
    }

    @Override
    public void findByType(Vehicle vehicle) throws SQLException {
        vehicleRepository.findByType(vehicle.getVehicleType());
    }
}
