package com.eliten.eksamen;

import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;

import java.util.logging.Logger;

public class Eliten {

    private static final Logger logger = Logger.getLogger("Test");

    private static MediaManager mediaManager;
    private static FileManager fileManager;
    private static MasterFrame masterFrame;


    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        logger.info("Programmerings Projekt 2020 - Eliten");

        mediaManager = new MediaManager();
        fileManager = new FileManager();
        masterFrame = new MasterFrame();

    }

    public static MediaManager mediaManager() {
        return mediaManager;
    }

    public static FileManager fileManager() {
        return fileManager;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static MasterFrame getMasterFrame() {
        return masterFrame;
    }
}
