package com.eliten.eksamen.gui;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;

public class MasterFrame extends JFrame {

    private JPanel MainPanel;
    private HashMap<Integer, JPanel> panels;
    private Font mainFont;

    public MasterFrame() {
        super("Eliten");

        try {
            InputStream mainFontLocation = getClass().getResourceAsStream("/Fonts/Roboto-Regular.ttf");
            mainFont = Font.createFont(Font.TRUETYPE_FONT, mainFontLocation);
            MainPanel = new JPanel(new GridLayout(1,1));

            JPanel selectUserPage = new SelectUserPage();
            JPanel loginPage = new LoginPage();
            JPanel mediaViewerPage = new MediaViewerPage("Dunkirk", "2018", "9.5", false, "Krimi, action & ballade", "movie_images/12 Angry Men.jpg");

            showView(MainPanel, mediaViewerPage);


            //JPanel navigationBar = new NavigationBar();
            //MainPanel.add(navigationBar);

            //MainPanel.add(new JPanel());

            add(MainPanel);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(1600, 800);
            setResizable(false);
            setVisible(true);

        }catch (Exception e){
            System.out.println("Error creating mainFrame: " + e.getMessage());
        }
    }

    public void removeView(JPanel mainPanel, JPanel panelToRemove){

        mainPanel.remove(panelToRemove);
        mainPanel.revalidate();
        mainPanel.repaint();

    }

    public void showView(JPanel mainPanel, JPanel panelToShow){
        mainPanel.add(panelToShow);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void removeAndShow(JPanel mainPanel, JPanel panelToRemove, JPanel panelToShow){
        mainPanel.remove(panelToRemove);
        mainPanel.add(panelToShow);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public JPanel getMainFrame(){
        return MainPanel;
    }

    public Font getMainFont(int style, float size) {
        return mainFont.deriveFont(style, size);

    }
}
