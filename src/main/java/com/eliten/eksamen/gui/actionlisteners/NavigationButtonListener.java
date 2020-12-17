package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.*;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import com.eliten.eksamen.media.MediaType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NavigationButtonListener implements ActionListener {

    private MasterFrame masterFrame;
    private FileManager filemanager;
    private AccountManager accountManager;
    private MediaManager mediaManager;

    public NavigationButtonListener(MasterFrame masterFrame, FileManager filemanager, AccountManager accountManager, MediaManager mediaManager){
        this.masterFrame = masterFrame;
        this.filemanager = filemanager;
        this.accountManager = accountManager;
        this.mediaManager = mediaManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPage = ((JButton) e.getSource()).getText();

        NavigationBar navigationBar = masterFrame.getNavigationBar();

        switch (selectedPage) {
            case "Alle Medier", "Film", "Serier" -> {
                navigationBar.setMediaType(selectedPage.equalsIgnoreCase("Alle Medier") ? null : selectedPage.equalsIgnoreCase("Film") ? MediaType.MOVIE : MediaType.SERIES);
                MediaListPage.changeList(mediaManager.getMediasBySearch(navigationBar.getSearchFieldText(), navigationBar.getGenreFromCategory(), navigationBar.getMediaType()), masterFrame, filemanager, accountManager, mediaManager);
            }
            case "Genre" -> masterFrame.changeView(new GenrePage(mediaManager, masterFrame, filemanager, accountManager), true);
            case "Min Profil" -> masterFrame.changeView(new MyProfile(accountManager.getLoggedInAccount().getSelectedUser(), masterFrame, mediaManager, accountManager), true);
            case "Admin Panel" -> JOptionPane.showMessageDialog(null, "TODO: Skift til Admin Panel");
            case "Log Ud" -> accountManager.logout();
            default -> JOptionPane.showMessageDialog(null, "Vi kender ikke denne side!");
        }
    }
}
