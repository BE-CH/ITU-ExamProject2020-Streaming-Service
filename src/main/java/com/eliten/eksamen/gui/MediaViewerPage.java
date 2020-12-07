package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JPanel episodesBigContainer;
    private JPanel episodesContainer;
    private JPanel singleEpisodesContainer;
    private JLabel episodesTitle;
    private JLabel watchEpisodeTitle;
    private JLabel movieImage;
    private JScrollPane scrollPaneForEpisodes;
    private JButton addToList;

    public MediaViewerPage(Media media) {
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
        episodesBigContainer = new JPanel();
        singleEpisodesContainer = new JPanel();
        episodesContainer = new JPanel();
        episodesTitle = new JLabel();
        watchEpisodeTitle = new JLabel();
        scrollPaneForEpisodes = new JScrollPane();
        addToList = new JButton();

        //======== JPanel ========
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //======== topPanels ========
        {
            topPanels.setAlignmentY(0.0F);
            topPanels.setAlignmentX(0.0F);
            topPanels.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), LineBorder.createBlackLineBorder()));
            topPanels.setLayout(new GridLayout(1, 2, 10, 10));

            //======== imageContainer ========
            {
                imageContainer.setLayout(new BoxLayout(imageContainer, BoxLayout.Y_AXIS));

                // ====== Movie Image =========

                movieImage.setIcon(new ImageIcon(media.getImage().getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT)));
                imageContainer.add(movieImage);
            }
            topPanels.add(imageContainer);

            //======== textContainer ========
            {
                textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.Y_AXIS));

                //---- movieTitle ----
                movieTitle.setText(media.getName());
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
                    releaseDateValue.setText("" + media.getReleaseYear());
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
                    ratingValue.setText("" + media.getScore());
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

                    if(media.getIsForKids()){
                        forKidsValue.setText("Ja");
                    }else{
                        forKidsValue.setText("Nej");
                    }
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
                    genresTitle.setText("Genre" + (media.getGenres().size() > 1 ? "r" : "") + ":");
                    genresTitle.setAlignmentY(0.0F);
                    genresTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
                    genresContainer.add(genresTitle);

                    //---- genresValue ----
                    genresValue.setText(media.getGenresString());
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
                    playMovieButton.addActionListener(e -> {
                        if (playMovieButton.getText().contains("Afspiller...")) {
                            return;
                        }
                        playMovieButton.setText("Afspiller... Vent venligst");
                        media.watch();
                        Timer timer = new Timer(2000, e1 -> playMovieButton.setText("Afspil film"));
                        timer.setRepeats(false);
                        timer.start();
                    });
                    playMovieContainer.add(playMovieButton);
                }
                textContainer.add(playMovieContainer);

                if(Eliten.getSelectedUser().getMyList().indexOf(media) == -1){
                    addToList.setText("Tilføj til min liste");
                    addToList.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            Eliten.getSelectedUser().addToList(media);
                            //dont know if this is the best way to do it
                            Eliten.getMasterFrame().changeView(new MediaViewerPage(Eliten.mediaManager().getMediaByName(media.getName())), true);
                        }
                    });
                } else {
                    addToList.setText("Fjern fra min liste");
                    addToList.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            Eliten.getSelectedUser().removeFromList(media);
                            //dont know if this is the best way to do it
                            Eliten.getMasterFrame().changeView(new MediaViewerPage(Eliten.mediaManager().getMediaByName(media.getName())), true);
                        }
                    });
                }
                addToList.setAlignmentY(0.0F);
                addToList.setBackground(new Color(16, 170, 22));
                addToList.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
                addToList.setFont(new Font("Tahoma", Font.PLAIN, 20));
                playMovieContainer.add(addToList);
                textContainer.add(playMovieContainer);
            }
            topPanels.add(textContainer);
        }
        add(topPanels);

        if(media.getType() == MediaType.SERIES){
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

                    //---- seasonButtons ----
                    for (int i = 1; i < 7; i++) {
                        JButton seasonButton = new JButton("Sæson " + i);
                        seasonButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
                        seasonsButtonsContainer.add(seasonButton);
                    }
                }
                seasonsBigContainer.add(seasonsButtonsContainer);
            }
            add(seasonsBigContainer);

            //======== episodesBigContainer ========
            {
                episodesBigContainer.setAlignmentX(0.0F);
                episodesBigContainer.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), LineBorder.createBlackLineBorder()));
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
//======== scrollPaneForEpisodes ========
                {

                    //======== singleEpisodesContainer ========
                    {
                        singleEpisodesContainer.setLayout(new BoxLayout(singleEpisodesContainer, BoxLayout.Y_AXIS));

                        // int test = (Series) media.getEpisodes();

                        for (int i = 0; i < 20; i++) {
                            //======== singleEpisodeContainer ========

                            JPanel singleEpisodeContainer = new JPanel();
                            JLabel singleEpisodeTitle = new JLabel();
                            JButton singleEpisodeWatch = new JButton();
                            int episodeNumber = i+1;

                                singleEpisodeContainer.setAlignmentX(0.0F);
                                singleEpisodeContainer.setAlignmentY(0.0F);
                                singleEpisodeContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
                                singleEpisodeContainer.setLayout(new GridLayout(1, 2, 5, 0));

                                //---- singleEpisodeTitle ----
                                singleEpisodeTitle.setText("Episode " + episodeNumber);
                                singleEpisodeTitle.setAutoscrolls(true);
                                singleEpisodeTitle.setAlignmentY(0.0F);
                                singleEpisodeContainer.add(singleEpisodeTitle);

                                //---- singleEpisodeWatch ----
                                singleEpisodeWatch.setText("Se episode");
                                singleEpisodeWatch.setAlignmentY(0.0F);
                                singleEpisodeWatch.setBackground(new Color(16, 170, 22));
                                singleEpisodeWatch.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
                                singleEpisodeContainer.add(singleEpisodeWatch);
                            singleEpisodesContainer.add(singleEpisodeContainer);
                        }
                    }
                    scrollPaneForEpisodes.setViewportView(singleEpisodesContainer);
                }
                episodesBigContainer.add(scrollPaneForEpisodes);
            }
            add(episodesBigContainer);
        }
    }

}
