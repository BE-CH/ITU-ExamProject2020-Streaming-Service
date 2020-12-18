package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NavigationBarButton extends JButton {

    private static final ImageIcon icon = new ImageIcon(Eliten.fileManager().getImage("logos/media_logo.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));

    public NavigationBarButton(String text) {
        super(text, icon);

        setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 20F));
        setBorder(new EmptyBorder(0, 10, 0, 0));

        setHorizontalAlignment(SwingConstants.LEFT);
        setForeground(Color.WHITE);
        setBackground(NavigationBar.BACKGROUND_COLOR);

        setUI(new NavigationBarButtonUI());

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(NavigationBar.BUTTON_HOVER_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(NavigationBar.BACKGROUND_COLOR);
            }
        });
    }
}
