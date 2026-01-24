package com.springmvc.repository;

import com.springmvc.DAO.DatabaseOperations;
import com.springmvc.model.User;
import com.springmvc.models.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class ContactRepository {
    private final DatabaseOperations databaseOperations;


    public void addUser(User client) throws SQLException {
        String insertQuery = String.format("INSERT INTO user (id, username, email) VALUES (%d, '%s', '%s')", new Random().nextInt(), client.getUsername(),client.getEmail());
        databaseOperations.executeSingleQuery(insertQuery);
    }
}
