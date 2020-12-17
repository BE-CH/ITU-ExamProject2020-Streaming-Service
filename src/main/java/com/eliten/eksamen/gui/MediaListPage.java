package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.managers.AccountManager;
import com.eliten.eksamen.managers.FileManager;
import com.eliten.eksamen.managers.MediaManager;
import com.eliten.eksamen.media.Media;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

public class MediaListPage extends JPanel {

    private DefaultTableModel model;
    private JTable table;

    private MasterFrame masterFrame;
    private FileManager fileManager;
    private AccountManager accountManager;
    private MediaManager mediaManager;

    private final int columns = 8;

    public MediaListPage(MasterFrame masterFrame, FileManager fileManager, AccountManager accountManager, MediaManager mediaManager){
        super();
        this.masterFrame = masterFrame;
        this.fileManager = fileManager;
        this.accountManager = accountManager;
        this.mediaManager = mediaManager;
    }

    public static void changeList(ArrayList<Media> medias, MasterFrame masterFrame, FileManager fileManager, AccountManager accountManager, MediaManager mediaManager) {

        MediaListPage page;

        if (!masterFrame.isListPage()) {

            page = new MediaListPage(masterFrame, fileManager, accountManager, mediaManager);
            masterFrame.changeView(page, true);
        } else {
            page = (MediaListPage) masterFrame.getCurrentPage();
        }

        page.update(medias);
    }

    // Made static to decrease load time
    ImageIcon starImage = new ImageIcon(fileManager.getImage("logos/star.png", null).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));

    public void update(ArrayList<Media> medias) {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        JPanel[] labels = new JPanel[columns];

        int count = 0;

        ArrayList<Media> userList = accountManager.getLoggedInAccount().getSelectedUser().getMyList();

        for (Media media : medias) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);

            JLabel label = new JLabel(new ImageIcon(media.getImage().getImage().getScaledInstance(150, 175, Image.SCALE_DEFAULT)));
            label.setText(media.getName());
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);

            if (userList.contains(media)) {
                label.setLayout(new FlowLayout());

                JLabel star = new JLabel(starImage);
                star.setHorizontalTextPosition(JLabel.RIGHT);
                star.setVerticalTextPosition(JLabel.TOP);
                star.setBorder(new EmptyBorder(0, 115, 50, 0));
                label.add(star);
            }

            labels[count] = panel;
            count++;

            panel.add(label);

            if (count == columns) {

                model.addRow(labels);
                labels = new JPanel[columns];
                count = 0;
            }
        }

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

        table.setRowHeight(200);
        table.setShowGrid(false);
        table.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (!SwingUtilities.isLeftMouseButton(e)) {
                    return;
                }

                JPanel panel = getPanelFromMouseEvent(e.getPoint());

                if (panel != null) {
                    JLabel label = (JLabel) panel.getComponent(0);
                    masterFrame.changeView(new MediaViewerPage(mediaManager.getMediaByName(label.getText()), mediaManager, masterFrame, accountManager), true);
                }
            }
        });

        table.addMouseMotionListener(new MouseAdapter() {

            private JPanel previous = null;

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                handle(e.getPoint());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                handle(e.getPoint());
            }

            private void handle(Point point) {
                JPanel panel = getPanelFromMouseEvent(point);

                if (previous == null) {
                    previous = panel;
                    previous.setBackground(Color.LIGHT_GRAY);
                    table.repaint();
                }
                else if (previous != panel) {
                    previous.setBackground(Color.WHITE);
                    previous = panel;
                    panel.setBackground(Color.LIGHT_GRAY);
                    table.repaint();
                }
            }
        });

        add(scrollPane);
    }

    private JPanel getPanelFromMouseEvent(Point point) {

        int row = table.rowAtPoint(point);
        int col = table.columnAtPoint(point);

        return  (JPanel) table.getModel().getValueAt(row, col);
    }

    private JLabel getLabelFromMouseEvent(Point point) {
        JPanel panel = getPanelFromMouseEvent(point);
        return (JLabel) panel.getComponent(0);
    }
}

class CustomRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof JLabel) {
            return (JLabel) value;
        } else if (value instanceof JPanel) {
            return (JPanel) value;
        }

        return cellComponent;
    }
}
