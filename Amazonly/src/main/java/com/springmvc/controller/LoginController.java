package com.springmvc.controller;

import com.springmvc.services.LoginService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@NoArgsConstructor
@Controller
public class LoginController {

    @Autowired
    private  LoginService loginService;



    @RequestMapping(value =  "/", method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value =  "/login", method = RequestMethod.POST)
    public String userLoginValidation(Model model, @RequestParam String username, @RequestParam String password){
        if(!loginService.validateUser(username,password)) {
            model.addAttribute("errorMessage","Wrong Credentials");
            return "login";
        }
        return "redirect:/products/view";
    }


}
