package com.eliten.eksamen.managers;

import com.eliten.eksamen.account.Account;
import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.User;
import com.eliten.eksamen.gui.LoginPage;
import com.eliten.eksamen.media.Media;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AccountManager {

    private ArrayList<Account> accounts;
    private Account loggedInAccount;

    public AccountManager() {
        accounts = new ArrayList<>();

        JSONArray jsonAccounts = new JSONArray(new String(Eliten.fileManager().getFileByteArray("accounts.json")));

        for (int i = 0; i < jsonAccounts.length(); i++) {
            accounts.add(new Account(jsonAccounts.getJSONObject(i)));
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

        for (Account account : this.accounts) {
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

        Eliten.fileManager().saveFile("accounts.json", jsonAccounts.toString());
    }

    public void logout() {
        Eliten.getMasterFrame().changeView(new LoginPage(), false);
    }
}
