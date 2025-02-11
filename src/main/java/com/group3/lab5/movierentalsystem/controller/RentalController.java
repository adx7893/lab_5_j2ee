package com.group3.lab5.movierentalsystem.controller;

import com.group3.lab5.movierentalsystem.entities.Rental;
import com.group3.lab5.movierentalsystem.servicesCustomerService;
import com.group3.lab5.movierentalsystem.services.MovieService;
import com.group3.lab5.movierentalsystem.services.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;
    private final CustomerService customerService;
    private final MovieService movieService;

    public RentalController(RentalService rentalService, CustomerService customerService, MovieService movieService) {
        this.rentalService = rentalService;
        this.customerService = customerService;
        this.movieService = movieService;
    }

    @GetMapping("/rent")
    public String showRentalForm(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("movies", movieService.getAvailableMovies());
        model.addAttribute("rental", new Rental());
        return "rent-movie";
    }

    @PostMapping("/rent")
    public String rentMovie(@ModelAttribute Rental rental) {
        rentalService.rentMovie(rental.getCustomer().getId(), rental.getMovie().getId());
        return "redirect:/rentals";
    }

    @GetMapping
    public String listRentals(Model model) {
        model.addAttribute("rentals", rentalService.getAllRentals());
        return "rentals";
    }

    @PostMapping("/return/{rentalId}")
    public String returnMovie(@PathVariable Long rentalId) {
        rentalService.returnMovie(rentalId);
        return "redirect:/rentals";
    }
}
