package com.eliten.eksamen.managers;

import com.eliten.eksamen.Account;
import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.LoginPage;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.json.JSONArray;

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


    public void logout() {
        Eliten.getMasterFrame().changeView(new LoginPage(), false);
    }
}
