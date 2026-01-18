package com.springmvc.controller;

import com.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showFormPage(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping("/result")
    public String showResult(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        return "resultPage";

    }
}
