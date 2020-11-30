package com.eliten.eksamen.gui;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    public MasterFrame() {
        super("Eliten Swag");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new NavigationBar());
        panel.add(new JPanel());

        add(panel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600, 800);
        setResizable(false);
        setVisible(true);
    }
}
