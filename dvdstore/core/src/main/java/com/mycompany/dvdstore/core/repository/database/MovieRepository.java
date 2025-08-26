//package com.mycompany.dvdstore.core.repository.database;
//
//import com.mycompany.dvdstore.core.entity.Movie;
//import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.util.List;
//
//@Repository
//public class MovieRepository implements MovieRepositoryInterface {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Movie add(Movie movie) {
//        KeyHolder kh = new GeneratedKeyHolder();
//
//        this.jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement("INSERT INTO MOVIE (TITLE, GENRE, DESCRIPTION) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, movie.getTitle());
//            ps.setString(2, movie.getGenre());
//            ps.setString(3, movie.getDescription());
//            return ps;
//        }, kh);
//        Long id = kh.getKey().longValue();
//        movie.setId(id);
//        return movie;
//    }
//
//    @Override
//    public List<Movie> list() {
//        return this.jdbcTemplate.query("SELECT ID,TITLE, GENRE FROM MOVIE", (rs, rowNum) -> {
//            Long id = rs.getLong("ID");
//            String title = rs.getString("TITLE");
//            String genre = rs.getString("GENRE");
//            return new Movie(id, title, genre);
//        });
//    }
//
//    @Override
//    public Movie getById(long id) {
//        return this.jdbcTemplate.queryForObject("SELECT ID, TITLE, GENRE, DESCRIPTION FROM MOVIE WHERE ID=?", new Object[]{id},(rs, rowNum) -> {
//            String title = rs.getString("TITLE");
//            String genre = rs.getString("GENRE");
//            String description = rs.getString("DESCRIPTION");
//            return new Movie(id, title, genre,  description);
//        });
//    }
//}
