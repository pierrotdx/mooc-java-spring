package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    private static long id = 0l;
    private final static List<Movie> movies = new ArrayList<>();


    public Movie add(Movie movie) {
        movie.setId(++id);
        movies.add(movie);
        System.out.printf("The movie %s has been added.\n", movie.getTitle());
        return movie;
    }

    @Override
    public List<Movie> list() {
        return movies;
    }

    @Override
    public Movie getById(long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst().get();
    }
}
