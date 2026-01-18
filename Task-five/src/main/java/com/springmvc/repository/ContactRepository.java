package com.springmvc.repository;

import com.springmvc.DAO.DatabaseOperations;
import com.springmvc.models.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class ContactRepository {
    private final DatabaseOperations databaseOperations;


    public void addUser(Client client) throws SQLException {
        String insertQuery = String.format("INSERT INTO user (id, firstName, lastName, email, dob, city) VALUES (%d, '%s', '%s','%s','%s','%s')", client.getId(), client.getFirstName(),client.getLastName(),client.getEmail(),client.getDob(),client.getCity());
        databaseOperations.executeSingleQuery(insertQuery);
    }
}
