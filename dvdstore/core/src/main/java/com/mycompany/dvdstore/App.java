package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;


@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new SpringApplication(App.class).run();
        MovieController movieController = context.getBean(MovieController.class);;
        movieController.addMovieConsole();
    }
}
