package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NavigationBarButton extends JButton {
    
    // private static final ImageIcon icon = new ImageIcon(Eliten.fileManager().getImage("logos/media_logo.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));

    public NavigationBarButton(String text) {
        super(text, new ImageIcon(Eliten.fileManager().getImage("logos/media_logo.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));

        setFont(new Font("Serif", Font.PLAIN, 20));
        setHorizontalAlignment(SwingConstants.LEFT);
        setForeground(Color.WHITE);
        setBorder(new EmptyBorder(0, 10, 0, 0));
        setBackground(new Color(128, 128, 128));
        setContentAreaFilled(false);
    }
}
