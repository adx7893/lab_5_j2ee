package com.group3.lab5.movierentalsystem.repositories;


import com.group3.lab5.movierentalsystem.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByCustomerId(Long customerId);
    List<Rental> findByReturnDateIsNull();
}
