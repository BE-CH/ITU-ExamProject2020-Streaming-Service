package com.eliten.eksamen.gui;

import com.eliten.eksamen.gui.actionlisteners.LoginUserListener;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import com.eliten.eksamen.utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.logging.Logger;


public class LoginPage extends JPanel {

    private AccountManager accountManager;
    private Logger logger;
    private MasterFrame masterFrame;
    private MediaManager mediaManager;
    private FileManager fileManager;

    public LoginPage(AccountManager acc, Logger log, MasterFrame master, MediaManager meman){
        JLabel titleLabel = new JLabel();
        JLabel descriptionLabel = new JLabel();
        JLabel loginLabel = new JLabel();
        JPanel emailContainer = new JPanel();
        JTextField emailField = new JTextField();
        JPanel passwordContainer = new JPanel();
        JPasswordField passwordField = new JPasswordField();
        JPanel loginContainer = new JPanel();
        JButton loginButton = new JButton();

        //======== JPanel ========
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(80, 77, 77));

        //---- titleLabel ----
        titleLabel.setText("ELITEN");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setAlignmentX(0.5F);
        titleLabel.setAlignmentY(0.0F);
        add(titleLabel);

        //---- descriptionLabel ----
        descriptionLabel.setText("Din favorit streamingtjeneste med alle dine yndlingsfilm");
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descriptionLabel.setForeground(Color.white);
        descriptionLabel.setAlignmentY(0.0F);
        descriptionLabel.setAlignmentX(0.5F);
        descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(descriptionLabel);

        //---- loginLabel ----
        loginLabel.setText("Log ind");
        loginLabel.setForeground(Color.white);
        loginLabel.setAlignmentY(0.0F);
        loginLabel.setAlignmentX(0.5F);
        loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loginLabel.setBorder(new EmptyBorder(20, 0, 15, 0));
        add(loginLabel);

        //======== emailContainer ========
        emailContainer.setAlignmentY(0.0F);
        emailContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        emailContainer.setBackground(new Color(240, 240, 240, 0));
        emailContainer.setLayout(new BoxLayout(emailContainer, BoxLayout.Y_AXIS));

        //---- emailField ----
        emailField.setBorder(new TitledBorder(null, "Din email", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        emailField.setSize(new Dimension(200,20));
        emailField.addActionListener(e -> loginButton.doClick());
        emailContainer.add(emailField);

        add(emailContainer);

        //======== passwordContainer ========
        passwordContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        passwordContainer.setBackground(new Color(240, 240, 240, 0));
        passwordContainer.setLayout(new BoxLayout(passwordContainer, BoxLayout.Y_AXIS));

        //---- passwordField ----
        passwordField.setBorder(new TitledBorder(null, "Din adgangskode", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        passwordField.addActionListener(e -> loginButton.doClick());
        passwordContainer.add(passwordField);

        add(passwordContainer);

        //======== loginContainer ========
        loginContainer.setBorder(new EmptyBorder(10, 0, 10, 0));
        loginContainer.setBackground(new Color(255, 255, 255, 0));
        loginContainer.setLayout(new BoxLayout(loginContainer, BoxLayout.Y_AXIS));

        //---- loginButton ----
        loginButton.setText("Log ind");
        loginButton.setAlignmentY(0.0F);
        loginButton.setAlignmentX(0.5F);
        loginButton.setBorder(new EmptyBorder(5, 30, 5, 30));
        loginButton.addActionListener(new LoginUserListener(emailField, passwordField, acc, log, master, meman, fileManager));
        loginContainer.add(loginButton);

        add(loginContainer);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        if (true) {
            Utils.runLater(e -> {
                emailField.setText("deyi@itu.dk");
                passwordField.setText("test123");
                loginButton.doClick();
            }, 1000);
        }
    }
}