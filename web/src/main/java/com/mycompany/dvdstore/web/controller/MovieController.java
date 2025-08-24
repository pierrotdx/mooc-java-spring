package com.mycompany.dvdstore.web.controller;


import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController {
    public MovieController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private final MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void addMovieConsole() {
        System.out.println("What is the title of the movie?");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        System.out.println("What is the genre of the movie?");
        String genre = scanner.nextLine();

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);

        this.movieService.registerMovie(movie);
    }
