package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class DefaultMovieService implements MovieServiceInterface {
    public DefaultMovieService(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepositoryInterface movieRepository;

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public Movie registerMovie(Movie movie) {
        this.movieRepository.save(movie);
        return movie;
    }

    @Override
    public Iterable<Movie> getMovieList() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(long id) {
        return this.movieRepository.findById(id).orElseThrow();
    }
}
