package com.eliten.eksamen;

import java.util.ArrayList;

public class Account {

    private String email;
    private String password;
    private ArrayList<User> users;
    private boolean isAdmin;


    public Account(String email, String password, ArrayList<User> users, boolean isAdmin){
        this.email = email;
        this.password = password;
        this.users = users;
        this.isAdmin = isAdmin;

    }

    public String getEmail(){
        return email;
    }

    public User getUserByIndex(int index){
        return users.get(index);
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

    public boolean isAdmin() { return isAdmin; };
}
