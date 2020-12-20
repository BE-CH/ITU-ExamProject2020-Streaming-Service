package com.eliten.eksamen.gui;

import com.eliten.eksamen.Eliten;
import com.eliten.eksamen.account.User;
import com.eliten.eksamen.media.Media;
import com.eliten.eksamen.media.MediaType;
import com.eliten.eksamen.media.Series;
import com.eliten.eksamen.utils.Utils;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class MediaViewerPage extends JPanel {

    public MediaViewerPage(Media media) {
        JPanel topPanels = new JPanel();
        JPanel imageContainer = new JPanel();
        JPanel textContainer = new JPanel();
        JLabel movieTitle = new JLabel();
        JLabel movieImage = new JLabel();
        JPanel releaseDateContainer = new JPanel();
        JLabel releaseDateTitle = new JLabel();
        JLabel releaseDateValue = new JLabel();
        JPanel ratingContainer = new JPanel();
        JLabel ratingTitle = new JLabel();
        JLabel ratingValue = new JLabel();
        JPanel forKidsContainer = new JPanel();
        JLabel forKidsTitle = new JLabel();
        JLabel forKidsValue = new JLabel();
        JPanel genresContainer = new JPanel();
        JLabel genresTitle = new JLabel();
        JLabel genresValue = new JLabel();
        JPanel playMovieContainer = new JPanel();
        JButton playMovieButton = new JButton();
        JPanel seasonsBigContainer = new JPanel();
        JLabel seasonsTitle = new JLabel();
        JPanel seasonsButtonsContainer = new JPanel();
        JPanel episodesBigContainer = new JPanel();
        JPanel singleEpisodesContainer;
        JPanel episodesContainer = new JPanel();
        JLabel episodesTitle = new JLabel();
        JLabel watchEpisodeTitle = new JLabel();
        JScrollPane scrollPaneForEpisodes = new JScrollPane();
        JButton addToList = new JButton();
        AtomicReference<JButton> previous = new AtomicReference<>(new JButton());

        //======== JPanel ========
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //======== topPanels ========
        topPanels.setAlignmentY(0.0F);
        topPanels.setAlignmentX(0.0F);
        topPanels.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), LineBorder.createBlackLineBorder()));
        topPanels.setLayout(new GridLayout(1, 2, 10, 10));

        //======== imageContainer ========
        imageContainer.setLayout(new BoxLayout(imageContainer, BoxLayout.Y_AXIS));

        // ====== Movie Image =========
        if(media.getType() == MediaType.MOVIE){
            movieImage.setIcon(new ImageIcon(media.getImage().getImage().getScaledInstance(600,740, Image.SCALE_DEFAULT)));
        }else{
            movieImage.setIcon(new ImageIcon(media.getImage().getImage().getScaledInstance(600,330, Image.SCALE_DEFAULT)));
        }

        imageContainer.add(movieImage);

        topPanels.add(imageContainer);

        //======== textContainer ========
        textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.Y_AXIS));

        //---- movieTitle ----
        movieTitle.setText(media.getName());
        movieTitle.setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 48F));
        movieTitle.setAlignmentY(0.0F);
        movieTitle.setHorizontalAlignment(SwingConstants.LEFT);
        textContainer.add(movieTitle);

        //======== releaseDateContainer ========
        releaseDateContainer.setAlignmentX(0.0F);
        releaseDateContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
        releaseDateContainer.setLayout(new BoxLayout(releaseDateContainer, BoxLayout.X_AXIS));

        //---- releaseDateTitle ----
        releaseDateTitle.setText("Udgivelsesdato:");
        releaseDateTitle.setAlignmentY(0.0F);
        releaseDateTitle.setFont(Eliten.viewManager().getMainFont(Font.BOLD, 14F));
        releaseDateContainer.add(releaseDateTitle);

        //---- releaseDateValue ----
        releaseDateValue.setText("" + media.getReleaseYear());
        releaseDateValue.setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 14F));
        releaseDateValue.setAlignmentY(0.0F);
        releaseDateValue.setBorder(new EmptyBorder(0, 5, 0, 0));
        releaseDateContainer.add(releaseDateValue);

        textContainer.add(releaseDateContainer);

        //======== ratingContainer ========
        ratingContainer.setAlignmentX(0.0F);
        ratingContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
        ratingContainer.setLayout(new BoxLayout(ratingContainer, BoxLayout.X_AXIS));

        //---- ratingTitle ----
        ratingTitle.setText("Vurdering:");
        ratingTitle.setAlignmentY(0.0F);
        ratingTitle.setFont(Eliten.viewManager().getMainFont(Font.BOLD, 14F));
        ratingContainer.add(ratingTitle);

        //---- ratingValue ----
        ratingValue.setText("" + media.getScore());
        ratingValue.setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 14F));
        ratingValue.setAlignmentY(0.0F);
        ratingValue.setBorder(new EmptyBorder(0, 5, 0, 0));
        ratingContainer.add(ratingValue);

        textContainer.add(ratingContainer);

        //======== forKidsContainer ========
        forKidsContainer.setAlignmentX(0.0F);
        forKidsContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
        forKidsContainer.setLayout(new BoxLayout(forKidsContainer, BoxLayout.X_AXIS));

        //---- forKidsTitle ----
        forKidsTitle.setText("Egnet til børn:");
        forKidsTitle.setAlignmentY(0.0F);
        forKidsTitle.setFont(Eliten.viewManager().getMainFont(Font.BOLD, 14F));
        forKidsContainer.add(forKidsTitle);

        //---- forKidsValue ----
        forKidsValue.setText(media.isForKids() ? "Ja" : "Nej");
        forKidsValue.setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 14F));
        forKidsValue.setAlignmentY(0.0F);
        forKidsValue.setBorder(new EmptyBorder(0, 5, 0, 0));
        forKidsContainer.add(forKidsValue);

        textContainer.add(forKidsContainer);

        //======== genresContainer ========
        genresContainer.setAlignmentX(0.0F);
        genresContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
        genresContainer.setLayout(new BoxLayout(genresContainer, BoxLayout.X_AXIS));

        //---- genresTitle ----
        genresTitle.setText("Genre" + (media.getGenres().size() > 1 ? "r" : "") + ":");
        genresTitle.setAlignmentY(0.0F);
        genresTitle.setFont(Eliten.viewManager().getMainFont(Font.BOLD, 14F));
        genresContainer.add(genresTitle);

        //---- genresValue ----
        genresValue.setText(media.getGenresString());
        genresValue.setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 14F));
        genresValue.setAlignmentY(0.0F);
        genresValue.setBorder(new EmptyBorder(0, 5, 0, 0));
        genresContainer.add(genresValue);

        textContainer.add(genresContainer);

        //======== playMovieContainer ========

        playMovieContainer.setAlignmentX(0.0F);
        playMovieContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
        playMovieContainer.setLayout(new BoxLayout(playMovieContainer, BoxLayout.X_AXIS));

        //---- playMovieButton ----
        playMovieButton.setText("Afspil film");
        playMovieButton.setAlignmentY(0.0F);
        playMovieButton.setBackground(new Color(16, 170, 22));
        playMovieButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
        playMovieButton.setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 20F));

        ActionListener playActionListener = e -> {

            JButton source = (JButton) e.getSource();

            if (source.getText().contains("Afspiller...")) {
                return;
            }

            String beforeMain = playMovieButton.getText();
            Utils.runLater(a -> playMovieButton.setText(beforeMain), 2000);
            playMovieButton.setText("Afspiller... Vent venligst");

            if (!source.equals(playMovieButton)) {
                String beforeSub = source.getText();
                Utils.runLater(a -> source.setText(beforeSub), 2000);
                source.setText("Afspiller...");
            }

            media.watch();
        };

        playMovieButton.addActionListener(playActionListener);
        playMovieContainer.add(playMovieButton);

        textContainer.add(playMovieContainer);

        User user = Eliten.accountManager().getLoggedInAccount().getSelectedUser();

        addToList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                if(!user.getMyList().contains(media)){
                    user.addToList(media);
                    addToList.setText("Fjern til min liste");

                } else {
                    user.removeFromList(media);
                    addToList.setText("Tilføj til min liste");
                }
            }
        });

        addToList.setText((user.getMyList().contains(media) ? "Fjern fra" : "Tilføj til") + " min liste");
        addToList.setAlignmentY(0.0F);
        addToList.setBackground(new Color(16, 170, 22));
        addToList.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
        addToList.setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 20F));
        playMovieContainer.add(addToList);
        textContainer.add(playMovieContainer);

        topPanels.add(textContainer);
        add(topPanels);

        if(media.getType() != MediaType.SERIES) {
            return;
        }

        Series series = (Series) media;
        ArrayList<JPanel> episodePanels = new ArrayList<>();

        if (series.getReleaseYear() != series.getEndYear()) {
            releaseDateValue.setText(series.getReleaseYear() + "-" + series.getEndYear());
        }

        playMovieButton.setText("Afspil fra starten");

        //======== seasonsBigContainer ========
        seasonsBigContainer.setAlignmentY(0.0F);
        seasonsBigContainer.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), LineBorder.createBlackLineBorder()));
        seasonsBigContainer.setLayout(new BoxLayout(seasonsBigContainer, BoxLayout.Y_AXIS));

        //---- seasonsTitle ----
        seasonsTitle.setText("Sæsoner");
        seasonsTitle.setAlignmentY(0.0F);
        seasonsTitle.setFont(Eliten.viewManager().getMainFont(Font.BOLD, 22F));
        seasonsTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
        seasonsBigContainer.add(seasonsTitle);

        //======== seasonsButtonsContainer ========

        seasonsButtonsContainer.setAlignmentY(0.0F);
        seasonsButtonsContainer.setAlignmentX(0.0F);
        seasonsButtonsContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
        seasonsButtonsContainer.setLayout(new GridLayout(1, 7, 5, 0));

        //---- seasonButtons ----
        for (int i = 1; i < series.getSeasons().size() + 1; i++) {

            JButton seasonButton;

            if(series.getSeasons().size() > 7){
                seasonButton = new JButton(String.valueOf(i));
            }else{
                seasonButton = new JButton("Sæson " + i);
            }

            seasonButton.setFont(Eliten.viewManager().getMainFont(Font.PLAIN, 14F));

            int indexCopy = i;

            seasonButton.addActionListener(e -> {
                scrollPaneForEpisodes.setViewportView(episodePanels.get(indexCopy - 1));
                scrollPaneForEpisodes.revalidate();

                seasonButton.setBackground(new Color(16, 170, 22));

                if (previous.get() == seasonButton) {
                    return;
                }

                previous.get().setBackground(new JButton().getBackground());
                previous.get().revalidate();
                previous.set(seasonButton);
            });
            seasonsButtonsContainer.add(seasonButton);
        }

        seasonsBigContainer.add(seasonsButtonsContainer);
        add(seasonsBigContainer);

        //======== episodesBigContainer ========
        episodesBigContainer.setAlignmentX(0.0F);
        episodesBigContainer.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), LineBorder.createBlackLineBorder()));
        episodesBigContainer.setLayout(new BoxLayout(episodesBigContainer, BoxLayout.Y_AXIS));

        //======== episodesContainer ========
        episodesContainer.setAlignmentX(0.0F);
        episodesContainer.setAlignmentY(0.0F);
        episodesContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
        episodesContainer.setLayout(new GridLayout(1, 2, 5, 0));

        //---- episodesTitle ----
        episodesTitle.setText("Episoder");
        episodesTitle.setFont(Eliten.viewManager().getMainFont(Font.BOLD, 14F));
        episodesTitle.setAlignmentY(0.0F);
        episodesContainer.add(episodesTitle);

        //---- watchEpisodeTitle ----
        watchEpisodeTitle.setText("Se episode");
        watchEpisodeTitle.setFont(Eliten.viewManager().getMainFont(Font.BOLD, 14F));
        watchEpisodeTitle.setAlignmentY(0.0F);
        episodesContainer.add(watchEpisodeTitle);

        episodesBigContainer.add(episodesContainer);
        //======== scrollPaneForEpisodes ========


        //======== singleEpisodesContainer ========

        for (int i = 0; i < series.getSeasons().size(); i++) {

            singleEpisodesContainer = new JPanel();
            singleEpisodesContainer.setLayout(new BoxLayout(singleEpisodesContainer, BoxLayout.Y_AXIS));

            //======== singleEpisodeContainer ========

            JPanel singleEpisodeContainer = new JPanel();
            singleEpisodeContainer.setAlignmentX(0.0F);
            singleEpisodeContainer.setAlignmentY(0.0F);
            singleEpisodeContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
            singleEpisodeContainer.setLayout(new GridLayout(series.getEpisodeAmount(i), 2, 5, 0));

            for (int j = 0; j < series.getEpisodeAmount(i); j++) {
                JLabel singleEpisodeTitle = new JLabel();
                JButton singleEpisodeWatch = new JButton();

                //---- singleEpisodeTitle ----
                singleEpisodeTitle.setText("Episode " + (j + 1));
                singleEpisodeTitle.setAutoscrolls(true);
                singleEpisodeTitle.setAlignmentY(0.0F);
                singleEpisodeContainer.add(singleEpisodeTitle);

                //---- singleEpisodeWatch ----
                singleEpisodeWatch.setText("Se episode");
                singleEpisodeWatch.setAlignmentY(0.0F);
                singleEpisodeWatch.setBackground(new Color(16, 170, 22));
                singleEpisodeWatch.addActionListener(playActionListener);
                singleEpisodeWatch.setBorder(new BevelBorder(BevelBorder.RAISED, Color.darkGray, Color.lightGray, Color.gray, Color.black));
                singleEpisodeContainer.add(singleEpisodeWatch);
            }

            singleEpisodesContainer.add(singleEpisodeContainer);
            episodePanels.add(singleEpisodesContainer);
        }

        previous.set((JButton) seasonsButtonsContainer.getComponent(0));
        previous.get().setBackground(new Color(16, 170, 22));

        scrollPaneForEpisodes.setViewportView(episodePanels.get(0));
        episodesBigContainer.add(scrollPaneForEpisodes);
        add(episodesBigContainer);
    }
}
