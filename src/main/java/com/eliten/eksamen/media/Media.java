package com.eliten.eksamen.media;

import com.eliten.eksamen.Eliten;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

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

    /**
     * Retrieves whether or not the media object is meant for kids
     * @return true if it is for kids
     */
    public boolean isForKids(){
        return isForKids;
    }

    /**
     * Retrieve the name of the object.
     * @return the name of the object
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Retrieve the {@link MediaType} of the {@link Media} object.
     * @return the type of the object.
     */
    @NotNull
    public MediaType getType() {
        return type;
    }

    /**
     * Retrieve the release year of the {@link Media} object.
     * @return the release year
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Retrieve the score of the {@link Media} object.
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * Retrieve an {@link ArrayList<Genre>} of all the objects genres. This can
     * be empty if the object has no genres.
     * @return all the genres
     */
    @NotNull
    public ArrayList<Genre> getGenres() {
        return genres;
    }

    /**
     * Retrieve a generated joined {@link String} of all the {@link Genre} the object has.
     * This {@link String} is properly formatted, as well.
     *
     * This {@link String} can be empty if the {@link Media} object has no genres.
     * @return a nicely formatted {@link String} for all the genres.
     */
    @NotNull
    public String getGenresString() {

        String genres = "";

        for(Genre genre : getGenres()) {
            genres += genre.getName() + ", ";
        }

        return StringUtils.strip(genres, ", ");
    }

    /**
     * Retrieve the {@link ImageIcon} for the {@link Media} object
     * @return the image of the {@link Media} object
     */
    @NotNull
    public ImageIcon getImage() {
        return image;
    }

    /**
     * Adds an genre to the {@link Media} object
     * @param genre the genre to add
     */
    public void addGenre(@NotNull Genre genre) {
        genres.add(genre);
    }

    /**
     * Sets the image of the {@link Media} object
     * @param image the image to set it to
     */
    public void setImage(@NotNull ImageIcon image) {
        this.image = image;
    }

    /**
     * Plays the {@link Media}'s video
     */
    public void watch() {
        try {
            Desktop.getDesktop().open(Eliten.fileManager().getFile("video.mp4"));
        } catch (IOException e) {
            Eliten.getLogger().warning("Cannot open media file for media: " + getName());
        }
    }

    /**
     * Set whether or not the {@link Media} object is okay for kids to watch
     * @param kidsFriendly true if it's okay for them to watch
     */
    public void setIsForKids(boolean kidsFriendly) {
        isForKids = kidsFriendly;
    }
}
