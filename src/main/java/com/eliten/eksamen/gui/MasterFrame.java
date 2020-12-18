package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.managers.ViewManager;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    public MasterFrame(ViewManager viewManager) {
        super("Eliten");

        setIconImage(Eliten.fileManager().getImage("logos/media_logo.png").getImage());
        setLayout(new GridBagLayout());

        LoginPage defaultPage = new LoginPage();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.LINE_START;

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(defaultPage, gbc);

        viewManager.setCurrentPage(defaultPage);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600, 800);
        setResizable(false);
        setVisible(true);
    }
}
