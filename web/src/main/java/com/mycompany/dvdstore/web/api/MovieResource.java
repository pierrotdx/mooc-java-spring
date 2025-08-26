package com.mycompany.dvdstore.web.api;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movie")
public class MovieResource {
    public MovieResource(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private final MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @GetMapping("/{id}")
    Movie get(@PathVariable("id") long movieId) {
        return this.movieService.getMovieById(movieId);
    }

    @PostMapping("")
    public String add(@RequestBody Movie movie) {
        this.movieService.registerMovie(movie);
        return "movie-added";
    }

    @GetMapping
    public Iterable<Movie> list() {
        return this.movieService.getMovieList();
    }
}
