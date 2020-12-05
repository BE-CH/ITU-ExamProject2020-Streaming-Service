package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MediaListPage;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchFieldListener implements DocumentListener {

    public JTextField field;

    public SearchFieldListener(JTextField field) {
        this.field = field;
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
        if (Eliten.getMasterFrame().isListPage()) {
            MediaListPage.changeList(Eliten.mediaManager().getMediasBySearch(field.getText(), Eliten.getMasterFrame().getNavigationBar().getGenreFromCategory(), Eliten.getMasterFrame().getNavigationBar().getMediaType()));
        }
    }
}
