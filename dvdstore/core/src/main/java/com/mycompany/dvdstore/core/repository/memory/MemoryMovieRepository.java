package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Movie> list() {
        return movies;
    }

    public Optional<Movie> findById(long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst();
    }

    @Override
    public <S extends Movie> S save(S entity) {
        throw new UnsupportedOperationException();    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();    }

    @Override
    public Iterable<Movie> findAll() {
        throw new UnsupportedOperationException();    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }
}
