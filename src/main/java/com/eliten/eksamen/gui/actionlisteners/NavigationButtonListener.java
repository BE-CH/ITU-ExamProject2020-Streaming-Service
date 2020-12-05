package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MyProfile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPage = ((JButton) e.getSource()).getText();

        if(selectedPage.equalsIgnoreCase("Min Liste")){
            // Change to Min Liste
            JOptionPane.showMessageDialog(null, "Skift til Min Liste");
        }else if(selectedPage.equalsIgnoreCase("Min Profil")){
            Eliten.getMasterFrame().changeView(new MyProfile(Eliten.getSelectedUser()), true);
        }else if(selectedPage.equalsIgnoreCase("Admin panel")){
            JOptionPane.showMessageDialog(null, "Skift til Admin Panel");
        }else if(selectedPage.equalsIgnoreCase("Log Ud")){
            Eliten.logOutUser();
        }else{
            JOptionPane.showMessageDialog(null, "Vi kender ikke denne side!");
        }

    }
}
