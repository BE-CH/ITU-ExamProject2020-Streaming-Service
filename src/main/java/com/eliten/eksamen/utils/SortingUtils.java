package com.eliten.eksamen.utils;

import com.eliten.eksamen.media.Media;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingUtils {

    /**
     * Sort the list provided alphabetically
     * @param list the list to sort
     */
    public static void alphabetically(@NotNull List<Media> list) {
        list.sort(Comparator.comparing(Media::getName));
    }

    /**
     * Sort the list provided by newest release date
     * @param list the list to sort
     */
    public static void newest(@NotNull List<Media> list) {
        list.sort(Comparator.comparingInt(Media::getReleaseYear));
        Collections.reverse(list);
    }

    /**
     * Sort the list provided by rating
     * @param list the list to sort
     */
    public static void rating(@NotNull List<Media> list) {
        list.sort(Comparator.comparingDouble(Media::getScore));
        Collections.reverse(list);
    }
}
