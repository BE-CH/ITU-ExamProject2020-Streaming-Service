package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.LoginPage;
import com.eliten.eksamen.gui.SelectUserPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginPage currentPage = (LoginPage) Eliten.getMasterFrame().getCurrentPage();
        String emailInput = currentPage.getEmailInput();
        String passwordInput = currentPage.getPasswordInput();

        if(emailInput.isEmpty() || passwordInput.isEmpty()) {
            Eliten.getLogger().info("You need to put in both user and password.");
            JOptionPane.showMessageDialog(null, "Du skal indtaste både email og adgangskode!");
            return;
        }

        if (!Eliten.accountManager().login(emailInput, passwordInput)) {
            Eliten.getLogger().info("Incorrect login, please try again.");
            JOptionPane.showMessageDialog(null, "Der findes ingen bruger med den email!");
            return;
        }

        Eliten.getMasterFrame().changeView(new SelectUserPage(Eliten.accountManager().getLoggedInAccount().getUsers()), false);
    }
}
