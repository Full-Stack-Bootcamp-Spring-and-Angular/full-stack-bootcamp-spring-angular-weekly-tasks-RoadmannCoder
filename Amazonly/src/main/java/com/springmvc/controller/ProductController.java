package com.springmvc.controller;

import com.springmvc.mapper.ProductMapper;
import com.springmvc.models.ProductDomain;
import com.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
    public String showProductAddition(Model model){
        model.addAttribute("productDomain", new ProductDomain());
        return "addProduct";
    }

    @RequestMapping(value = "/products/save",method = RequestMethod.POST)
    public String saveProduct(@Valid  @ModelAttribute("productDomain") ProductDomain productDomain, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        productService.addProduct(productDomain);
        return "redirect:/products/view";
    }

    @RequestMapping(value = "/products/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") String id){
        productService.deleteProduct(Integer.parseInt(id));
        return "redirect:/products/view";
    }

    @RequestMapping(value = "/products/edit", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") String id, Model model){
        ProductDomain productDomain = ProductMapper.toDomain(productService.getProduct(Integer.parseInt(id)));
        model.addAttribute("productDomain",productDomain);
        model.addAttribute("id",id);
        return "updateProduct";
    }

    @RequestMapping(value = "/products/update",method = RequestMethod.POST)
    public String updateProduct(@RequestParam("id") String id, @Valid @ModelAttribute("productDomain") ProductDomain productDomain, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("id", id);
            return "updateProduct";
        }
        productService.updateProduct(ProductMapper.toEntity(productDomain,Integer.parseInt(id)));
        return "redirect:/products/view";
    }



}
