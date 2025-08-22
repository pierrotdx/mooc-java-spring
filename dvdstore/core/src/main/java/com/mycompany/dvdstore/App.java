package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.repository.FileMovieRepository;
import com.mycompany.dvdstore.service.DefaultMovieService;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        MovieController movieController = new MovieController();

        DefaultMovieService movieService = new DefaultMovieService();
        movieController.setMovieService(movieService);

        FileMovieRepository movieRepository = new FileMovieRepository();
        movieService.setMovieRepository(movieRepository);

        movieController.addMovieConsole();
    }
}
