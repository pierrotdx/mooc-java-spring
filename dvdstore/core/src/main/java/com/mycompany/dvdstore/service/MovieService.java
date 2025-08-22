package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.GoLiveMovieRepository;

public class MovieService {
    private final GoLiveMovieRepository movieRepository = new GoLiveMovieRepository();

    public void registerMovie(Movie movie) {
        this.movieRepository.add(movie);
    }
}
