package com.eliten.eksamen.account;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.media.Media;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Account {

    private String email;
    private String password;
    private ArrayList<User> users;
    private boolean isAdmin;

    private User selectedUser;

    public Account(JSONObject json) {
        selectedUser = null;

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
                myList.add(Eliten.mediaManager().getMediaByName(savedMedias.getString(j)));
            }

            users.add(new User(jsonUser.getString("username"), jsonUser.getInt("age"), myList));
        }
    }

    /**
     * Retrieve the email of the account
     * @return the email of the account
     */
    public String getEmail(){
        return email;
    }

    /**
     * Retrieve the password of the account
     * @return the password of the account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieve a {@link User} based on its name
     * @param name the name of the user
     * @return the user that was found
     */
    @Nullable
    public User getUserByName(@NotNull String name){
        for (User user : users) {
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }

        return null;
    }

    /**
     * Retrieve an {@link ArrayList<User>} of all users linked to the account
     * @return an array of all users
     */
    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * Retrieve whether or not the account is an admin and has access to see the admin panel.
     * @return true if the account is an admin
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Set the current selected user
     * @param selectedUser the user to set as the selected user
     */
    public void setSelectedUser(@Nullable User selectedUser) {
        this.selectedUser = selectedUser;
    }

    /**
     * Retrieve the currently selected user
     * @return the currently selected user
     */
    @Nullable
    public User getSelectedUser() {
        return selectedUser;
    }
}
