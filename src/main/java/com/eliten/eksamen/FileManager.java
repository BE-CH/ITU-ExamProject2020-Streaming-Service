package com.eliten.eksamen;

import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.media.Series;

import java.time.Year;
import java.util.Scanner;

public class FileManager {

    public FileManager() {

        Eliten.getLogger().info("FileManager: Initialised. Data will begin: ");
        readFiles();
        Eliten.getLogger().info("FileManager: All data has been loaded");
    }

    public void readFiles() {

        Eliten.getLogger().info("Loading movies - begun");

        Scanner movies = new Scanner(getClass().getResourceAsStream("/film.txt")).useDelimiter("\\s*;\\s");

        while(movies.hasNext()) {

            String name = movies.next();
            int year = movies.nextInt();
            String genres = movies.next();
            double score = movies.nextDouble();

            Media media = new Media(name, MediaType.MOVIE, year, score);
            addGenres(media, genres);
        }

        Eliten.getLogger().info("Loading movies - complete");
        Eliten.getLogger().info("Loading series - begun");

        Scanner seriesScanner = new Scanner(getClass().getResourceAsStream("/serier.txt")).useDelimiter("\\s*;\\s");

        while (seriesScanner.hasNext()) {

            String name = seriesScanner.next();

            String release = seriesScanner.next();
            String[] releaseYears = release.split("-");

            int releaseYear = Integer.parseInt(releaseYears[0]);
            int endYear = release.contains("-") ? (releaseYears.length > 1 ? Integer.parseInt(releaseYears[1]) : Year.now().getValue()) : releaseYear;

            String genres = seriesScanner.next();
            double score = seriesScanner.nextDouble();

            String[] seasons = seriesScanner.next().split(",");

            Series series = new Series(name, MediaType.SERIES, releaseYear, endYear, score);
            addGenres(series, genres);

            for (String seasonAndEpisodes : seasons) {
                String[] parts = seasonAndEpisodes.split("-");
                series.addSeason(Integer.parseInt(parts[1].trim()));
            }
        }

        Eliten.getLogger().info("Loading series - complete");
    }

    private void addGenres(Media media, String genres) {

        if (!genres.contains(",")) {
            media.addGenre(Genre.fromString(genres));
        }
        else {
            for (String genre : genres.split(", ")) {
                media.addGenre(Genre.fromString(genre));
            }
        }
    }
}
