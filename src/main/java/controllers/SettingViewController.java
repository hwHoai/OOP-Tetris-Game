package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.BackwardScreen;
import views.SettingMenu;

import java.beans.EventHandler;


public class SettingViewController implements BackwardScreen {
    private Stage stage;
    public Slider musicSlider;
    public Slider soundSlider;
    @FXML
    private ImageView backBtnIcon;
    @FXML
    private ImageView musicIcon;
    @FXML
    private ImageView soundIcon;
//    @FXML
//    private Slider musicSlider;

    public void view(Stage stage) {
            SettingMenu settingMenu = new SettingMenu();
            settingMenu.displayView(stage);
    }

    @FXML
    public void initialize() {
        backBtnIcon.setImage(new Image(getClass().getResource("/assets/icon/back.png").toExternalForm()));
        musicIcon.setImage(new Image(getClass().getResource("/assets/icon/music-setting.png").toExternalForm()));
        soundIcon.setImage(new Image(getClass().getResource("/assets/icon/sound.png").toExternalForm()));
    }


    public void onMusicSliderChange(MouseEvent mouseEvent) {
        if(musicSlider.getValue() == 0) {
            musicIcon.setImage(new Image(getClass().getResource("/assets/icon/music-off.png").toExternalForm()));
        } else {
            musicIcon.setImage(new Image(getClass().getResource("/assets/icon/music-setting.png").toExternalForm()));
        }
    }

    public void onSoundSliderChange(MouseEvent mouseEvent) {
        if(soundSlider.getValue() == 0) {
            soundIcon.setImage(new Image(getClass().getResource("/assets/icon/sound-mute.png").toExternalForm()));
        } else {
            soundIcon.setImage(new Image(getClass().getResource("/assets/icon/sound.png").toExternalForm()));
        }
    }

    @Override
    public void backToMainScreen() throws Exception {
        ViewController.getMainView();
    }
}

