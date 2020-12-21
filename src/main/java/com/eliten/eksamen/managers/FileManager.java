package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.exceptions.FileManagerLoadException;
import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.media.Series;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    /**
     * Read the TXT files and turn them into {@link Media} and {@link Series} objects
     */
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

            mediaTest.addMedia(media);
            Eliten.mediaManager().addMedia(media);
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

            mediaTest.addMedia((series));
            Eliten.mediaManager().addMedia(series);
        }

        Eliten.getLogger().info("Loading series - complete");
    }

    /**
     * Retrieve the test {@link MediaManager}
     * @return the {@link MediaManager}
     */
    public MediaManager getTestMediaManager(){
        return mediaTest;
    }

    private void addGenres(Media media, String genres) {

        genres = genres.trim();

        if (!genres.contains(",")) {
            Genre genre = Genre.fromString(genres);

            if (genre == null) {
                Eliten.getLogger().warning(genres + " is an invalid genre for " + media.getName());
                return;
            }

            media.addGenre(Genre.fromString(genres));
        }
        else {
            for (String genreName : genres.split(", ")) {
                Genre genre = Genre.fromString(genreName);

                if (genre == null) {
                    Eliten.getLogger().warning(genreName + " is an invalid genre for " + media.getName());
                    continue;
                }

                media.addGenre(genre);
            }
        }
    }

    /**
     * Used to set the {@link Media}'s image
     * @param media the media to set the image for
     * @param folder the folder where the image is in, the file has to
     *               have the same name as the media object. JPG files
     *               only.
     */
    public void addImage(Media media, String folder) {

        media.setImage(getImage(folder + "/" + media.getName() + ".jpg"));
    }

    /**
     * Retrive a specific {@link File} object based on the path you give.
     * If the file is not found, a copy will be attempted to find in the
     * resources folder.
     * @param path the path of the file to find
     * @return the file that was found
     * @throws IOException if the file did not exist anywhere
     */
    public File getFile(String path) throws IOException {

        File targetFile = new File(path);

        // Creates file basically
        if (!targetFile.exists()) {
            FileUtils.copyInputStreamToFile(getClass().getClassLoader().getResourceAsStream(path), targetFile);
        }

        return targetFile;
    }

    /**
     * Override a specific file based on the data that you give.
     * @param path the path of the file
     * @param data the data to put into the file
     * @throws IOException if the file exists but is a directory rather than
     * a regular file, does not exist but cannot be created,
     * or cannot be opened for any other reason
     */
    public void saveFile(String path, String data) throws IOException  {

        FileWriter writer = new FileWriter(getFile(path));
        writer.write(data);
        writer.flush();
    }

    /**
     * Retrieve an array of bytes for a file based on a specific path. This is useful for reading a JSON file.
     * @param path the path of the file to turn into bytes
     * @return an array of bytes if the file was found
     */
    @Nullable
    public byte[] getFileByteArray(String path) {

        try {
            return FileUtils.readFileToByteArray(getFile(path));
        } catch (Exception e) {
            //Eliten.getLogger().warning("File not found with path " + path);
        }

        return null;
    }

    /**
     * Get an image icon based on a specific path
     * @param path the path
     * @return the {@link ImageIcon} if found
     */
    @Nullable
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
