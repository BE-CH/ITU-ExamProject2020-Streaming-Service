package com.eliten.eksamen.media;

import com.eliten.eksamen.managers.FileManager;

import java.util.LinkedList;
import java.util.logging.Logger;

public class Series extends Media {

    private int endYear;
    private LinkedList<Integer> seasons; // Season 1: 0 element, the value is the amount of episodes

    public Series(String name, MediaType type, int releaseYear, int endYear, double score, FileManager fileManager, Logger logger) {

        super(name, type, releaseYear, score, fileManager, logger);

        this.endYear = endYear;

        seasons = new LinkedList<>();
    }

    public void addSeason(int episodes) {
        seasons.add(episodes);
    }

    public LinkedList<Integer> getSeasons() {
        return seasons;
    }

    public int getEpisodeAmount(int season) {
        return seasons.get(season);
    }
}
