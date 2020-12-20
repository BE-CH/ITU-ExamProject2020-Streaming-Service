package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.exceptions.FileManagerLoadException;
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

public class FileManager {

    private MediaManager mediaTest = new MediaManager();

    public FileManager() {

        Eliten.getLogger().info("Initialised. Data loading will begin: ");

        try {
            readFiles();
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileManagerLoadException();
        }

        Eliten.getLogger().info("All data has been loaded");

    }

    public void readFiles() {

        //Eliten.getLogger().info("Loading movies - begun");

        Scanner movies = new Scanner(getClass().getResourceAsStream("/film.txt")).useDelimiter("\\s*;\\s");

        while(movies.hasNext()) {

            String name = movies.next().trim();
            int year = movies.nextInt();
            String genres = movies.next();
            double score = movies.nextDouble();

            Media media = new Media(name, MediaType.MOVIE, year, score);
            addGenres(media, genres);
            addImage(media, "movie_images");

            mediaTest.addMedia(media);
            //Eliten.mediaManager().addMedia(media);
        }

        //Eliten.getLogger().info("Loading movies - complete");
        //Eliten.getLogger().info("Loading series - begun");

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

            mediaTest.addMedia((series));
            //Eliten.mediaManager().addMedia(series);
        }

        //Eliten.getLogger().info("Loading series - complete");
    }

    public MediaManager getTestMediaManager(){
        return mediaTest;
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

    public void addImage(Media media, String folder) {

        media.setImage(getImage(folder + "/" + media.getName() + ".jpg"));
    }

    public File getFile(String path) throws IOException {


        File targetFile = new File(path);
        FileUtils.copyInputStreamToFile(getClass().getClassLoader().getResourceAsStream(path), targetFile);

        return targetFile;
    }

    public void saveFile(String path, String data) throws IOException, URISyntaxException  {

        FileWriter writer = new FileWriter(getFile(path));
        writer.write(data);
        writer.flush();
    }

    public byte[] getFileByteArray(String path) {

        try {
            return FileUtils.readFileToByteArray(getFile(path));
        } catch (Exception e) {
            //Eliten.getLogger().warning("File not found with path " + path);
        }

        return null;
    }

    public ImageIcon getImage(String path) {

        try {
            return new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream(path)));
        } catch(IOException e) {
            e.printStackTrace();
            //Eliten.getLogger().warning("Failed to load image from path: " + path);
        } catch (IllegalArgumentException e) {
            //Eliten.getLogger().warning("Image path is returning null " + path);
        }
        
        return null;
    }
}
