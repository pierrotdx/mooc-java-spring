package com.mycompany.dvdstore.core.repository;

import jakarta.persistence.metamodel.EntityType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import com.mycompany.dvdstore.core.entity.Movie;

import java.util.Optional;

public interface MovieRepositoryInterface extends CrudRepository<Movie, Long> {
    @EntityGraph(value = "movie.actor-and-reviews", type = EntityGraph.EntityGraphType.FETCH)
    @Override
    Optional<Movie> findById(Long aLong);
    //    Movie add(Movie movie);
//    List<Movie> list();
//    Movie getById(long id);
}
