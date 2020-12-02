package com.eliten.eksamen.gui;

import com.eliten.eksamen.media.Genre;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NavigationBar extends JPanel {

    public static final Color BACKGROUND_COLOR = new Color(128, 128, 128);

    public NavigationBar() {
        super(new GridLayout(15, 1));

        add(getLabel("ELITEN", 50, SwingConstants.CENTER));

        JLabel subtitle = getLabel("Din streamingtjeneste", 25, SwingConstants.CENTER);
        subtitle.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(subtitle);

        Genre[] allGenres = Genre.values();
        String[] genres = new String[allGenres.length + 1];
        genres[0] = "Kategori...";

        for (int i = 0; i < allGenres.length; i++) {
            genres[i + 1] = allGenres[i].getName();
        }

        JPanel panel = new JPanel(new GridLayout(2, 1));

        JComboBox categories = new JComboBox(genres);
        categories.setPreferredSize(new Dimension(50, 50));
        categories.setBackground(Color.WHITE);
        categories.setFocusable(false);

        JTextField search = new JTextField();
        search.setToolTipText("Search...");

        panel.add(categories);
        panel.add(search);
        add(panel);

        JLabel navigation = getLabel("Navigation", 25, SwingConstants.LEFT);
        navigation.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(navigation);

        for (String navButton : new String[] {"Film", "Serier", "Genre"}) {
            add(new NavigationBarButton(navButton));
        }

        JLabel user = getLabel("Min bruger", 25, SwingConstants.LEFT);
        user.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(user);

        for (String navButton : new String[] {"Min Liste", "Min Profil", "Admin panel", "Log Ud"}) {
            add(new NavigationBarButton(navButton));
        }

        setBackground(BACKGROUND_COLOR);
    }

    private JLabel getLabel(String text, int size, int position) {
        JLabel title = new JLabel(text, position);
        title.setFont(new Font("Serif", Font.PLAIN, size));
        title.setForeground(Color.WHITE);

        return title;
    }
}
