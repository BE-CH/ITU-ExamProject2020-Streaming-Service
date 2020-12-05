package com.eliten.eksamen;

import com.eliten.eksamen.gui.LoginPage;
import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import org.json.JSONArray;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Eliten {

    private static final Logger logger = Logger.getLogger("Test");

    private static MediaManager mediaManager;
    private static FileManager fileManager;
    private static MasterFrame masterFrame;
    private static JSONArray database;
    private static Account loggedInAccount;
    private static User selectedUser;


    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        logger.info("Programmerings Projekt 2020 - Eliten");
        loggedInAccount = null;
        selectedUser = null;
        iniateDatabase();

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

    public static void iniateDatabase() {
        try {
            logger.info("Trying to initate JSON database");
            URL accountsFile = Eliten.class.getResource("/accounts.json");
            byte[] bytes = Files.readAllBytes(Paths.get(accountsFile.toURI()));

            String JSONText = new String(bytes);

            database = new JSONArray(JSONText);


        }catch (Exception e){
            logger.info("Could not iniate database! " + e.getMessage());
        }

    }

    public static JSONArray getDatabase(){ return database; }

    public static void setLoggedInAccount(Account acc) { loggedInAccount = acc;}

    public static Account getLoggedInAccount() { return loggedInAccount; };

    public static void setSelectedUser(User usr) { selectedUser = usr;};

    public static User getSelectedUser() { return selectedUser; };

    public static void logOutUser() {
        setSelectedUser(null);
        setLoggedInAccount(null);
        getMasterFrame().changeView(new LoginPage(), false);
    }
}
