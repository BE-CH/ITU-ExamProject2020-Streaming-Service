package com.eliten.eksamen;

import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.media.Series;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
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

            String name = movies.next().trim();
            int year = movies.nextInt();
            String genres = movies.next();
            double score = movies.nextDouble();

            Media media = new Media(name, MediaType.MOVIE, year, score);
            addGenres(media, genres);
            addImage(media, "movie_images");
        }

        Eliten.getLogger().info("Loading movies - complete");
        Eliten.getLogger().info("Loading series - begun");

        Scanner seriesScanner = new Scanner(getClass().getResourceAsStream("/serier.txt")).useDelimiter("\\s*;\\s");

        while (seriesScanner.hasNext()) {

            String name = seriesScanner.next().trim();

            String release = seriesScanner.next();
            String[] releaseYears = release.split("-");

            int releaseYear = Integer.parseInt(releaseYears[0]);
            int endYear = release.contains("-") ? (releaseYears.length > 1 ? Integer.parseInt(releaseYears[1]) : Year.now().getValue()) : releaseYear;

            String genres = seriesScanner.next();
            double score = seriesScanner.nextDouble();

            String[] seasons = seriesScanner.next().split(",");

            Series series = new Series(name, MediaType.SERIES, releaseYear, endYear, score);
            addGenres(series, genres);
            addImage(series, "series_images");

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

    private void addImage(Media media, String folder) {

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(folder + "/" + media.getName() + ".jpg");
            media.setImage(new JLabel(new ImageIcon(ImageIO.read(inputStream))));
        } catch (NullPointerException e) {
            Eliten.getLogger().warning(media.getName() + " image could not be found - please make sure it's spelled correctly.");
        } catch(IOException e) {
            Eliten.getLogger().warning(media.getName() + " image could not be read.");
        }
    }
}
