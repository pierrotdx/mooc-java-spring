package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;

public class MovieService {
    private final MovieRepository movieRepository = new MovieRepository();

    public void registerMovie(Movie movie) {
        this.movieRepository.add(movie);
    }
}
