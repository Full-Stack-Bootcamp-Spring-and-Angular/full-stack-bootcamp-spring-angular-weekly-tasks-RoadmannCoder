import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vehiclesystem.config.BeansConfiguration;
import vehiclesystem.controller.BikeController;
import vehiclesystem.controller.CarController;
import vehiclesystem.controller.PlaneController;
import vehiclesystem.controller.VehicleController;
import vehiclesystem.model.Vehicle;
import vehiclesystem.model.VehicleType;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);

        Vehicle toyotaCorolla = context.getBean("toyotaCorolla", Vehicle.class);
        Vehicle F16 = context.getBean("F16", Vehicle.class);
        Vehicle BMX = context.getBean("BMX", Vehicle.class);
        VehicleController bikeController = context.getBean("bikeController", BikeController.class);
        bikeController.addVehicle(BMX);
        bikeController.findAll();
        bikeController.findByType(BMX);
        bikeController.searchVehicleByModelName(BMX);
        bikeController.searchVehicleById(BMX);

        VehicleController carController = context.getBean("carController", CarController.class);
        carController.addVehicle(toyotaCorolla);
        carController.findAll();
        carController.findByType(toyotaCorolla);
        carController.searchVehicleByModelName(toyotaCorolla);
        carController.searchVehicleById(toyotaCorolla);

        VehicleController planeController = context.getBean("planeController", PlaneController.class);
        planeController.addVehicle(F16);
        planeController.findAll();
        planeController.findByType(F16);
        planeController.searchVehicleByModelName(F16);
        planeController.searchVehicleById(F16);



    }
}