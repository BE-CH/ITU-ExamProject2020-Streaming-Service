package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Account;
import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MediaListPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Account loggedInAccount = Eliten.accountManager().getLoggedInAccount();

        if (loggedInAccount == null) {
            Eliten.getLogger().info("The user is not logged in but got to the select user page?");
            JOptionPane.showMessageDialog(null, "Du er ikke logget ind!");
            return;
        }

        String selectedUser = ((JButton) e.getSource()).getText();

        Eliten.accountManager().getLoggedInAccount().setSelectedUser(Eliten.accountManager().getLoggedInAccount().getUserByName(selectedUser));
        Eliten.getMasterFrame().changeView(new MediaListPage(), true);
        MediaListPage.changeList(Eliten.mediaManager().getMedias());
    }
}
