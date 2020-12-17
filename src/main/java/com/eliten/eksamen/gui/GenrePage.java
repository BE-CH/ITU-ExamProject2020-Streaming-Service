package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.Account;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import com.eliten.eksamen.media.Genre;

import javax.swing.*;
import java.awt.*;

public class GenrePage extends JPanel {

    private MediaManager mediaManager;
    private FileManager fileManager;
    private AccountManager accountManager;

    public GenrePage(MediaManager mediaManager, MasterFrame masterFrame, FileManager filemanager, AccountManager accountManager) {

        this.mediaManager = mediaManager;

        setLayout(new GridLayout(Genre.values().length  + 1, 3));

        for (String string : new String[] {"Genre", "Beskrivelse", "Find Film"}) {
            JLabel label = getLabel(string, 24, JLabel.CENTER);
            label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            add(label);
        }

        for(Genre genre : Genre.values()) {
            add(getLabel(genre.getName(), 14, JLabel.CENTER));
            add(getLabel(genre.getDescription(), 14, JLabel.CENTER));

            JButton button = new JButton("Vis Film");
            button.setBackground(new Color(16, 170, 22));
            button.addActionListener(e -> MediaListPage.changeList(mediaManager.getMediasBySearch("", genre, null), masterFrame, fileManager, accountManager, mediaManager));
            add(button);
        }
    }

    private JLabel getLabel(String text, int size, int position) {
        JLabel title = new JLabel(text, position);
        title.setFont(new Font("Serif", Font.PLAIN, size));
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));

        return title;
    }
}
