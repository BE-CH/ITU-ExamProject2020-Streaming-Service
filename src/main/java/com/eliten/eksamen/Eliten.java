package com.eliten.eksamen;

import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import org.json.JSONArray;

import java.util.logging.Logger;

public class Eliten {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Test");

        MediaManager mediaManager;
        FileManager fileManager;
        AccountManager accountManager;
        MasterFrame masterFrame = new MasterFrame();

        JSONArray database;

        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        logger.info("Programmerings Projekt 2020 - Eliten");
        mediaManager = new MediaManager(masterFrame);
        fileManager = new FileManager(logger, mediaManager);
        accountManager = new AccountManager(logger, fileManager, masterFrame, mediaManager);
        masterFrame = new MasterFrame(fileManager, logger, accountManager, mediaManager);
        mediaManager = new MediaManager(masterFrame);
        accountManager = new AccountManager(logger, fileManager, masterFrame, mediaManager);
    }
    /*
    public AccountManager accountManager() {
        return accountManager;
    }

    public MediaManager mediaManager() {
        return mediaManager;
    }

    public FileManager fileManager() {
        return fileManager;
    }

    public Logger getLogger() {
        return logger;
    }

    public MasterFrame getMasterFrame() {
        return masterFrame;
    }*/
}
