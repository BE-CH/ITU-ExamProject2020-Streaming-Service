package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.actionlisteners.SearchFieldListener;
import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.MediaType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

public class NavigationBar extends JPanel {

    public static final Color BACKGROUND_COLOR = new Color(128, 128, 128);

    public NavigationBar() {
        super(new GridLayout(15, 1));

        add(getLabel("ELITEN", 50, SwingConstants.CENTER));

        JLabel subtitle = getLabel("Din streamingtjeneste", 25, SwingConstants.CENTER);
        subtitle.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(subtitle);

        JPanel panel = new JPanel(new GridLayout(2, 1));

        Genre[] allGenres = Genre.values();
        Arrays.sort(allGenres);

        String[] genres = new String[allGenres.length + 1];
        genres[0] = "Kategori...";

        for (int i = 0; i < allGenres.length; i++) {
            genres[i + 1] = allGenres[i].getName();
        }

        JComboBox categories = new JComboBox(genres);
        categories.setPreferredSize(new Dimension(50, 50));
        categories.setBackground(Color.WHITE);
        categories.setFocusable(false);
        categories.addActionListener(e -> {

            String selected = (String) categories.getSelectedItem();

            if (selected.equalsIgnoreCase("Kategori...")) {
                MediaListPage.changeList(Eliten.mediaManager().getMedias());
            }
            else {
                MediaListPage.changeList(Eliten.mediaManager().getMediasByGenre(Genre.fromString(selected)));
            }

        });

        JTextField search = new JTextField();
        search.setToolTipText("Search...");
        search.getDocument().addDocumentListener(new SearchFieldListener(search));

        panel.add(categories);
        panel.add(search);
        add(panel);

        JLabel navigation = getLabel("Navigation", 25, SwingConstants.LEFT);
        navigation.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(navigation);

        NavigationBarButton medias = new NavigationBarButton("Alle medier");
        medias.addActionListener(e -> MediaListPage.changeList(Eliten.mediaManager().getMedias()));
        add(medias);

        NavigationBarButton movie = new NavigationBarButton("Film");
        movie.addActionListener(e -> MediaListPage.changeList(Eliten.mediaManager().getMediasByType(MediaType.MOVIE)));
        add(movie);

        NavigationBarButton series = new NavigationBarButton("Serier");
        series.addActionListener(e -> MediaListPage.changeList(Eliten.mediaManager().getMediasByType(MediaType.SERIES)));
        add(series);

        NavigationBarButton genre = new NavigationBarButton("Genre");
        genre.addActionListener(e -> System.out.println("missing!!"));
        add(genre);

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
