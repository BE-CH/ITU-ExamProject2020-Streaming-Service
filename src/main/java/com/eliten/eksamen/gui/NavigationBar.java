package com.eliten.eksamen.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NavigationBar extends JPanel {

    public NavigationBar() {
        super(new GridLayout(13, 1));

        add(getLabel("ELITEN", 50, SwingConstants.CENTER));
        add(getLabel("Din streamingtjeneste", 25, SwingConstants.CENTER));

        JLabel navigation = getLabel("Navigation", 25, SwingConstants.LEFT);
        navigation.setBorder(new EmptyBorder(0, 10, 0, 0));
        add(navigation);

        for (String navButton : new String[] {"Film", "Serier", "Genre"}) {

            add(new NavigationBarButton(navButton));
        }

        JLabel user = getLabel("Min bruger", 25, SwingConstants.LEFT);
        navigation.setBorder(new EmptyBorder(0, 10, 0, 0));
        add(user);

        for (String navButton : new String[] {"Min liste", "Min profile", "Admin panel", "Log ud"}) {

            add(new NavigationBarButton(navButton));
        }

        setBackground(new Color(128, 128, 128));
    }

    private JLabel getLabel(String text, int size, int position) {
        JLabel title = new JLabel(text, position);
        title.setFont(new Font("Serif", Font.PLAIN, size));
        title.setForeground(Color.WHITE);

        return title;
    }
}
