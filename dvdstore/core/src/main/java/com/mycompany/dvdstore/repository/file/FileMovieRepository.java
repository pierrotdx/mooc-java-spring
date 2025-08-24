package com.mycompany.dvdstore.repository.file;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileMovieRepository implements MovieRepositoryInterface {
    private final static List<Movie> movies = new ArrayList<>();
    @Value("${movies.file.location}")
    private File file;

    public void add(Movie movie) {
        try {
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdir();
            }
            FileWriter writer = new FileWriter(this.file,true);
            String lineToAdd = String.format("%s;%s\n", movie.getTitle(), movie.getGenre());
            writer.write(lineToAdd);
            writer.close();
            System.out.printf("The movie %s has been added to %s.\n", movie.getTitle(), this.file.getName());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public List<Movie> list() {

        List<Movie> movies=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] titreEtGenre = line.split("\\,");
                movie.setTitle(titreEtGenre[0]);
                movie.setGenre(titreEtGenre[1]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
