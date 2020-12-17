package com.eliten.eksamen.account;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.media.Media;

import java.util.ArrayList;

public class User {

    private String name;
    private int age;
    private ArrayList<Media> myList;
    private AccountManager accountManager;

    public User(String name, int age, ArrayList<Media> myList, AccountManager accountManager){
        this.accountManager = accountManager;
        this.name = name;
        this.age = age;
        this.myList = myList;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public ArrayList<Media> getMyList(){
        return myList;
    }

    //Setters
    public void changeName(String name){
        this.name = name;
        accountManager.save();
    }

    public void changeAge(int age){
        this.age = age;
        accountManager.save();
    }
    public void oneYearOlder(){
        age++;
        accountManager.save();
    }

    public void addToList(Media media){
        myList.add(media);
        accountManager.save();
    }

    public void removeFromList(Media m){
        myList.remove(m);
        accountManager.save();
    }
}