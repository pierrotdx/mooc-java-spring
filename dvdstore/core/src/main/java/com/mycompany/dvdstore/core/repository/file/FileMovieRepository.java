package com.mycompany.dvdstore.core.repository.file;

import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import com.mycompany.dvdstore.core.entity.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

//@Repository
public class FileMovieRepository implements MovieRepositoryInterface {
    private final static List<Movie> movies = new ArrayList<>();
    @Value("${movies.file.location}")
    private File file;

    public Movie save(Movie movie) {
        try {
            long lastId = StreamSupport.stream(findAll().spliterator(), false).map(Movie::getId).max(Long::compare).orElse(0L);
            movie.setId(lastId+1);

            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdir();
            }
            FileWriter writer = new FileWriter(this.file,true);
            String lineToAdd = String.format("%s,%s,%s,%s\n", movie.getId(), movie.getTitle(), movie.getGenre(), movie.getDescription());
            writer.write(lineToAdd);
            writer.close();
            System.out.printf("The movie %s has been added to %s.\n", movie.getTitle(), this.file.getName());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public Iterable<Movie> findAll() {

        List<Movie> movies=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] titreEtGenre = line.split("\\,");
                Long id = Long.parseLong(titreEtGenre[0]);
                movie.setId(id);
                movie.setTitle(titreEtGenre[1]);
                movie.setGenre(titreEtGenre[2]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        final Movie movie = new Movie();
        movie.setId(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {

                final String[] allProperties = line.split("\\;");
                final long nextMovieId=Long.parseLong(allProperties[0]);
                if (nextMovieId==id) {
                    movie.setTitle(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    movie.setDescription(allProperties[3]);
                    return Optional.of(movie);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A movie from the file does not have a proper id");
            e.printStackTrace();
        }
        movie.setTitle("UNKNOWN");
        movie.setGenre("UNKNOWN");
        movie.setDescription("UNKNOWN");
        return Optional.of(movie);
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {
            throw new UnsupportedOperationException();
    }


    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

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
