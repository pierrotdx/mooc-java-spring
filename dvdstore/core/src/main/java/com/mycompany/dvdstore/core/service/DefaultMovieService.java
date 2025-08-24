package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface {
    public DefaultMovieService(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepositoryInterface movieRepository;

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void registerMovie(Movie movie) {
        this.movieRepository.add(movie);
    }

    @Override
    public List<Movie> getMovieList() {
        return this.movieRepository.list();
    }

    @Override
    public Movie getMovieById(long id) {
        return this.movieRepository.getById(id);
    }
}
