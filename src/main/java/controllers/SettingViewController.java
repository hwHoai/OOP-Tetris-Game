package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import views.SettingMenu;


public class SettingViewController {
    @FXML
    private ImageView backBtnIcon;
    @FXML
    private ImageView musicIcon;
    @FXML
    private ImageView soundIcon;
    @FXML
    private Label tittle;

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
}
