package com.mycompany.dvdstore.core.repository;

import org.springframework.data.repository.CrudRepository;
import com.mycompany.dvdstore.core.entity.Movie;

public interface MovieRepositoryInterface extends CrudRepository<Movie, Long> {
//    Movie add(Movie movie);
//    List<Movie> list();
//    Movie getById(long id);
}
