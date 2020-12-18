package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.SelectUserPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUserListener implements ActionListener {

    private JTextField email;
    private JPasswordField password;

    public LoginUserListener(JTextField email, JPasswordField password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String emailInput = email.getText();
        String passwordInput = password.getText();

        if(emailInput.isEmpty() || passwordInput.isEmpty()) {
            Eliten.getLogger().info("You need to put in both user and password.");
            JOptionPane.showMessageDialog(null, "Du skal indtaste både email og adgangskode!");
            return;
        }

        if (!Eliten.accountManager().login(emailInput, passwordInput)) {
            Eliten.getLogger().info("Incorrect login, please try again.");
            JOptionPane.showMessageDialog(null, "Der findes ingen brugerer med den kombination!");
            return;
        }

        Eliten.viewManager().changeView(new SelectUserPage(Eliten.accountManager().getLoggedInAccount().getUsers()), false);
    }
}
