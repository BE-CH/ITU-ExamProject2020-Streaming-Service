package com.eliten.eksamen.gui.actionlisteners;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.gui.MasterFrame;
import com.eliten.eksamen.gui.MediaByGenrePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Selected user : " + ((JButton) e.getSource()).getText());
        Eliten.setActiveUserIndex(1);
        Eliten.getMasterFrame().changeView(new MediaByGenrePage(), true);
    }
}
