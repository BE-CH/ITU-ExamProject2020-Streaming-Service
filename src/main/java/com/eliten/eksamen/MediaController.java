package com.eliten.eksamen;

import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.media.Series;

import java.util.ArrayList;

public class MediaController {

    private ArrayList<Media> medias;

    public MediaController() {
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
            if (media.getType() == MediaType.MOVIE) {
                movies.add(media);
            }
        }

        return movies;
    }

    public ArrayList<Series> getSeries() {
        ArrayList<Series> series = new ArrayList<>();

        for (Media media : getMedias()) {
            if (media.getType() == MediaType.SERIES) {
                series.add((Series) media);
            }
        }

        return series;
    }
}
