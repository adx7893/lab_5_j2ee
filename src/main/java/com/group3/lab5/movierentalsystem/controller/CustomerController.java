package com.group3.lab5.movierentalsystem.controller;

import com.group3.lab5.movierentalsystem.entities.Customer;
import com.group3.lab5.movierentalsystem.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register-customer";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute Customer customer) {
        customerService.registerCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}")
    public String viewCustomerDetails(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customers";
    }
}
