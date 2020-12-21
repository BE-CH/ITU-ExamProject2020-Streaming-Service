package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class MediaManager {

    private ArrayList<Media> medias;

    public MediaManager() {
        Eliten.getLogger().info("Initialised.");
        medias = new ArrayList<>();
    }

    /**
     * Add a {@link Media} object to the list of all medias
     *
     * @param media the {@link Media} object to add
     */
    public void addMedia(@NotNull Media media) {
        medias.add(media);
    }

    /**
     * Retrieve all medias
     * @return an {@link ArrayList<Media>} of all medias
     */
    @NotNull
    public ArrayList<Media> getMedias() {
        return medias;
    }

    /**
     * Retrieve a {@link Media} object based on the name
     * @param name the name to look for
     * @return the {@link Media} object that was found, or null if not found
     */
    @Nullable
    public Media getMediaByName(@NotNull String name) {
        for (Media media : medias) {
            if (media.getName().equalsIgnoreCase(name)) {
                return media;
            }
        }

        return null;
    }

    /**
     * Retrieve an {@link ArrayList<Media>} of {@link Media} objects based on the search that is given. This can return an empty array.
     * @param search a set of characters that the name must contain
     * @param genre the genre that the {@link Media} object must have
     * @param type the type of the {@link Media} object must be
     * @return an arraylist of all {@link Media} objects that meets the criteria
     */
    public ArrayList<Media> getMediasBySearch(@NotNull String search, @Nullable Genre genre, @Nullable MediaType type) {
        ArrayList<Media> medias = new ArrayList<>();

        for (Media media : getMedias()) {
            if ((media.getName().toLowerCase().contains(search.toLowerCase()) || search.contains("" + media.getReleaseYear())) && (genre == null || media.getGenres().contains(genre)) && (type == null || media.getType() == type)) {
                medias.add(media);
            }
        }

        return Eliten.viewManager().getNavigationBar().sort(medias);
    }
}
