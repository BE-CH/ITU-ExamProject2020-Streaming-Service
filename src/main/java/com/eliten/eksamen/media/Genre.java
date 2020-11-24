package com.eliten.eksamen.media;

import org.apache.commons.lang3.StringUtils;

public enum Genre {
    FILMNOIR("Film-noir"),
    MUSIC,
    DOCUMENTARY,
    CRIME,
    WESTERN,
    MUSICAL,
    HISTORY,
    FAMILY,
    WAR,
    ACTION,
    DRAMA,
    FANTASY,
    ANIMATION,
    ROMANCE,
    SPORT,
    TALKSHOW("Talk-show"),
    COMEDY,
    THRILLER,
    SCIFI("Sci-fi"),
    BIOGRAPHY,
    HORROR,
    ADVENTURE,
    MYSTERY;

    private String name;

    Genre(String name) {

        this.name = name;
    }

    Genre() {

        this.name = StringUtils.capitalize(name().toLowerCase());
    }

    public String getName() {
        return name;
    }

    public static Genre fromString(String string) {
        for (Genre genre : values()) {
            if (genre.name.equalsIgnoreCase(string)) {
                return genre;
            }
        }

        return null;
    }
}
