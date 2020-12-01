package com.eliten.eksamen.gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MasterFrame extends JFrame {

    JPanel MainPanel;
    HashMap<Integer, JPanel> panels;

    public MasterFrame() {
        super("Eliten");

        MainPanel = new JPanel(new GridLayout(1,1));

        JPanel selectUserPage = new SelectUserPage();

        showView(MainPanel, selectUserPage);


        //JPanel navigationBar = new NavigationBar();
        //MainPanel.add(navigationBar);

        //MainPanel.add(new JPanel());

        add(MainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600, 800);
        setResizable(false);
        setVisible(true);
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
}
