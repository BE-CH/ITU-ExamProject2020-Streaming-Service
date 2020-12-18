package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MediaListPage;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchFieldListener implements DocumentListener {

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
        if (Eliten.viewManager().isListPage()) {
            MediaListPage.changeList(Eliten.mediaManager().getMediasBySearch(Eliten.viewManager().getNavigationBar().getSearchFieldText(), Eliten.viewManager().getNavigationBar().getGenreFromCategory(), Eliten.viewManager().getNavigationBar().getMediaType()));
        }
    }
}
