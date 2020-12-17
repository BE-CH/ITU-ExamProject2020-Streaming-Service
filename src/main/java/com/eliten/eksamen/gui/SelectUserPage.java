package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.User;
import com.eliten.eksamen.gui.actionlisteners.UserListener;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class SelectUserPage extends JPanel{

    private AccountManager accountManager;
    private FileManager fileManager;

    public SelectUserPage(ArrayList<User> users, AccountManager accountManager, Logger logger, MasterFrame masterFrame, MediaManager mediaManager, FileManager filemanager)  {
        super(new GridLayout(1,1));
        this.fileManager = fileManager;
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(3,1));

        //For the header with the text
        JPanel headerCon = new JPanel(new GridLayout(2,1));
        headerCon.setBackground(new Color(128, 128, 128));

        //Creating the labels with the center placement
        JLabel header = new JLabel("ELITEN", JLabel.CENTER);
        header.setFont(new Font("Serif", Font.PLAIN, 60));
        JLabel underHeader = new JLabel("Din favorit streamintjeneste med alle dine yndlingsfil", JLabel.CENTER);

        //adding the labels to the container
        headerCon.add(header);
        headerCon.add(underHeader);

        //Creating the userbuttons container
        JPanel userCon = new JPanel(new GridLayout(1, users.size(), 25, 0));
        userCon.setBorder(new EmptyBorder(0,15,0,15));
        userCon.setBackground(new Color(128, 128, 128));

        //Creating the buttons --- has to be updated to user objects
        for(User user : users){
            JButton userButton = new JButton(user.getName());
            userButton.addActionListener(new UserListener(accountManager, logger, masterFrame, mediaManager, fileManager));
            userCon.add(userButton);
        }

        //adding the containers to the contentpane
        container.add(headerCon);
        container.add(userCon);

        //Creating logoutbutton and setting the size
        JPanel logoutCon = new JPanel(new BorderLayout());
        logoutCon.setBorder(new EmptyBorder(0,600,0,600));
        logoutCon.setBackground(new Color(128, 128, 128));

        JButton logOutButton = new JButton("Log ud");
        logOutButton.setPreferredSize(new Dimension(150, 50));
        logOutButton.addActionListener(e -> accountManager.logout());

        //adding logoutbutton
        logoutCon.add(logOutButton, BorderLayout.SOUTH);
        container.add(logoutCon);

        add(container);
    }
}
