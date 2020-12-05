package com.eliten.eksamen.gui.actionlisteners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPage = ((JButton) e.getSource()).getText();

        if(selectedPage.equalsIgnoreCase("Min Liste")){
            // Change to Min Liste
        }else if(selectedPage.equalsIgnoreCase("Min Profil")){

        }else if(selectedPage.equalsIgnoreCase("Admin panel")){

        }else if(selectedPage.equalsIgnoreCase("Log Ud")){

        }else{
            JOptionPane.showMessageDialog(null, "Vi kender ikke denne side!");
        }

    }
}
