package springcore.tasks.tasktwo.secondTask;

public class Car implements Vehicle {

    private DatabaseOperation databaseOperation;
    Car(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }
    @Override
    public String getVehicleName() {
        return "Car";
    }

    @Override
    public void insertVehicleData() {
        databaseOperation.openConnection();
        databaseOperation.insertData(getVehicleName());
        databaseOperation.closeConnection();
    }
}
