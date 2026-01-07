package vehiclesystem.dao;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component
public class DatabaseOperations {
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

    private Connection connection;


    private void initDatabase() throws SQLException {
        System.out.println(String.format("Initializing Database: %s", url));
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS VEHICLES");
        statement.executeUpdate("USE VEHICLES");
        System.out.println(String.format("Database Created Successfully"));
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS vehicle (id INTEGER, model VARCHAR(255), type VARCHAR(255), PRIMARY KEY (id))");
        statement.close();
        System.out.println(String.format("Table Initialized Successfully"));

    }

    @PostConstruct
    public Connection openConnection() throws SQLException {
        System.out.println(String.format("Opening Connection to Database: %s", url));
        if(connection == null) {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(String.format("Connection to Database: %s", url));
            initDatabase();
        }
        return connection;
    }

    @PreDestroy
    public void closeConnection() throws SQLException {
        connection.close();
        System.out.println(String.format("Closing Connection to Database: %s", url));
    }

    public void executeSingleQuery(String query) throws SQLException {
        System.out.println(String.format("Executing This Query: %s", query));
        Statement statement = connection.createStatement();
        statement.execute(query);
        statement.close();
        System.out.println(String.format("Query Executed Successfully"));
    }
    public void getRecords(String query) throws SQLException {
        System.out.println(String.format("Executing This Query: %s", query));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
                System.out.println(String.format("Record: VehicleID: %d, VehicleModel: %s, VehicleType: %s", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }
        resultSet.close();
        statement.close();
    }

}
