package com.eliten.eksamen;

import com.eliten.eksamen.gui.MasterFrame;

import java.util.logging.Logger;

public class Eliten {

    private static final Logger logger = Logger.getLogger("Test");

    private static MediaController mediaController;
    private static FileManager fileManager;
    private static MasterFrame masterFrame;


    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        logger.info("Programmerings Projekt 2020 - Eliten");

        mediaController = new MediaController();
        fileManager = new FileManager();
        masterFrame = new MasterFrame();

    }

    public static MediaController mediaController() {
        return mediaController;
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
