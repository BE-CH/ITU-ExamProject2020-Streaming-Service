package com.eliten.eksamen.gui;

public enum SortingStyle {
    ALPHABETICALLY("Alfabetisk"),
    NEWEST("Nyest"),
    RATING("Score"),
    DEFAULT("Default");

    private String name;

    SortingStyle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
