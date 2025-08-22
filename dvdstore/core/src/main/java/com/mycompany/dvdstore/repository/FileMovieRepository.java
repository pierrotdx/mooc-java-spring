package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMovieRepository implements MovieRepositoryInterface {
    private final static List<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        FileWriter writer;
        try {
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdir();
            }
            writer = new FileWriter("C:\\temp\\movies.txt",true);
            String lineToAdd = String.format("%s;%s\n", movie.getTitle(), movie.getGenre());
            writer.write(lineToAdd);
            writer.close();
            System.out.printf("The movie %s has been added to movies.txt.\n", movie.getTitle());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
