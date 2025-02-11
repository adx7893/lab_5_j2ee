package com.group3.lab5.movierentalsystem.repositories;


import com.group3.lab5.movierentalsystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByGenreContainingIgnoreCase(String genre);
    List<Movie> findByAvailableCopiesGreaterThan(int availableCopies);
}
