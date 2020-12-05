package com.eliten.eksamen.gui;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    private NavigationBar navigationBar;
    private JPanel currentPage;

    public MasterFrame() {
        super("Eliten");

        setIconImage(Eliten.fileManager().getImage("logos/media_logo.png").getImage());
        setLayout(new GridBagLayout());

        // create Navigationbar for later use.
        navigationBar = new NavigationBar();

        LoginPage defaultPage = new LoginPage();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.LINE_START;

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(defaultPage, gbc);

        currentPage = defaultPage;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600, 800);
        setResizable(false);
        setVisible(true);
    }

    public void changeView(JPanel newPanel, boolean navBar) {
        getContentPane().removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.LINE_START;

        if(navBar){
            getContentPane().add(navigationBar, gbc);
        }


        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(newPanel, gbc);

        currentPage = newPanel;

        revalidate();
    }

    public boolean isListPage() {
        return currentPage instanceof MediaListPage;
    }

    public JPanel getCurrentPage() {
        return currentPage;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
