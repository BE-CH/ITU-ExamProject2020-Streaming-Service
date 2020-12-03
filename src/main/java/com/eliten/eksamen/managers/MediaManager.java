package com.eliten.eksamen.managers;

import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;

import java.util.ArrayList;

public class MediaManager {

    private ArrayList<Media> medias;

    public MediaManager() {
        medias = new ArrayList<>();
    }

    public void addMedia(Media media) {
        medias.add(media);
    }

    public ArrayList<Media> getMedias() {
        return medias;
    }

    public Media getMediaByName(String name) {
        for (Media media : medias) {
            if (media.getName().equalsIgnoreCase(name)) {
                return media;
            }
        }

        return null;
    }

    public ArrayList<Media> getMediasByType(MediaType type) {
        ArrayList<Media> movies = new ArrayList<>();

        for (Media media : getMedias()) {
            if (media.getType() == type) {
                movies.add(media);
            }
        }

        return movies;
    }

    public ArrayList<Media> getMediasByGenre(Genre genre) {
        ArrayList<Media> medias = new ArrayList<>();

        for (Media media : getMedias()) {
            if (media.getGenres().contains(genre)) {
                medias.add(media);
            }
        }

        return medias;
    }

    public ArrayList<Media> getMediasFuzzy(String search) {
        ArrayList<Media> medias = new ArrayList<>();

        for (Media media : getMedias()) {
            if (media.getName().toLowerCase().contains(search.toLowerCase())) {
                medias.add(media);
            }
        }

        return medias;
    }
}
