package vehiclesystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import vehiclesystem.model.*;

@Configuration
@ComponentScan("vehiclesystem")
@PropertySource("classpath:application.properties")
public class BeansConfiguration {

    @Bean
    public Vehicle toyotaCorolla() {
        Car car = new Car();
        car.setId(1);
        car.setModel("Toyota Corolla");
        car.setVehicleType(VehicleType.CAR);
        return car;
    }

    @Bean
    public Vehicle F16() {
        Plane plane = new Plane();
        plane.setId(2);
        plane.setModel("F16");
        plane.setVehicleType(VehicleType.PLANE);
        return plane;
    }

    @Bean
    public Vehicle BMX() {
        Bike bike = new Bike();
        bike.setId(3);
        bike.setModel("BMX");
        bike.setVehicleType(VehicleType.BIKE);
        return bike;
    }


}
