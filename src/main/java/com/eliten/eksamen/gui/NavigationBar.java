package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.actionlisteners.NavigationButtonListener;
import com.eliten.eksamen.gui.actionlisteners.SearchFieldListener;
import com.eliten.eksamen.media.Genre;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.utils.SortingUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NavigationBar extends JPanel {

    public static final Color BACKGROUND_COLOR = new Color(80, 77, 77);
    public static final Color BUTTON_HOVER_COLOR = Color.decode("#3d3d3d");

    private JComboBox genreSelector;
    private JTextField searchField;
    private MediaType mediaType;

    private SortingStyle currentSortingStyle;
    private SortingStyle nextSortingStyle;

    public NavigationBar() {
        super(new GridLayout(15, 1));

        mediaType = null;
        currentSortingStyle = SortingStyle.DEFAULT;
        nextSortingStyle = SortingStyle.ALPHABETICALLY;

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

        genreSelector = new JComboBox(genres);
        genreSelector.setPreferredSize(new Dimension(50, 50));
        genreSelector.setBackground(Color.WHITE);
        genreSelector.setFocusable(false);
        genreSelector.addActionListener(e -> MediaListPage.changeList(Eliten.mediaManager().getMediasBySearch(searchField.getText(), getGenreFromCategory(), getMediaType())));

        searchField = new JTextField();
        searchField.setToolTipText("Search...");
        searchField.getDocument().addDocumentListener(new SearchFieldListener());

        panel.add(genreSelector);
        panel.add(searchField);
        add(panel);

        JLabel navigation = getLabel("Navigation", 25, SwingConstants.LEFT);
        navigation.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(navigation);

        for (String string : new String[] {"Alle Medier", "Film", "Serier"}) {

            NavigationBarButton button = new NavigationBarButton("Alle medier");
            add(button);
        }

        NavigationBarButton sort = new NavigationBarButton("Sorter \uD83E\uDC46 Alfabetisk");
        sort.addActionListener(e -> {

            ArrayList<Media> list = Eliten.mediaManager().getMediasBySearch(searchField.getText(), getGenreFromCategory(), getMediaType());

            if (nextSortingStyle == SortingStyle.DEFAULT) {
                currentSortingStyle = nextSortingStyle;
                nextSortingStyle = SortingStyle.ALPHABETICALLY;
                Collections.shuffle(list);
            }
            else if (nextSortingStyle == SortingStyle.ALPHABETICALLY) {
                currentSortingStyle = nextSortingStyle;
                nextSortingStyle = SortingStyle.NEWEST;
                SortingUtils.alphabetically(list);
            }
            else if (nextSortingStyle == SortingStyle.NEWEST) {
                currentSortingStyle = nextSortingStyle;
                nextSortingStyle = SortingStyle.RATING;
                SortingUtils.newest(list);
            }
            else if (nextSortingStyle == SortingStyle.RATING) {
                currentSortingStyle = nextSortingStyle;
                nextSortingStyle = SortingStyle.DEFAULT;
                SortingUtils.rating(list);
            }

            sort.setText("Sorter \uD83E\uDC46 " + nextSortingStyle.getName());
            MediaListPage.changeList(list);
        });
        add(sort);

        add(new NavigationBarButton("Genre"));

        JLabel user = getLabel("Min bruger", 25, SwingConstants.LEFT);
        user.setBorder(new EmptyBorder(0, 5, 0, 0));
        add(user);

        String[] stringToLoop;

        if(Eliten.accountManager().getLoggedInAccount().isAdmin()){
            stringToLoop = new String[] {"Min Liste", "Min Profil", "Admin Panel", "Log Ud"};
        }
        else{
            stringToLoop = new String[] {"Min Liste", "Min Profil", "Log Ud"};
        }

        for (String navButton : stringToLoop) {
            NavigationBarButton button = new NavigationBarButton(navButton);
            button.addActionListener(new NavigationButtonListener());
            add(button);
        }

        setBackground(BACKGROUND_COLOR);
    }

    public ArrayList<Media> sort(ArrayList<Media> list) {

        if (currentSortingStyle == SortingStyle.ALPHABETICALLY) {
            SortingUtils.alphabetically(list);
        }
        else if (currentSortingStyle == SortingStyle.NEWEST) {
            SortingUtils.newest(list);
        }
        else if (currentSortingStyle == SortingStyle.RATING) {
            SortingUtils.rating(list);
        }

        return list;
    }

    public String getSearchFieldText() {
        return searchField.getText();
    }

    public Genre getGenreFromCategory() {
        return Genre.fromString((String) genreSelector.getSelectedItem());
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    private JLabel getLabel(String text, int size, int position) {
        JLabel title = new JLabel(text, position);
        title.setFont(new Font("Serif", Font.PLAIN, size));
        title.setForeground(Color.WHITE);

        return title;
    }
}
