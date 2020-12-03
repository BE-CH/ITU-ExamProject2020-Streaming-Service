package com.eliten.eksamen.gui;

import com.eliten.eksamen.User;
import com.eliten.eksamen.media.Media;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MyProfile extends JPanel {

    public MyProfile(User user) {
        super(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.3;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_START;

        //Adding the navigation bar to the page
        add(new NavigationBar(), c);

        //Creating the container for the information
        JPanel container = new JPanel(new GridBagLayout());
        container.setBorder(new EmptyBorder(10,15,0,15));

        //Creating the header
        JPanel headerCon = new JPanel(new GridLayout(2,1));
        JLabel header = new JLabel("Din profil");
        JLabel underHeader = new JLabel("Se de informationer vi har på dig");
        headerCon.add(header);
        headerCon.add(underHeader);
        c.gridy = 0;
        c.gridx = 1;
        c.weighty = 0.25;
        c.weightx = 0.3;
        c.gridheight = 1;
        container.add(headerCon, c);

        //Creating the standard info
        JPanel infoCon = new JPanel(new GridLayout(2,1));
        //has to be changed to use userobjects.
        JLabel name = new JLabel("Navn: " + user.getName());
        JLabel age = new JLabel("Alder: " + user.getAge());
        infoCon.add(name);
        infoCon.add(age);
        c.gridy = 1;
        c.gridx = 1;
        c.ipady = 40;
        container.add(infoCon, c);

        //Creating the movies list
        JPanel movieCon = new JPanel(new GridLayout(2, 1));
        JLabel movieHeader = new JLabel("Film på min liste: ");
        movieCon.add(movieHeader);

        int moviesPerRow = 3;
        double rows = user.getMyList().size()/moviesPerRow;
        if(rows % moviesPerRow != 0){
            rows++;
        }

        JPanel movieList = new JPanel(new GridLayout((int) rows, moviesPerRow));
        for(Media m : user.getMyList()){
            JButton but = new JButton(m.getName());
            movieList.add(but);
        }
        movieCon.add(movieList);
        c.gridy = 2;
        c.weighty = 0.7;
        c.ipady = 10;
        container.add(movieCon, c);

        c.weightx = 4;
        c.gridx = 1;
        c.gridy = 0;
        add(container, c);
    }

}
