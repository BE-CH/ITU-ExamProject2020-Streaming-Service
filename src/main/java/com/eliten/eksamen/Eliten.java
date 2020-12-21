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

    /**
     * Retrieve the global {@link AccountManager}.
     * @return the account manager that has been created.
     */
    public static AccountManager accountManager() {
        return accountManager;
    }

    /**
     * Retrieve the global {@link MediaManager}.
     * @return the media manager that has been created.
     */
    public static MediaManager mediaManager() {
        return mediaManager;
    }

    /**
     * Retrieve the global {@link ViewManager}.
     * @return the view manager that has been created.
     */
    public static ViewManager viewManager() {
        return viewManager;
    }

    /**
     * Retrieve the global {@link FileManager}.
     * @return the file manager that has been created.
     */
    public static FileManager fileManager() {
        return fileManager;
    }

    /**
     * Retrieve the global {@link Logger}.
     * @return the logger that has been created.
     */
    public static Logger getLogger() {
        return logger;
    }
}
