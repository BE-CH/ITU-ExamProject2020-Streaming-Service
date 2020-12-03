package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MediaViewerPage extends JPanel {

    private JPanel topPanels;
    private JPanel imageContainer;
    private JPanel textContainer;
    private JLabel movieTitle;
    private JPanel releaseDateContainer;
    private JLabel releaseDateTitle;
    private JLabel releaseDateValue;
    private JPanel ratingContainer;
    private JLabel ratingTitle;
    private JLabel ratingValue;
    private JPanel forKidsContainer;
    private JLabel forKidsTitle;
    private JLabel forKidsValue;
    private JPanel genresContainer;
    private JLabel genresTitle;
    private JLabel genresValue;
    private JPanel playMovieContainer;
    private JButton playMovieButton;
    private JPanel seasonsBigContainer;
    private JLabel seasonsTitle;
    private JPanel seasonsButtonsContainer;
    private JButton seasonButton;
    private JButton seasonButton2;
    private JButton seasonButton3;
    private JButton seasonButton4;
    private JButton seasonButton5;
    private JButton seasonButton6;
    private JPanel episodesBigContainer;
    private JPanel episodesContainer;
    private JLabel episodesTitle;
    private JLabel watchEpisodeTitle;
    private JPanel singleEpisodeContainer;
    private JLabel singleEpisodeTitle;
    private JButton singleEpisodeWatch;
    private JPanel singleEpisodeContainer2;
    private JLabel singleEpisodeTitle2;
    private JButton singleEpisodeWatch2;
    private JPanel singleEpisodeContainer3;
    private JLabel singleEpisodeTitle3;
    private JButton singleEpisodeWatch3;
    private JLabel movieImage;

    public MediaViewerPage(String _mediaTitle, String _mediaReleaseDate, String _mediaRating, Boolean _forKids, String _mediaGenres, String _mediaImage){
        topPanels = new JPanel();
        imageContainer = new JPanel();
        textContainer = new JPanel();
        movieTitle = new JLabel();
        movieImage = new JLabel();
        releaseDateContainer = new JPanel();
        releaseDateTitle = new JLabel();
        releaseDateValue = new JLabel();
        ratingContainer = new JPanel();
        ratingTitle = new JLabel();
        ratingValue = new JLabel();
        forKidsContainer = new JPanel();
        forKidsTitle = new JLabel();
        forKidsValue = new JLabel();
        genresContainer = new JPanel();
        genresTitle = new JLabel();
        genresValue = new JLabel();
        playMovieContainer = new JPanel();
        playMovieButton = new JButton();
        seasonsBigContainer = new JPanel();
        seasonsTitle = new JLabel();
        seasonsButtonsContainer = new JPanel();
        seasonButton = new JButton();
        seasonButton2 = new JButton();
        seasonButton3 = new JButton();
        seasonButton4 = new JButton();
        seasonButton5 = new JButton();
        seasonButton6 = new JButton();
        episodesBigContainer = new JPanel();
        episodesContainer = new JPanel();
        episodesTitle = new JLabel();
        watchEpisodeTitle = new JLabel();
        singleEpisodeContainer = new JPanel();
        singleEpisodeTitle = new JLabel();
        singleEpisodeWatch = new JButton();
        singleEpisodeContainer2 = new JPanel();
        singleEpisodeTitle2 = new JLabel();
        singleEpisodeWatch2 = new JButton();
        singleEpisodeContainer3 = new JPanel();
        singleEpisodeTitle3 = new JLabel();
        singleEpisodeWatch3 = new JButton();

        //======== JPanel ========
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //======== topPanels ========
        {
            topPanels.setAlignmentY(0.0F);
            topPanels.setAlignmentX(0.0F);
            topPanels.setBorder(new CompoundBorder(
                    new EmptyBorder(5, 5, 5, 5),
                    LineBorder.createBlackLineBorder()));
            topPanels.setLayout(new GridLayout(1, 2, 10, 10));

            //======== imageContainer ========
            {
                imageContainer.setLayout(new BoxLayout(imageContainer, BoxLayout.Y_AXIS));

                // ====== Movie Image =========

                movieImage.setIcon(new ImageIcon(Eliten.fileManager().getImage(_mediaImage).getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT)));
                imageContainer.add(movieImage);
            }
            topPanels.add(imageContainer);

            //======== textContainer ========
            {
                textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.Y_AXIS));

                //---- movieTitle ----
                movieTitle.setText(_mediaTitle);
                movieTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
                movieTitle.setAlignmentY(0.0F);
                movieTitle.setHorizontalAlignment(SwingConstants.LEFT);
                textContainer.add(movieTitle);

                //======== releaseDateContainer ========
                {
                    releaseDateContainer.setAlignmentX(0.0F);
                    releaseDateContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
                    releaseDateContainer.setLayout(new BoxLayout(releaseDateContainer, BoxLayout.X_AXIS));

                    //---- releaseDateTitle ----
                    releaseDateTitle.setText("Udgivelsesdato:");
                    releaseDateTitle.setAlignmentY(0.0F);
                    releaseDateTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
                    releaseDateContainer.add(releaseDateTitle);

                    //---- releaseDateValue ----
                    releaseDateValue.setText(_mediaReleaseDate);
                    releaseDateValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    releaseDateValue.setAlignmentY(0.0F);
                    releaseDateValue.setBorder(new EmptyBorder(0, 5, 0, 0));
                    releaseDateContainer.add(releaseDateValue);
                }
                textContainer.add(releaseDateContainer);

                //======== ratingContainer ========
                {
                    ratingContainer.setAlignmentX(0.0F);
                    ratingContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
                    ratingContainer.setLayout(new BoxLayout(ratingContainer, BoxLayout.X_AXIS));

                    //---- ratingTitle ----
                    ratingTitle.setText("Vurdering:");
                    ratingTitle.setAlignmentY(0.0F);
                    ratingTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
                    ratingContainer.add(ratingTitle);

                    //---- ratingValue ----
                    ratingValue.setText(_mediaRating);
                    ratingValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    ratingValue.setAlignmentY(0.0F);
                    ratingValue.setBorder(new EmptyBorder(0, 5, 0, 0));
                    ratingContainer.add(ratingValue);
                }
                textContainer.add(ratingContainer);

                //======== forKidsContainer ========
                {
                    forKidsContainer.setAlignmentX(0.0F);
                    forKidsContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
                    forKidsContainer.setLayout(new BoxLayout(forKidsContainer, BoxLayout.X_AXIS));

                    //---- forKidsTitle ----
                    forKidsTitle.setText("Egnet til børn:");
                    forKidsTitle.setAlignmentY(0.0F);
                    forKidsTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
                    forKidsContainer.add(forKidsTitle);

                    //---- forKidsValue ----
                    String _isForKidsValue = "Nej";
                    if(_forKids){
                        _isForKidsValue = "Ja";
                    }

                    forKidsValue.setText(_isForKidsValue);
                    forKidsValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    forKidsValue.setAlignmentY(0.0F);
                    forKidsValue.setBorder(new EmptyBorder(0, 5, 0, 0));
                    forKidsContainer.add(forKidsValue);
                }
                textContainer.add(forKidsContainer);

                //======== genresContainer ========
                {
                    genresContainer.setAlignmentX(0.0F);
                    genresContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
                    genresContainer.setLayout(new BoxLayout(genresContainer, BoxLayout.X_AXIS));

                    //---- genresTitle ----
                    genresTitle.setText("Genre(r):");
                    genresTitle.setAlignmentY(0.0F);
                    genresTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
                    genresContainer.add(genresTitle);

                    //---- genresValue ----
                    genresValue.setText(_mediaGenres);
                    genresValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    genresValue.setAlignmentY(0.0F);
                    genresValue.setBorder(new EmptyBorder(0, 5, 0, 0));
                    genresContainer.add(genresValue);
                }
                textContainer.add(genresContainer);

                //======== playMovieContainer ========
                {
                    playMovieContainer.setAlignmentX(0.0F);
                    playMovieContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
                    playMovieContainer.setLayout(new BoxLayout(playMovieContainer, BoxLayout.X_AXIS));

                    //---- playMovieButton ----
                    playMovieButton.setText("Afspil film");
                    playMovieButton.setAlignmentY(0.0F);
                    playMovieButton.setBackground(new Color(16, 170, 22));
                    playMovieButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
                    playMovieButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                    playMovieContainer.add(playMovieButton);
                }
                textContainer.add(playMovieContainer);
            }
            topPanels.add(textContainer);
        }
        add(topPanels);

        //======== seasonsBigContainer ========
        {
            seasonsBigContainer.setAlignmentY(0.0F);
            seasonsBigContainer.setBorder(new CompoundBorder(
                    new EmptyBorder(5, 5, 5, 5),
                    LineBorder.createBlackLineBorder()));
            seasonsBigContainer.setLayout(new BoxLayout(seasonsBigContainer, BoxLayout.Y_AXIS));

            //---- seasonsTitle ----
            seasonsTitle.setText("Sæsoner");
            seasonsTitle.setAlignmentY(0.0F);
            seasonsTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
            seasonsTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
            seasonsBigContainer.add(seasonsTitle);

            //======== seasonsButtonsContainer ========
            {
                seasonsButtonsContainer.setAlignmentY(0.0F);
                seasonsButtonsContainer.setAlignmentX(0.0F);
                seasonsButtonsContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
                seasonsButtonsContainer.setLayout(new GridLayout(1, 7, 5, 0));

                //---- seasonButton ----
                seasonButton.setText("Sæson 1");
                seasonButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
                seasonsButtonsContainer.add(seasonButton);

                //---- seasonButton2 ----
                seasonButton2.setText("Sæson 2");
                seasonButton2.setFont(new Font("Tahoma", Font.PLAIN, 14));
                seasonsButtonsContainer.add(seasonButton2);

                //---- seasonButton3 ----
                seasonButton3.setText("Sæson 3");
                seasonButton3.setFont(new Font("Tahoma", Font.PLAIN, 14));
                seasonsButtonsContainer.add(seasonButton3);

                //---- seasonButton4 ----
                seasonButton4.setText("Sæson 4");
                seasonButton4.setFont(new Font("Tahoma", Font.PLAIN, 14));
                seasonsButtonsContainer.add(seasonButton4);

                //---- seasonButton5 ----
                seasonButton5.setText("Sæson 5");
                seasonButton5.setFont(new Font("Tahoma", Font.PLAIN, 14));
                seasonsButtonsContainer.add(seasonButton5);

                //---- seasonButton6 ----
                seasonButton6.setText("Sæson 6");
                seasonButton6.setFont(new Font("Tahoma", Font.PLAIN, 14));
                seasonsButtonsContainer.add(seasonButton6);
            }
            seasonsBigContainer.add(seasonsButtonsContainer);
        }
        add(seasonsBigContainer);

        //======== episodesBigContainer ========
        {
            episodesBigContainer.setAlignmentX(0.0F);
            episodesBigContainer.setBorder(new CompoundBorder(
                    new EmptyBorder(5, 5, 5, 5),
                    LineBorder.createBlackLineBorder()));
            episodesBigContainer.setLayout(new BoxLayout(episodesBigContainer, BoxLayout.Y_AXIS));

            //======== episodesContainer ========
            {
                episodesContainer.setAlignmentX(0.0F);
                episodesContainer.setAlignmentY(0.0F);
                episodesContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
                episodesContainer.setLayout(new GridLayout(1, 2, 5, 0));

                //---- episodesTitle ----
                episodesTitle.setText("Episoder");
                episodesTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
                episodesTitle.setAlignmentY(0.0F);
                episodesContainer.add(episodesTitle);

                //---- watchEpisodeTitle ----
                watchEpisodeTitle.setText("Se episode");
                watchEpisodeTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
                watchEpisodeTitle.setAlignmentY(0.0F);
                episodesContainer.add(watchEpisodeTitle);
            }
            episodesBigContainer.add(episodesContainer);

            //======== singleEpisodeContainer ========
            {
                singleEpisodeContainer.setAlignmentX(0.0F);
                singleEpisodeContainer.setAlignmentY(0.0F);
                singleEpisodeContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
                singleEpisodeContainer.setLayout(new GridLayout(1, 2, 5, 0));

                //---- singleEpisodeTitle ----
                singleEpisodeTitle.setText("Episode 1");
                singleEpisodeTitle.setAutoscrolls(true);
                singleEpisodeTitle.setAlignmentY(0.0F);
                singleEpisodeContainer.add(singleEpisodeTitle);

                //---- singleEpisodeWatch ----
                singleEpisodeWatch.setText("Se episode");
                singleEpisodeWatch.setAlignmentY(0.0F);
                singleEpisodeWatch.setBackground(new Color(16, 170, 22));
                singleEpisodeWatch.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
                singleEpisodeContainer.add(singleEpisodeWatch);
            }
            episodesBigContainer.add(singleEpisodeContainer);

            //======== singleEpisodeContainer2 ========
            {
                singleEpisodeContainer2.setAlignmentX(0.0F);
                singleEpisodeContainer2.setAlignmentY(0.0F);
                singleEpisodeContainer2.setBorder(new EmptyBorder(5, 5, 5, 5));
                singleEpisodeContainer2.setLayout(new GridLayout(1, 2, 5, 0));

                //---- singleEpisodeTitle2 ----
                singleEpisodeTitle2.setText("Episode 1");
                singleEpisodeTitle2.setAutoscrolls(true);
                singleEpisodeTitle2.setAlignmentY(0.0F);
                singleEpisodeContainer2.add(singleEpisodeTitle2);

                //---- singleEpisodeWatch2 ----
                singleEpisodeWatch2.setText("Se episode");
                singleEpisodeWatch2.setAlignmentY(0.0F);
                singleEpisodeWatch2.setBackground(new Color(16, 170, 22));
                singleEpisodeWatch2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
                singleEpisodeContainer2.add(singleEpisodeWatch2);
            }
            episodesBigContainer.add(singleEpisodeContainer2);

            //======== singleEpisodeContainer3 ========
            {
                singleEpisodeContainer3.setAlignmentX(0.0F);
                singleEpisodeContainer3.setAlignmentY(0.0F);
                singleEpisodeContainer3.setBorder(new EmptyBorder(5, 5, 5, 5));
                singleEpisodeContainer3.setLayout(new GridLayout(1, 2, 5, 0));

                //---- singleEpisodeTitle3 ----
                singleEpisodeTitle3.setText("Episode 1");
                singleEpisodeTitle3.setAutoscrolls(true);
                singleEpisodeTitle3.setAlignmentY(0.0F);
                singleEpisodeContainer3.add(singleEpisodeTitle3);

                //---- singleEpisodeWatch3 ----
                singleEpisodeWatch3.setText("Se episode");
                singleEpisodeWatch3.setAlignmentY(0.0F);
                singleEpisodeWatch3.setBackground(new Color(16, 170, 22));
                singleEpisodeWatch3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
                singleEpisodeContainer3.add(singleEpisodeWatch3);
            }
            episodesBigContainer.add(singleEpisodeContainer3);
        }
        add(episodesBigContainer);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}
