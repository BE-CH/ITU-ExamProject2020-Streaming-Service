package com.eliten.eksamen;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Eliten");
        frame.setPreferredSize(new Dimension(800,800));
        frame.setLayout(new GridLayout(3,1));

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
        frame.getContentPane().add(headerCon);
        frame.getContentPane().add(userCon);

        //Creating logoutbutton and setting the size
        JButton logOutButton = new JButton("Log ud");
        logOutButton.setPreferredSize(new Dimension(30, 10));

        //adding logoutbutton
        frame.getContentPane().add(logOutButton, BorderLayout.CENTER);


        frame.pack();
        frame.setVisible(true);
    }
}
