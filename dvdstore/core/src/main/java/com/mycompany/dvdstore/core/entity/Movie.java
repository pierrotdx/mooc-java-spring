package com.mycompany.dvdstore.core.entity;

import org.springframework.data.annotation.Id;

public class Movie {
    private String title;
    private String genre;
    @Id
    private Long id;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie() {}

    public Movie(Long id, String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.id = id;
    }

    public Movie(Long id, String title, String genre, String description) {
        this.title = title;
        this.genre = genre;
        this.id = id;
        this.description = description;
    }
}
