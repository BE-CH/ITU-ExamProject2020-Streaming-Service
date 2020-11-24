package com.eliten.eksamen.media;

import java.util.LinkedList;

public class Series extends Media {

    private int endYear;
    private LinkedList<Integer> seasons; // Season 1: 0 element, the value is the amount of episodes

    public Series(String name, MediaType type, int releaseYear, int endYear, double score) {

        super(name, type, releaseYear, score);

        this.endYear = endYear;

        seasons = new LinkedList<>();
    }

    public void addSeason(int episodes) {
        seasons.add(episodes);
    }

    public int getEpisodes(int season) {
        return seasons.get(season - 1);
    }
}
