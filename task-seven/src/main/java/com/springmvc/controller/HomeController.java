package com.springmvc.controller;

import com.springmvc.model.User;
import javax.validation.Valid;

import com.springmvc.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ContactService contactService;
    @RequestMapping("/")
    public String showFormPage(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping("/result")
    public String showResult(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) throws SQLException {
        if(bindingResult.hasErrors())
            return "index";

        model.addAttribute("user", user);
        contactService.addUser(user);
        return "resultPage";

    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
