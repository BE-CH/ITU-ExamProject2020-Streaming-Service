package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.Account;
import com.eliten.eksamen.account.User;
import com.eliten.eksamen.gui.LoginPage;
import com.eliten.eksamen.media.Media;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.util.ArrayList;

public class AccountManager {

    private ArrayList<Account> accounts;
    private Account loggedInAccount;

    public AccountManager() {
        Eliten.getLogger().info("Initialised. Loading accounts and users now");

        accounts = new ArrayList<>();
        loggedInAccount = null;

        JSONArray jsonAccounts = new JSONArray(new String(Eliten.fileManager().getFileByteArray("accounts.json")));

        for (int i = 0; i < jsonAccounts.length(); i++) {
            accounts.add(new Account(jsonAccounts.getJSONObject(i)));
        }

        Eliten.getLogger().info("Accounts and users have been loaded");
    }

    /**
     * Attempt to log-in with the email and password.
     * @param email the email of the user
     * @param password the password of the user
     * @return true if the login was successful
     */
    public boolean login(@NotNull String email, @NotNull String password) {
        for (Account account : accounts) {
            if (email.equalsIgnoreCase(account.getEmail()) && new StrongPasswordEncryptor().checkPassword(password, account.getPassword())) {
                loggedInAccount = account;
                return true;
            }
        }

        return false;
    }

    /**
     * Retrieve the currently logged in account, this can be null if the user is logged out and in the login page.
     * @return the currently logged in account
     */
    @Nullable
    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    /**
     * Save the changes in the locally stored cache to the JSON file.
     */
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
        try {
            Eliten.fileManager().saveFile("accounts.json", jsonAccounts.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vi kunne desværre ikke gemme din data til filen. Kontakt venligst support hvis problemet forsætter.");
            e.printStackTrace();
        }
    }

    /**
     * Log the user out and send them back to the login page
     */
    public void logout() {
        loggedInAccount.setSelectedUser(null);
        loggedInAccount = null;
        Eliten.viewManager().changeView(new LoginPage(), false);
    }
}
