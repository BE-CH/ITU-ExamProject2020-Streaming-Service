package com.eliten.eksamen.utils;

import com.eliten.eksamen.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingUtils {

    public static void alphabetically(ArrayList<Media> list) {
        list.sort(Comparator.comparing(Media::getName));
    }

    public static void newest(ArrayList<Media> list) {
        list.sort(Comparator.comparingInt(Media::getReleaseYear));
        Collections.reverse(list);
    }

    public static void rating(ArrayList<Media> list) {
        list.sort(Comparator.comparingDouble(Media::getScore));
        Collections.reverse(list);
    }
}
