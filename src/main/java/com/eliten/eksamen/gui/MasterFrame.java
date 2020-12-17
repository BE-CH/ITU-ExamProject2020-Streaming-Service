package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.logging.Logger;

public class MasterFrame extends JFrame {

    private NavigationBar navigationBar;
    private JPanel currentPage;
    private Font mainFont;
    private FileManager filemanager;
    private Logger logger;
    private AccountManager accountManager;
    private MediaManager mediaManager;

    public MasterFrame() {
        super("vent");
    }

    public MasterFrame(FileManager fileManager, Logger logger, AccountManager accountManager, MediaManager mediaManager) {
        super("Eliten");

        this.filemanager = fileManager;
        this.logger = logger;
        this.accountManager = accountManager;
        this.mediaManager = mediaManager;

        try {
            InputStream input = Eliten.class.getResourceAsStream("/fonts/Roboto-Regular.ttf");
            mainFont = Font.createFont(Font.TRUETYPE_FONT, input);

            setIconImage(filemanager.getImage("logos/media_logo.png", logger).getImage());
            setLayout(new GridBagLayout());

            LoginPage defaultPage = new LoginPage(accountManager, logger, this, mediaManager);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.LINE_START;

            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            getContentPane().add(defaultPage, gbc);

            currentPage = defaultPage;

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(1600, 800);
            setResizable(false);
            setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void changeView(JPanel newPanel, boolean navBar) {
        getContentPane().removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.LINE_START;

        if(navBar){

            if(navigationBar == null){
                navigationBar = new NavigationBar(mediaManager, accountManager, this,  filemanager, logger);
            }

            getContentPane().add(navigationBar, gbc);
        }
        else {
            navigationBar = null;
        }

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(newPanel, gbc);

        currentPage = newPanel;

        revalidate();
    }

    public boolean isListPage() {
        return currentPage instanceof MediaListPage;
    }

    public JPanel getCurrentPage() {
        return currentPage;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public Font getMainFont(int style, float size) {
        return mainFont.deriveFont(style, size);
    }
}
