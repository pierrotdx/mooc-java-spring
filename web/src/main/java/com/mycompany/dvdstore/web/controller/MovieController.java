package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/movie")
public class MovieController {
    public MovieController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private final MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @GetMapping("/{id}")
    String displayMovieCard(@PathVariable("id") long movieId, Model model) {
        Movie movie = this.movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movie-details";
    }

    @PostMapping("")
    public String addMovie(@ModelAttribute Movie movie) {
        this.movieService.registerMovie(movie);
        return "movie-added";
    }
}
