package com.eliten.eksamen.utils;


import javax.swing.*;
import java.awt.event.ActionListener;

public class Utils {

    public static void runLater(ActionListener listener, int delay) {

        Timer timer = new Timer(delay, listener);
        timer.setRepeats(false);
        timer.start();
    }
}
