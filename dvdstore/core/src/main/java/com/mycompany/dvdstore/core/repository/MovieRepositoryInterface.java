package com.mycompany.dvdstore.core.repository;

import com.mycompany.dvdstore.core.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepositoryInterface extends CrudRepository<Movie, Long> {
//    Movie add(Movie movie);
//    List<Movie> list();
//    Movie getById(long id);
}
