package vehiclesystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@ToString
@Setter
@Component
@Scope("prototype")
public class Bike implements Vehicle{
    private int id;
    private String model;
    private VehicleType vehicleType;

    @Override
    public VehicleType getVehicleType() {
        return vehicleType.BIKE;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getModel() {
        return model;
    }
}
