package com.eliten.eksamen.media;

import javax.swing.*;
import java.util.ArrayList;

public class Media {

    private String name;
    private MediaType type;
    private ArrayList<Genre> genres;

    private int releaseYear;
    private double score;

    private JLabel image;

    public Media(String name, MediaType type, int releaseYear, double score) {

        this.name = name;
        this.type = type;
        this.releaseYear = releaseYear;
        this.score = score;

        genres = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public MediaType getType() {
        return type;
    }

    public boolean isMovie() {
        return type == MediaType.MOVIE;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getScore() {
        return score;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public JLabel getImage() {
        return image;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void setImage(JLabel image) {
        this.image = image;
    }
}