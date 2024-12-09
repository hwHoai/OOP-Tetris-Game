package controllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicController {
    private MediaPlayer mediaPlayer;
    private double volume;

    public MusicController(double volume) {
        this.volume = volume;
    }

    public void playMusic() {
        Media media = new Media(getClass().getResource("/au/theme.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(volume);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void setVolume(double volume) {
        this.volume = volume;
        mediaPlayer.setVolume(volume);
    }
}
