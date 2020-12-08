package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class MasterFrame extends JFrame {

    private NavigationBar navigationBar;
    private JPanel currentPage;
    private Font mainFont;

    public MasterFrame() {
        super("Eliten");

        try {
            InputStream input = Eliten.class.getResourceAsStream("/fonts/Roboto-Regular.ttf");
            mainFont = Font.createFont(Font.TRUETYPE_FONT, input);

            setIconImage(Eliten.fileManager().getImage("logos/media_logo.png").getImage());
            setLayout(new GridBagLayout());

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
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void changeView(JPanel newPanel, boolean navBar) {
        getContentPane().removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.LINE_START;

        if(navBar){

            if(navigationBar == null){
                navigationBar = new NavigationBar();
            }

            getContentPane().add(navigationBar, gbc);
        }
        else {
            navigationBar = null;
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

    public Font getMainFont(int style, float size) {
        return mainFont.deriveFont(style, size);
    }
}
