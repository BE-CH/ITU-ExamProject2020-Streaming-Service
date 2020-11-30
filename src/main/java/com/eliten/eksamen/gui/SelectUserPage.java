package com.eliten.eksamen.gui;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectUserPage extends JPanel {

    public SelectUserPage()  {
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(3,1));

        //Users.. Has to be user objects
        ArrayList<String> users = new ArrayList<String>();
        users.add("Mor");
        users.add("Eddy");
        users.add("Far");
        users.add("Barn");

        //For the header with the text
        JPanel headerCon = new JPanel(new GridLayout(2,1));

        //Creating the labels with the center placement
        JLabel header = new JLabel("ELITEN", JLabel.CENTER);
        JLabel underHeader = new JLabel("Din favorit streamintjeneste med alle dine yndlingsfil", JLabel.CENTER);

        //adding the labels to the container
        headerCon.add(header);
        headerCon.add(underHeader);

        //Creating the userbuttons
        JPanel userCon = new JPanel(new GridLayout(1, users.size()));

        //Creating the buttons --- has to be updated to user objects
        for(String u : users){
            JButton userButton = new JButton(u);
            userCon.add(userButton);
        }

        //adding the containers to the contentpane
        container.add(headerCon);
        container.add(userCon);

        //Creating logoutbutton and setting the size
        JButton logOutButton = new JButton("Log ud");
        logOutButton.setPreferredSize(new Dimension(30, 10));
        logOutButton.setMaximumSize(new Dimension(30, 10));

        //adding logoutbutton
        container.add(logOutButton);

    }
}
