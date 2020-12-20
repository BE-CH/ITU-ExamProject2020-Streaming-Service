package com.eliten.eksamen.media;

import com.eliten.eksamen.Eliten;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Media {

    private String name;
    private MediaType type;
    private ArrayList<Genre> genres;
    private boolean isForKids;

    private int releaseYear;
    private double score;

    private ImageIcon image;

    public Media(String name, MediaType type, int releaseYear, double score) {

        this.name = name;
        this.type = type;
        this.releaseYear = releaseYear;
        this.score = score;
        this.isForKids = false;

        genres = new ArrayList<>();
    }

    public boolean isForKids(){
        return isForKids;
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

    // TODO: Rename
    public String getGenresString() {

        String genres = "";

        for(Genre genre : getGenres()) {
            genres += genre.getName() + ", ";
        }

        return StringUtils.strip(genres, ", ");
    }

    public ImageIcon getImage() {
        return image;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void watch() {
        try {
            Desktop.getDesktop().open(Eliten.fileManager().getFile("video.mp4"));
        } catch (IOException e) {
            Eliten.getLogger().warning("Cannot open media file for media: " + getName());
        }
    }

    public void setIsForKids(boolean kidsFriendly) { isForKids = kidsFriendly; };
}
