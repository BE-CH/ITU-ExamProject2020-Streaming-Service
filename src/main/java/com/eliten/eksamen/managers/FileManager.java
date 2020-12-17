package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.media.Series;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Year;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileManager {

    private MediaManager mediaManager;

    public FileManager(Logger logger, MediaManager mediaManager) {
        this.mediaManager = mediaManager;

        logger.info("FileManager: Initialised. Data will begin: ");
        readFiles(logger);
        logger.info("FileManager: All data has been loaded");
    }

    public void readFiles(Logger logger) {

        logger.info("Loading movies - begun");

        Scanner movies = new Scanner(getClass().getResourceAsStream("/film.txt")).useDelimiter("\\s*;\\s");

        while(movies.hasNext()) {

            String name = movies.next().trim();
            int year = movies.nextInt();
            String genres = movies.next();
            double score = movies.nextDouble();

            Media media = new Media(name, MediaType.MOVIE, year, score, this, logger);
            addGenres(media, genres);
            addImage(media, "movie_images", logger);

            mediaManager.addMedia(media);
        }

        logger.info("Loading movies - complete");
        logger.info("Loading series - begun");

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

            Series series = new Series(name, MediaType.SERIES, releaseYear, endYear, score, this, logger);
            addGenres(series, genres);
            addImage(series, "series_images", logger);

            for (String seasonAndEpisodes : seasons) {
                String[] parts = seasonAndEpisodes.split("-");
                series.addSeason(Integer.parseInt(parts[1].trim()));
            }

            mediaManager.addMedia(series);
        }

        logger.info("Loading series - complete");
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

    private void addImage(Media media, String folder, Logger logger) {

        media.setImage(getImage(folder + "/" + media.getName() + ".jpg", logger));
    }

    public File getFile(String path) throws URISyntaxException {

        return new File(getClass().getClassLoader().getResource(path).toURI());
    }

    public void saveFile(String path, String data) {

        try (FileWriter writer = new FileWriter(getFile(path))){
           writer.write(data);
           writer.flush();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public byte[] getFileByteArray(String path, Logger logger) {

        try {
            return FileUtils.readFileToByteArray(getFile(path));
        } catch (Exception e) {
            logger.warning("File not found with path " + path);
        }

        return null;
    }

    public ImageIcon getImage(String path, Logger logger) {

        try {
            return new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream(path)));
        } catch(IOException e) {
            e.printStackTrace();
            logger.warning("Failed to load image from path: " + path);
        } catch (IllegalArgumentException e) {
            logger.warning("Image path is returning null " + path);
        }
        
        return null;
    }
}
