package com.eliten.eksamen.gui;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    private NavigationBar navigationBar;

    public MasterFrame() {
        super("Eliten");

        setLayout(new GridBagLayout());

        navigationBar = new NavigationBar();

        MediaByGenrePage defaultPage = new MediaByGenrePage();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.LINE_START;

        getContentPane().add(navigationBar, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(defaultPage, gbc);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600, 800);
        setResizable(false);
        setVisible(true);
    }

    public void changeView(JPanel newPanel) {
        System.out.println("hit");

        getContentPane().removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.LINE_START;

        getContentPane().add(navigationBar, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(newPanel, gbc);

        revalidate();
    }
}
