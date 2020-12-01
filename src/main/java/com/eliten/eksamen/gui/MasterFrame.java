package com.eliten.eksamen.gui;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    public MasterFrame() {
        super("Eliten Swag");

        JPanel MainPanel = new JPanel(new GridLayout(1, 2));
        JPanel navigationBar = new NavigationBar();
        MainPanel.add(navigationBar);

        MainPanel.add(new JPanel());

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

    public void removeAndShow(JPanel mainPanel, JPanel[] panelToRemove, JPanel[] panelToShow){
        for (JPanel panel :
                panelToRemove) {
            mainPanel.remove(panel);
        }
        for (JPanel panel :
                panelToShow) {
            mainPanel.add(panel);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
