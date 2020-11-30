package com.eliten.eksamen.managers;

import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.media.Series;

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

    public ArrayList<Media> getMovies() {
        ArrayList<Media> movies = new ArrayList<>();

        for (Media media : getMedias()) {
            if (media.isMovie()) {
                movies.add(media);
            }
        }

        return movies;
    }

    public ArrayList<Series> getSeries() {
        ArrayList<Series> series = new ArrayList<>();

        for (Media media : getMedias()) {
            if (!media.isMovie()) {
                series.add((Series) media);
            }
        }

        return series;
    }

    public ArrayList<Media> getMediaByGenre(Genre genre) {
        ArrayList<Media> medias = new ArrayList<>();

        for (Media media : getMedias()) {
            if (media.getGenres().contains(genre)) {
                medias.add(media);
            }
        }

        return medias;
    }
}
