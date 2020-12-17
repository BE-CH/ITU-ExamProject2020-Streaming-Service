package com.eliten.eksamen.managers;

import com.eliten.eksamen.account.Account;
import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.User;
import com.eliten.eksamen.gui.LoginPage;
import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.media.Media;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AccountManager {

    private ArrayList<Account> accounts;
    private Account loggedInAccount;
    private Logger logger;
    private FileManager fileManager;
    private MasterFrame masterFrame;
    private MediaManager mediaManager;
    public AccountManager(Logger logger, FileManager filemanager, MasterFrame masterFrame, MediaManager mediaManager) {
        this.fileManager = filemanager;
        this.masterFrame = masterFrame;
        this.mediaManager = mediaManager;

        accounts = new ArrayList<>();
        this.logger = logger;
        JSONArray jsonAccounts = new JSONArray(new String(fileManager.getFileByteArray("accounts.json", logger)));

        for (int i = 0; i < jsonAccounts.length(); i++) {
            accounts.add(new Account(jsonAccounts.getJSONObject(i), mediaManager, this));
        }
    }

    public boolean login(String email, String password) {
        for (Account account : accounts) {
            if (email.equalsIgnoreCase(account.getEmail()) && new StrongPasswordEncryptor().checkPassword(password, account.getPassword())) {
                loggedInAccount = account;
                return true;
            }
        }

        return false;
    }

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    public void save() {
        JSONArray jsonAccounts = new JSONArray();

        for (Account account : accounts) {
            JSONObject jsonAccount = new JSONObject();
            jsonAccount.put("email", account.getEmail());
            jsonAccount.put("password", account.getPassword());
            jsonAccount.put("admin", account.isAdmin());

            JSONArray jsonUsers = new JSONArray();

            for (User user : account.getUsers()) {
                JSONObject jsonUser = new JSONObject();
                jsonUser.put("username", user.getName());
                jsonUser.put("age", user.getAge());

                JSONArray jsonUserList = new JSONArray();

                for (Media media : user.getMyList()) {
                    jsonUserList.put(media.getName());
                }

                jsonUser.put("myList", jsonUserList);
                jsonUsers.put(jsonUser);
            }

            jsonAccount.put("users", jsonUsers);
            jsonAccounts.put(jsonAccount);
        }

        fileManager.saveFile("accounts.json", jsonAccounts.toString());
    }

    public void logout() {
        masterFrame.changeView(new LoginPage(this,  logger,  masterFrame,  mediaManager), false);
    }
}
