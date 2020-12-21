package com.eliten.eksamen.media;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class Series extends Media {

    private int endYear;
    private LinkedList<Integer> seasons; // Season 1: 0 element, the value is the amount of episodes

    public Series(String name, MediaType type, int releaseYear, int endYear, double score) {

        super(name, type, releaseYear, score);

        this.endYear = endYear;

        seasons = new LinkedList<>();
    }

    /**
     * Add a new season to the {@link Series} object
     * @param episodes the amount of episodes this season has
     */
    public void addSeason(int episodes) {
        seasons.add(episodes);
    }

    /**
     * Retrieve all the seasons the object has. Note that the value it returns is the
     * amount of episodes for that season. This means that the element at 0 is season 1
     * and the value is the amount of episodes that season has.
     * @return an arraylist
     */
    @NotNull
    public LinkedList<Integer> getSeasons() {
        return seasons;
    }

    /**
     * Get the amount of episodes for a specific season.
     * Note that season 1 means the season parameter has
     * to be 0.
     * @param season the season to retrieve the amount of episodes for
     * @return the amount of episodes in that season
     */
    public int getEpisodeAmount(int season) {
        return seasons.get(season);
    }

    /**
     * Retrieve the release year for this series object
     * @return the end year
     */
    public int getEndYear() {
        return endYear;
    }
}
