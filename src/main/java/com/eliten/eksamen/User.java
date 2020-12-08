package com.eliten.eksamen;

import com.eliten.eksamen.media.Media;

import java.util.ArrayList;

public class User {

    private Account account;

    private String name;
    private int age;
    private ArrayList<Media> myList;

    public User(Account account, String name, int age, ArrayList<Media> myList){
        this.account = account;
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
        Eliten.accountManager().save();
    }

    public void changeAge(int age){
        this.age = age;
        Eliten.accountManager().save();
    }
    public void oneYearOlder(){
        age++;
        Eliten.accountManager().save();
    }

    public void addToList(Media media){
        myList.add(media);
        Eliten.accountManager().save();
    }

    public void removeFromList(Media m){
        myList.remove(m);
        Eliten.accountManager().save();
    }
}