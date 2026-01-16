package com.springmvc.controller;


import com.springmvc.models.Client;
import com.springmvc.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.imageio.spi.ServiceRegistry;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final ContactService contactService;
    private Random rnd = new Random();

    @RequestMapping("/")
    public String showHomePage(){
        return "index";
    }

    @RequestMapping("/showAgePage")
    public String showAgePage(HttpServletRequest request, Model model){
        String birthDate = request.getParameter("age");
        DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDateFormated = LocalDate.parse(birthDate,birthDateFormatter);
        LocalDate currentDate = LocalDate.now();
        Period calculateBirthDate = Period.between(birthDateFormated,currentDate);
        String yourAge = String.format("Your age is %s years and %s months and %s days",calculateBirthDate.getYears(),calculateBirthDate.getMonths(),calculateBirthDate.getDays());
        model.addAttribute("age",yourAge);
        return "showAgePage";
    }

    @RequestMapping("/showConformationPage")
    public String showConfirmationPage(HttpServletRequest request, Model model) throws SQLException {

        Client client = new Client(rnd.nextInt(),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("emailAddress"),
                LocalDate.parse(request.getParameter("dob"),DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                request.getParameter("city"));
        contactService.addUser(client);
        model.addAttribute("firstName", client.getFirstName());
        model.addAttribute("lastName", client.getLastName());
        model.addAttribute("emailAddress", client.getEmail());
        model.addAttribute("dob", client.getDob());
        model.addAttribute("city", client.getCity());
        return "showConformationPage";
    }
}
