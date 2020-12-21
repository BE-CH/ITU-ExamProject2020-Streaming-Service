package com.eliten.eksamen.account;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.media.Media;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class User {

    private String name;
    private int age;
    private ArrayList<Media> myList;

    public User(String name, int age, ArrayList<Media> myList){
        this.name = name;
        this.age = age;
        this.myList = myList;
    }

    /**
     * Retrieve the name of the user.
     * @return the name of the user
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Retrieve the age of the user.
     * @return the age of the user
     */
    public int getAge(){
        return age;
    }

    /**
     * Retrieve an {@link ArrayList<Media>} of all medias in this user's favorite list. This list
     * can be empty.
     * @return an arraylist of the user's favorite medias
     */
    @NotNull
    public ArrayList<Media> getMyList(){
        return myList;
    }

    /**
     * Set the name of the user. Note that this calls {@link AccountManager#save()}
     * @param name the new age of the user
     */
    public void setName(@NotNull String name){
        this.name = name;
        Eliten.accountManager().save();
    }

    /**
     * Change the age of the user. Note that this calls {@link AccountManager#save()}
     * @param age the new age of the user
     */
    public void setAge(int age){
        this.age = age;
        Eliten.accountManager().save();
    }

    /**
     * Increments the age of the user. Note that this calls {@link AccountManager#save()}
     */
    public void oneYearOlder(){
        age++;
        Eliten.accountManager().save();
    }

    /**
     * Adds a new {@link Media} to the user's personal list of medias Note that this calls {@link AccountManager#save()}
     * @param media the media to add
     */
    public void addToList(@NotNull Media media){
        myList.add(media);
        Eliten.accountManager().save();
    }

    /**
     * Removes a new {@link Media} from the user's personal list of medias Note that this calls {@link AccountManager#save()}
     * @param media the media to remove
     */
    public void removeFromList(@NotNull Media media){
        myList.remove(media);
        Eliten.accountManager().save();
    }
}