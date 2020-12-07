package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.GenrePage;
import com.eliten.eksamen.gui.MediaListPage;
import com.eliten.eksamen.gui.MyProfile;
import com.eliten.eksamen.gui.NavigationBar;
import com.eliten.eksamen.media.MediaType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPage = ((JButton) e.getSource()).getText();

        NavigationBar navigationBar = Eliten.getMasterFrame().getNavigationBar();

        switch (selectedPage) {
            case "Alle Medier", "Film", "Serier" -> {
                navigationBar.setMediaType(selectedPage.equalsIgnoreCase("Alle Medier") ? null : selectedPage.equalsIgnoreCase("Film") ? MediaType.MOVIE : MediaType.SERIES);
                MediaListPage.changeList(Eliten.mediaManager().getMediasBySearch(navigationBar.getSearchFieldText(), navigationBar.getGenreFromCategory(), navigationBar.getMediaType()));
            }
            case "Genre" -> Eliten.getMasterFrame().changeView(new GenrePage(), true);
            case "Min Liste" -> JOptionPane.showMessageDialog(null, "TODO: Skift til Min Liste");
            case "Min Profil" -> Eliten.getMasterFrame().changeView(new MyProfile(Eliten.accountManager().getLoggedInAccount().getSelectedUser()), true);
            case "Admin Panel" -> JOptionPane.showMessageDialog(null, "TODO: Skift til Admin Panel");
            case "Log Ud" -> Eliten.accountManager().logout();
            default -> JOptionPane.showMessageDialog(null, "Vi kender ikke denne side!");
        }
    }
}
