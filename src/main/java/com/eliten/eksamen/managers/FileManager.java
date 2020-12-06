package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.media.Series;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Year;
import java.util.Scanner;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


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

            Eliten.mediaManager().addMedia(series);
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

        media.setImage(getImage(folder + "/" + media.getName() + ".jpg"));
    }

    public File getFile(String path) throws URISyntaxException {

        return new File(getClass().getClassLoader().getResource(path).toURI());
    }

    public ImageIcon getImage(String path) {

        try {
            return new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream(path)));
        } catch(IOException e) {
            e.printStackTrace();
            Eliten.getLogger().warning("Failed to load image from path: " + path);
        } catch (IllegalArgumentException e) {
            Eliten.getLogger().warning("Image path is returning null " + path);
        }
        
        return null;
    }

    public void overWriteMylist(ArrayList<Media> myList){
        Media list[] = new Media[myList.size()];
        for(int i = 0; i < myList.size(); i++){
            list[i] = myList.get(i);
        }
        JSONArray database = Eliten.getDatabase();
        JSONObject user = new JSONObject();
        for(int i = 0; i < database.length(); i++){
            if(database.getJSONObject(i).get("email") == Eliten.getLoggedInAccount().getEmail()){
                for(int j = 0; j < database.getJSONObject(i).getJSONArray("users").getJSONObject(i).length(); j++) {
                    String username = database.getJSONObject(i).getJSONArray("users").getJSONObject(j).getString("username");
                    if(username == Eliten.getSelectedUser().getName()){
                        database.getJSONObject(i).getJSONArray("users").getJSONObject(j).remove("myList");
                        database.getJSONObject(i).getJSONArray("users").getJSONObject(j).put("myList", new JSONArray());
                        for(int k = 0; k < myList.size(); k++){
                            System.out.println(myList.get(k).getName());
                            database.getJSONObject(i).getJSONArray("users").getJSONObject(j).getJSONArray("myList").put(k, "title: " + myList.get(k).getName()});
                        }
                        System.out.println(database.getJSONObject(i).getJSONArray("users").getJSONObject(j));
                    }
                }
            }
        }
        //System.out.println(database.getJSONObject(0).getJSONArray("users").getJSONObject(0));
    }
}
