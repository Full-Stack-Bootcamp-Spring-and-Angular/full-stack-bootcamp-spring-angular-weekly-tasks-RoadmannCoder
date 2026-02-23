package com.springmvc.controller;

import com.springmvc.models.ProductDomain;
import com.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products/view", method = RequestMethod.GET)
    public String showViewProducts(Model model){
        model.addAttribute("productsList",productService.getAllProduct());
        return "viewProduct";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String showProductAddition(){
        return "addProduct";
    }

    @RequestMapping(value = "/products/save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute ProductDomain productDomain){
        productService.addProduct(productDomain);
        return "redirect:/product/view";
    }

}
