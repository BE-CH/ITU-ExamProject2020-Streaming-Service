package com.eliten.eksamen.gui;

import com.eliten.eksamen.gui.actionlisteners.UserListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class SelectUserPage extends JPanel{
    public SelectUserPage()  {
        super(new GridLayout(1,1));
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
        header.setFont(new Font("Serif", Font.PLAIN, 60));
        JLabel underHeader = new JLabel("Din favorit streamintjeneste med alle dine yndlingsfil", JLabel.CENTER);

        //adding the labels to the container
        headerCon.add(header);
        headerCon.add(underHeader);

        //Creating the userbuttons container
        JPanel userCon = new JPanel(new GridLayout(1, users.size(), 25, 0));
        userCon.setBorder(new EmptyBorder(0,15,0,15));

        //Creating the buttons --- has to be updated to user objects
        for(String u : users){
            JButton userButton = new JButton(u);
            userButton.addActionListener(new UserListener());
            userCon.add(userButton);
        }

        //adding the containers to the contentpane
        container.add(headerCon);
        container.add(userCon);

        //Creating logoutbutton and setting the size
        JPanel logoutCon = new JPanel(new BorderLayout());
        logoutCon.setBorder(new EmptyBorder(0,600,0,600));
        JButton logOutButton = new JButton("Log ud");
        logOutButton.setPreferredSize(new Dimension(150, 50));

        //adding logoutbutton
        logoutCon.add(logOutButton, BorderLayout.SOUTH);
        container.add(logoutCon);

        add(container);
    }
}
