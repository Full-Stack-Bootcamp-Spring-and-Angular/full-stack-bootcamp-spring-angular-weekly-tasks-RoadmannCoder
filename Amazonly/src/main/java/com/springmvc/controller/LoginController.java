package com.springmvc.controller;

import com.springmvc.config.enums.Constants;
import com.sun.org.apache.bcel.internal.Const;
import jdk.javadoc.internal.doclets.toolkit.builders.ConstantsSummaryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.springmvc.config.enums.Constants.ROOT_CONTEXT;

@Controller
public class LoginController {


    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }
}
