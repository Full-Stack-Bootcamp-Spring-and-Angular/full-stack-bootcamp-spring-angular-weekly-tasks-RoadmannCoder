package springcore.tasks.tasktwo.secondTask;

public class Plane implements Vehicle {

    private DatabaseOperation databaseOperation;
    @Override
    public String getVehicleName() {
        return "Plane";
    }

    @Override
    public void insertVehicleData() {
        databaseOperation.openConnection();
        databaseOperation.insertData(getVehicleName());
        databaseOperation.closeConnection();
    }

    public void setDatabaseOperation(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }
}
