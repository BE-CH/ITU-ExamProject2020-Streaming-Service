package com.eliten.eksamen.exceptions;

import javax.swing.*;

public class FileManagerLoadException extends RuntimeException {

    public FileManagerLoadException() {
        JOptionPane.showMessageDialog(null, "Media filerne kunne ikke blive læst, og programmet kan derfor ikke virke. Kontakt venligst support.");
    }
}
