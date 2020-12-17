package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.gui.MediaListPage;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.logging.FileHandler;

public class SearchFieldListener implements DocumentListener {

    private MediaManager mediaManager;
    private MasterFrame masterFrame;
    private FileManager fileManager;
    private AccountManager accountManager;

    public SearchFieldListener(MediaManager mediaManager, MasterFrame masterFrame, FileManager fileManager, AccountManager accountManager){
        this.mediaManager = mediaManager;
        this.masterFrame = masterFrame;
        this.fileManager = fileManager;
        this.accountManager = accountManager;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        handle();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        handle();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        handle();
    }

    private void handle() {
        if (masterFrame.isListPage()) {
            MediaListPage.changeList(mediaManager.getMediasBySearch(masterFrame.getNavigationBar().getSearchFieldText(), masterFrame.getNavigationBar().getGenreFromCategory(), masterFrame.getNavigationBar().getMediaType()), masterFrame, fileManager, accountManager, mediaManager );
        }
    }
}
