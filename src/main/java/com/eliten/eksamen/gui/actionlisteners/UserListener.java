package com.eliten.eksamen.gui.actionlisteners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Selected user : " + ((JButton) e.getSource()).getText());
        // Eliten.getMasterFrame().removeAndShow(Eliten.getMasterFrame().getMainFrame(), (JPanel)Eliten.getMasterFrame().getMainFrame().getComponent(0), new NavigationBar());
    }
}
