package com.eliten.eksamen;

import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import com.eliten.eksamen.managers.ViewManager;

import java.util.logging.Logger;

public class Eliten {

    private static final Logger logger = Logger.getLogger(Eliten.class.getName());

    private static MediaManager mediaManager;
    private static FileManager fileManager;
    private static AccountManager accountManager;
    private static ViewManager viewManager;

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        logger.info("Programmerings Projekt 2020 - Eliten - ITU");

        mediaManager = new MediaManager();
        fileManager = new FileManager();
        accountManager = new AccountManager();
        viewManager = new ViewManager();
    }

    public static AccountManager accountManager() {
        return accountManager;
    }

    public static MediaManager mediaManager() {
        return mediaManager;
    }

    public static ViewManager viewManager() {
        return viewManager;
    }

    public static FileManager fileManager() {
        return fileManager;
    }

    public static Logger getLogger() {
        return logger;
    }
}
