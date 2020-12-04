package com.eliten.eksamen.gui;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;

public class NavigationBarButtonUI extends MetalButtonUI {

    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        if (b.isContentAreaFilled()) {
            Dimension size = b.getSize();
            g.setColor(NavigationBar.BUTTON_HOVER_COLOR);
            g.fillRect(0, 0, size.width, size.height);
        }
    }
}
