package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.gui.MediaListPage;
import com.eliten.eksamen.gui.NavigationBar;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class ViewManager {

    private MasterFrame masterFrame;

    private NavigationBar navigationBar;
    private JPanel currentPage;
    private Font mainFont = null;

    public ViewManager() {
        Eliten.getLogger().info("Initialised. Creation of master frame will begin.");

        try {
            mainFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Fonts/Roboto-Regular.ttf")));
        } catch (IOException e) {
            e.printStackTrace();
            Eliten.getLogger().warning("Main font file could not be turned into input stream");
        } catch (FontFormatException e) {
            Eliten.getLogger().warning("Main font could not be created");
        } finally {
            if (mainFont == null) {
                mainFont = new Font("Times New Roman", Font.PLAIN, 12);
            }

            masterFrame = new MasterFrame(this);

            Eliten.getLogger().info("Master frame has been loaded");
        }
    }

    public void changeView(JPanel newPanel, boolean navBar) {
        masterFrame.getContentPane().removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.LINE_START;

        if(navBar) {
            if(navigationBar == null){
                navigationBar = new NavigationBar();
            }

            masterFrame.getContentPane().add(navigationBar, gbc);
        }
        else {
            navigationBar = null;
        }

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        masterFrame.getContentPane().add(newPanel, gbc);

        currentPage = newPanel;

        masterFrame.revalidate();
    }

    public boolean isListPage() {
        return currentPage instanceof MediaListPage;
    }

    public JPanel getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(JPanel currentPage) {
        this.currentPage = currentPage;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public Font getMainFont(int style, float size) {
        return mainFont.deriveFont(style, size);
    }
}
