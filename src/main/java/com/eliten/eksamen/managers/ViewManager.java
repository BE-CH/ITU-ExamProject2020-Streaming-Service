package com.eliten.eksamen.managers;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.gui.MediaListPage;
import com.eliten.eksamen.gui.NavigationBar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    /**
     * Change the current view of the frame to another JPanel
     * @param newPanel the new {@link JPanel} to change to
     * @param navBar whether or not to keep the navigation bar
     */
    public void changeView(@NotNull JPanel newPanel, boolean navBar) {
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

    /**
     * Checks weather or not the current page is a {@link MediaListPage}
     * @return true if the current page is a {@link MediaListPage}
     */
    public boolean isListPage() {
        return currentPage instanceof MediaListPage;
    }

    /**
     * Retrieve the current page that is being viewed
     * @return the current page
     */
    @NotNull
    public JPanel getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets the current page. Note that this does not change the view.
     * @param currentPage the {@link JPanel} to set it to
     */
    public void setCurrentPage(JPanel currentPage) {
        this.currentPage = currentPage;
    }


    /**
     * Retrieve the {@link NavigationBar} if it is enabled
     * @return the navigation bar
     */
    @Nullable
    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    /**
     * Retrieve the main font that is used using the style and size of your choice to have consistency
     * @param style the style of the font
     * @param size the size of the font
     * @return the actual font
     */
    @NotNull
    public Font getMainFont(int style, float size) {
        return mainFont.deriveFont(style, size);
    }
}
