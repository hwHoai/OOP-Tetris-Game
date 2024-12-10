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

    public void setMusicVolume(double volume) {
        this.volume = volume;
        if(volume == 0) {
            mediaPlayer.setVolume(0);
        } else {
            mediaPlayer.setVolume(volume);
        }
    }
}
