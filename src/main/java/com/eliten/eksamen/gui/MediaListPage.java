package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.media.Media;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MediaListPage extends JPanel {

    private DefaultTableModel model;
    private JTable table;

    private final int columns = 8;

    public static void changeList(ArrayList<Media> medias) {

        MediaListPage page;

        if (!Eliten.getMasterFrame().isListPage()) {

            page = new MediaListPage();
            Eliten.getMasterFrame().changeView(page);
        } else {
            page = (MediaListPage) Eliten.getMasterFrame().getCurrentPage();
        }

        page.update(medias);
    }

    public void update(ArrayList<Media> medias) {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        JLabel[] labels = new JLabel[columns];
        int count = 0;

        for (Media media : medias) {
            JLabel label = new JLabel(new ImageIcon(media.getImage().getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
            label.setText(media.getName());
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);

            labels[count] = label;
            count++;

            if (count == columns) {
                model.addRow(labels);
                labels = new JLabel[columns];
                count = 0;
            }
        }

        // Add rest
        if (count != 0) {
            model.addRow(labels);
        }
    }

    public MediaListPage() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setDefaultRenderer(JLabel.class, new CustomRenderer());

        // Add columns
        for (int i = 0; i < columns; i++) {
            model.addColumn(i);
        }

        CustomRenderer renderer = new CustomRenderer();
        for (int i = 0; i < columns; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        table.setRowHeight(175);
        table.setShowGrid(false);
        table.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());

                JLabel label = (JLabel) table.getModel().getValueAt(row, col);

                if (label != null) {
                    Eliten.getMasterFrame().changeView(new MediaViewerPage(Eliten.mediaManager().getMediaByName(label.getText())));
                }
            }
        });

        add(scrollPane);
    }
}

class CustomRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof JLabel) {
            return (JLabel) value;
        }
        return cellComponent;
    }
}
