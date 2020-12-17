package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.managers.FileManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NavigationBarButton extends JButton {

    public NavigationBarButton(String text, Icon icon, MasterFrame masterFrame) {
        super(text, icon);

        setFont(masterFrame.getMainFont(Font.PLAIN, 20F));
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
