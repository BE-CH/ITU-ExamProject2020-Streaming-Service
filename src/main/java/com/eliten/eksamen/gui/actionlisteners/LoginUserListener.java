package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Account;
import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.User;
import com.eliten.eksamen.gui.LoginPage;
import com.eliten.eksamen.gui.SelectUserPage;
import com.eliten.eksamen.media.Media;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginUserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginPage currentPage = (LoginPage) Eliten.getMasterFrame().getCurrentPage();
        String emailInput = currentPage.getEmailInput();
        String passwordInput = currentPage.getPasswordInput();

        // Check if empty
        if(!emailInput.isEmpty() && !passwordInput.isEmpty()){

            // check if users exist in db
            JSONArray database = Eliten.getDatabase();
            JSONObject user = new JSONObject();

            for (int i = 0; i < database.length(); i++) {
                JSONObject userObject = (JSONObject) database.get(i);
                if(userObject.getString("email").equalsIgnoreCase(emailInput)){
                    user = userObject;
                    break;
                }
            }

            if(!user.isEmpty()){

                // Encrypt password
                StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                String encryptedPassword = passwordEncryptor.encryptPassword(passwordInput);

                if(passwordEncryptor.checkPassword(passwordInput, user.getString("password"))){
                    // password is correct

                    ArrayList<User> usersToAdd = new ArrayList<>();


                    for (int i = 0; i < user.getJSONArray("users").length(); i++) {
                        ArrayList<Media> mediasToAdd = new ArrayList<>();
                        JSONObject actualUser = user.getJSONArray("users").getJSONObject(i);
                        String username = user.getJSONArray("users").getJSONObject(i).getString("username");
                        int age = user.getJSONArray("users").getJSONObject(i).getInt("age");

                        for (int j = 0; j < actualUser.getJSONArray("myList").length(); j++) {
                            // Loops through all myList objects

                            JSONObject mediaLopped = actualUser.getJSONArray("myList").getJSONObject(j);
                            String mediaTitle = mediaLopped.getString("title");
                            mediasToAdd.add(Eliten.mediaManager().getMediaByName(mediaTitle));
                        }

                        usersToAdd.add(new User(username, age, mediasToAdd));
                    }
                    boolean isAdmin = false;

                    if(user.getBoolean("admin") == true){
                        isAdmin = true;
                    }


                    Account loggedInAccount = new Account(user.getString("email"), user.getString("password"), usersToAdd, isAdmin);
                    Eliten.setLoggedInAccount(loggedInAccount);

                    // user is now logged in

                    Eliten.getMasterFrame().changeView(new SelectUserPage(loggedInAccount.getUsers()), false);

                }else{
                    Eliten.getLogger().info("User password is wrong!");
                    JOptionPane.showMessageDialog(null, "Din adgangskode er forkert");
                }

            }else{
                Eliten.getLogger().info("No user found with that email");
                JOptionPane.showMessageDialog(null, "Der findes ingen bruger med den email!");
            }

        }else{
            Eliten.getLogger().info("You need to put in both user and password");
            JOptionPane.showMessageDialog(null, "Du skal indtaste både email og adgangskode!");
        }

    }
}
