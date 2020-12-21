package com.eliten.eksamen.utils;


import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Utils {

    /**
     * Run a specific task later
     * @param listener the task to run
     * @param delay the delay
     */
    public static void runLater(@NotNull ActionListener listener, int delay) {

        Timer timer = new Timer(delay, listener);
        timer.setRepeats(false);
        timer.start();
    }
}
