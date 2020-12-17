package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.account.Account;
import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.gui.MediaListPage;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import com.eliten.eksamen.media.Media;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class UserListener implements ActionListener {

    private AccountManager accountManager;
    private Logger logger;
    private MasterFrame masterFrame;
    private MediaManager mediaManager;
    private FileManager fileManager;

    public UserListener(AccountManager accountManager, Logger logger, MasterFrame masterFrame, MediaManager mediaManager, FileManager filemanager){
        this.accountManager = accountManager;
        this.logger = logger;
        this.masterFrame = masterFrame;
        this.mediaManager = mediaManager;
        this.fileManager = filemanager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Account loggedInAccount = accountManager.getLoggedInAccount();

        if (loggedInAccount == null) {
            logger.info("The user is not logged in but got to the select user page?");
            JOptionPane.showMessageDialog(null, "Du er ikke logget ind!");
            return;
        }

        String selectedUser = ((JButton) e.getSource()).getText();

        accountManager.getLoggedInAccount().setSelectedUser(accountManager.getLoggedInAccount().getUserByName(selectedUser));
        masterFrame.changeView(new MediaListPage(), true);
        MediaListPage.changeList(mediaManager.getMedias(), masterFrame, fileManager, accountManager, mediaManager);
    }
}
