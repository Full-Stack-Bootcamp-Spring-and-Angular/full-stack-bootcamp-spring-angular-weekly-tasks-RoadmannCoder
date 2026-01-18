package com.springmvc.service;

import com.springmvc.models.Client;
import com.springmvc.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@RequiredArgsConstructor
@Component
public class ContactService {
    private final ContactRepository contactRepository;

    public void addUser(Client client) throws SQLException {
        contactRepository.addUser(client);
    }
}
