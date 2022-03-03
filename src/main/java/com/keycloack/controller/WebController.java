package com.keycloack.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.keycloack.Customer;

@Controller
public class WebController {

	@GetMapping(path = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }
    
    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
    	
    	List<Customer> customers = new ArrayList<>();
    	Customer customer1 = new Customer();
    	customer1.setId("10001");
        customer1.setAddress("302 Demo Address");
        customer1.setName("Demo Industries");
        
        customers.add(customer1);
        
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        
        return "customers";
    }

}
