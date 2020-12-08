package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.User;
import com.eliten.eksamen.media.Media;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyProfile extends JPanel {

    private JLabel label1;
    private JLabel label2;
    private JPanel bigInfoContainer;
    private JPanel singleContainer;
    private JLabel textContainer;
    private JLabel valueContainer;
    private JPanel singleContainer2;
    private JLabel textContainer2;
    private JLabel valueContainer2;
    private JPanel mediaContainer;
    private JLabel myListLabel;
    private JScrollPane scrollPane;

    public MyProfile(User user) {

        label1 = new JLabel();
        label2 = new JLabel();
        bigInfoContainer = new JPanel();
        singleContainer = new JPanel();
        textContainer = new JLabel();
        valueContainer = new JLabel();
        singleContainer2 = new JPanel();
        textContainer2 = new JLabel();
        valueContainer2 = new JLabel();
        mediaContainer = new JPanel();
        myListLabel = new JLabel();
        scrollPane = new JScrollPane();

        scrollPane.setAlignmentX(0.0F);
        scrollPane.setAlignmentY(0.0F);

        //======== JPanel ========
        setAlignmentY(0.0F);
        setAlignmentX(0.0F);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //---- label1 ----
        label1.setText("Min profil");
        label1.setFont(Eliten.getMasterFrame().getMainFont(Font.PLAIN, 25F));
        label1.setAlignmentY(0.0F);
        add(label1);

        //---- label2 ----
        label2.setText("Se de informationer vi har på dig");
        label2.setFont(Eliten.getMasterFrame().getMainFont(Font.PLAIN, 16F));
        label2.setAlignmentY(0.0F);
        add(label2);

        //======== bigInfoContainer ========
        {
            bigInfoContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
            bigInfoContainer.setLayout(new BoxLayout(bigInfoContainer, BoxLayout.Y_AXIS));

            //======== singleContainer ========
            {
                singleContainer.setAlignmentY(0.0F);
                singleContainer.setAlignmentX(0.0F);
                singleContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
                singleContainer.setLayout(new BoxLayout(singleContainer, BoxLayout.X_AXIS));

                //---- textContainer ----
                textContainer.setText("Navn: ");
                textContainer.setAlignmentY(0.0F);
                textContainer.setFont(Eliten.getMasterFrame().getMainFont(Font.BOLD, 16F));
                singleContainer.add(textContainer);

                //---- valueContainer ----
                valueContainer.setText("Mor");
                valueContainer.setAlignmentY(0.0F);
                valueContainer.setFont(Eliten.getMasterFrame().getMainFont(Font.PLAIN, 16F));
                singleContainer.add(valueContainer);
            }
            bigInfoContainer.add(singleContainer);

            //======== singleContainer2 ========
            {
                singleContainer2.setAlignmentY(0.0F);
                singleContainer2.setAlignmentX(0.0F);
                singleContainer2.setBorder(new EmptyBorder(5, 0, 5, 0));
                singleContainer2.setLayout(new BoxLayout(singleContainer2, BoxLayout.X_AXIS));

                //---- textContainer2 ----
                textContainer2.setText("Alder: ");
                textContainer2.setAlignmentY(0.0F);
                textContainer2.setFont(Eliten.getMasterFrame().getMainFont(Font.BOLD, 16F));
                singleContainer2.add(textContainer2);

                //---- valueContainer2 ----
                valueContainer2.setText("45");
                valueContainer2.setAlignmentY(0.0F);
                valueContainer2.setFont(Eliten.getMasterFrame().getMainFont(Font.PLAIN, 16F));
                singleContainer2.add(valueContainer2);
            }
            bigInfoContainer.add(singleContainer2);

            //---- label5 ----
            myListLabel.setText("Min liste");
            myListLabel.setAlignmentY(0F);
            myListLabel.setAlignmentX(0F);
            myListLabel.setFont(Eliten.getMasterFrame().getMainFont(Font.PLAIN, 20F));
            myListLabel.setBorder(new EmptyBorder(15, 0, 5, 0));
            bigInfoContainer.add(myListLabel);
        }
        add(bigInfoContainer);


        //======== mediaContainer ========
        {
            mediaContainer.setAlignmentY(0.0F);
            mediaContainer.setAlignmentX(0.0F);
            mediaContainer.setLayout(new BoxLayout(mediaContainer, BoxLayout.Y_AXIS));
            

            double amountOfRows = Math.ceil(Float.valueOf(user.getMyList().size()) / 5);
            for (int i = 0; i < amountOfRows; i++) {
                JPanel singleMediaContainer = new JPanel();
                singleMediaContainer.setBorder(new LineBorder(Color.BLACK, 1));
                singleMediaContainer.setAlignmentX(0F);
                singleMediaContainer.setAlignmentY(0F);
                singleMediaContainer.setLayout(new GridLayout(0, 5));

                if(user.getMyList().size() >= 5*(i+1)){
                    for (int j = 5*i; j < 5*(i+1); j++) {
                        Media media = user.getMyList().get(j);
                        singleMediaContainer.add(createVideoLabel(media));
                    }
                }else{
                    for (int j = 5*i; j < user.getMyList().size(); j++) {
                        Media media = user.getMyList().get(j);
                        singleMediaContainer.add(createVideoLabel(media));
                    }
                }


                mediaContainer.add(singleMediaContainer);
            }

            scrollPane.setViewportView(mediaContainer);
        }

        add(scrollPane);
    }


    public JLabel createVideoLabel(Media media){
        JLabel label = new JLabel(new ImageIcon(media.getImage().getImage().getScaledInstance(150, 125, Image.SCALE_DEFAULT)));
        label.setAlignmentX(0F);
        label.setAlignmentY(0F);
        label.setBorder(new EmptyBorder(10,5,10,5));
        label.setText(media.getName());
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Eliten.getMasterFrame().changeView(new MediaViewerPage(Eliten.mediaManager().getMediaByName(media.getName())), true);
            }
        });

        return label;
    }

}