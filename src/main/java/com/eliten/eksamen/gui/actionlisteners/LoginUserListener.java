package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.gui.SelectUserPage;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import com.eliten.eksamen.media.Media;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class LoginUserListener implements ActionListener {

    private JTextField email;
    private JPasswordField password;

    private AccountManager accountManager;
    private Logger logger;
    private MasterFrame masterFrame;
    private MediaManager mediaManager;
    private FileManager fileManager;

    public LoginUserListener(JTextField email, JPasswordField password, AccountManager acc, Logger log, MasterFrame master, MediaManager meman, FileManager fileManager) {
        this.email = email;
        this.password = password;

        this.accountManager = acc;
        this.logger = log;
        this.masterFrame = master;
        this.mediaManager = meman;
        this.fileManager = fileManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String emailInput = email.getText();
        String passwordInput = password.getText();

        if(emailInput.isEmpty() || passwordInput.isEmpty()) {
            logger.info("You need to put in both user and password.");
            JOptionPane.showMessageDialog(null, "Du skal indtaste både email og adgangskode!");
            return;
        }

        if (!accountManager.login(emailInput, passwordInput)) {
            logger.info("Incorrect login, please try again.");
            JOptionPane.showMessageDialog(null, "Der findes ingen brugerer med den kombination!");
            return;
        }

        masterFrame.changeView(new SelectUserPage(accountManager.getLoggedInAccount().getUsers(), accountManager, logger, masterFrame, mediaManager, fileManager), false);
    }
}
