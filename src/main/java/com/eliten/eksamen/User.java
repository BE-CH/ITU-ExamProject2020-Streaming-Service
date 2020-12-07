package com.eliten.eksamen;

import com.eliten.eksamen.media.Media;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Media> myList;

    public User(String name, int age, ArrayList<Media> listOfMedia){
        this.name = name;
        this.age = age;
        myList = listOfMedia;
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
    }

    public void changeAge(int age){
        this.age = age;
    }
    public void oneYearOlder(){
        age++;
    }

    public void addToList(Media m){
        myList.add(m);
    }

    public void removeFromList(Media m){
        myList.remove(m);
    }
}