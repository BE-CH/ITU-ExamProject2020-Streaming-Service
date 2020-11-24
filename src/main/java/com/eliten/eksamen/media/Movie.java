package com.eliten.eksamen.media;

import java.util.ArrayList;

public class Movie  {

    private double score;

    public Movie(String name, int releaseDate, ArrayList<Genre> genres, double score) {

        this.score = score;
    }

    public void setScore(double score) {

        this.score = score;
    }

    public double getScore() {

        return score;
    }
}
