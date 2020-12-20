package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.Account;
import com.eliten.eksamen.account.User;
import com.eliten.eksamen.gui.LoginPage;
import com.eliten.eksamen.media.Media;
import org.jasypt.util.password.StrongPasswordEncryptor;
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

        JSONArray jsonAccounts = new JSONArray(new String(Eliten.fileManager().getFileByteArray("accounts.json")));

        for (int i = 0; i < jsonAccounts.length(); i++) {
            accounts.add(new Account(jsonAccounts.getJSONObject(i)));
        }

        Eliten.getLogger().info("Accounts and users have been loaded");
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
        try {
            Eliten.fileManager().saveFile("accounts.json", jsonAccounts.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vi kunne desværre ikke gemme din data til filen. Kontakt venligst support hvis problemet forsætter.");
            e.printStackTrace();
        }
    }

    public void logout() {
        Eliten.viewManager().changeView(new LoginPage(), false);
    }
}
