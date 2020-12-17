package com.eliten.eksamen.account;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.MediaManager;
import com.eliten.eksamen.media.Media;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Account {

    private String email;
    private String password;
    private ArrayList<User> users;
    private boolean isAdmin;
    private MediaManager mediaManager;
    private AccountManager accountManager;

    private User selectedUser;

    public Account(JSONObject json, MediaManager mediaManager, AccountManager accountManager) {
        this.mediaManager = mediaManager;
        this.accountManager = accountManager;
        email = json.getString("email");
        password = json.getString("password");
        isAdmin = json.getBoolean("admin");
        users = new ArrayList<>();

        JSONArray jsonUsers = json.getJSONArray("users");

        for (int i = 0; i < jsonUsers.length(); i++) {

            JSONObject jsonUser = jsonUsers.getJSONObject(i);
            JSONArray savedMedias = jsonUser.getJSONArray("myList");

            ArrayList<Media> myList = new ArrayList<>();

            for (int j = 0; j < savedMedias.length(); j++) {
                myList.add(mediaManager.getMediaByName(savedMedias.getString(j)));
            }

            users.add(new User(jsonUser.getString("username"), jsonUser.getInt("age"), myList, accountManager));
        }
    }

    /**
     * Should only be used for creating new accounts using the interface.
     * @param email the email
     * @param password the password, not encrypted
     * @param isAdmin whether the user is an admin or not
     */
    public Account(String email, String password, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;

        users = new ArrayList<>();
        users.add(new User("Default", -1, new ArrayList<>(), accountManager));
    }

    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User getUserByName(String name){
        for (User user : users) {
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }

        return null;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getSelectedUser() {
        return selectedUser;
    }
}
