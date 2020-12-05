package com.eliten.eksamen.media;

import org.apache.commons.lang3.StringUtils;

public enum Genre {
    FILMNOIR("Film-noir", "N/A"),
    MUSIC("", "Hvem kan ikke lide film og serier med noget musik?"),
    DOCUMENTARY("", "Leder du efter at lære noget nyt? Kig ikke længere!"),
    CRIME("", "Vil du hjælpe at med at løse et mord? Eller noget lignede?"),
    WESTERN("", "Hvem kan ikke lide vesten?"),
    MUSICAL("", "Hvem kan ikke lide film og serier med noget musik?"),
    HISTORY("", "Det er vigtigt at lære fra fortiden."),
    FAMILY("", "Vil du se en god film med din familie?"),
    WAR("", "Er der en indre soldat i dig? Kunne du tænke dig at se en soldat i aktion?"),
    ACTION("", "Leder du efter konstant underholdning? Det bliver ikke bedre med noget action!"),
    DRAMA("", "Kan du lide noget drama? Kig ikke længere!"),
    FANTASY("", "Kun fantasien sætter grænser!"),
    ANIMATION("", "Animations film for børn og voksne!"),
    ROMANCE("", "Er du mere kærligheds-typen?"),
    SPORT("", "Gooooooal!! Han scorede sgu! Leder du efter noget sport?"),
    TALKSHOW("Talk-show", "Jimmy Kimmel? James Corden? Carpool Karaoke?"),
    COMEDY("", "Klar på at være flad af grin?"),
    THRILLER("", "Så er det tid til at holde angsten inde"),
    SCIFI("Sci-fi", "Må kraften være med dig, unge padawan."),
    BIOGRAPHY("", "Hør om bestemt persons livshistorie."),
    HORROR("", "Med mindre du er klar på at tisse i bukserne, vil jeg nok ikke anbefale denne kategori."),
    ADVENTURE("", "Klar på et eventyr? Det er jeg ihvertfald!"),
    MYSTERY("", "Hvem var det mon der gjorde det?");

    private String name;
    private String description;

    Genre(String name, String description) {

        this.name = name.isEmpty() ? StringUtils.capitalize(name().toLowerCase()) : name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
