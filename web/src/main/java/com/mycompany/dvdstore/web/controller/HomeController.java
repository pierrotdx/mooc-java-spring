package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    public HomeController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private final MovieServiceInterface movieService;

    @GetMapping("/dvdstore-home")
    public void displayHome() {}

    @GetMapping("/add-movie-form")
    public void displayMovieForm(@ModelAttribute MovieForm movie) {}
}
