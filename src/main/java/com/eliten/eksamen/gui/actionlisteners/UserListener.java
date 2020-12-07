package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Account;
import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.User;
import com.eliten.eksamen.gui.MediaListPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Account loggedInAccount = Eliten.getLoggedInAccount();
        String selectedUserName = ((JButton) e.getSource()).getText();
        User selectedUser = null;

        if (loggedInAccount == null) {
            Eliten.getLogger().info("The user is not logged in but got to the select user page?");
            JOptionPane.showMessageDialog(null, "Du er ikke logget ind!");
            return;
        }

        ArrayList<User> accountUsers = loggedInAccount.getUsers();

        for (User usr : accountUsers){
            if(usr.getName().equalsIgnoreCase(selectedUserName)){
                selectedUser = usr;
                break;
            }
        }

        Eliten.setSelectedUser(selectedUser);
        Eliten.getMasterFrame().changeView(new MediaListPage(), true);
        MediaListPage.changeList(Eliten.mediaManager().getMedias());
    }
}
