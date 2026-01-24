package com.springmvc.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class User {

    private String username;
    private String password;
    private String country;
    private String programmingLanguage;
    private List<String> operatingSystem;

}
