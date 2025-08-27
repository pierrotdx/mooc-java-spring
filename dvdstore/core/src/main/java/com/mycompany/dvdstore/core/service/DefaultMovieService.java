package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

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
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isEmpty()){
            throw new NoSuchElementException();
        }
        Movie movie = optionalMovie.get();
        //Initialize proxys
        movie.getMainActor().getFirstName();
        movie.getReviews().forEach(review -> {
            review.getMark();
            review.setMovie(null);
        });
        //
        return movie;
    }
}
