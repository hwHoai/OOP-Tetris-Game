//This class is a controller for setting view
//It will display its screen and handle the user's interaction with the music and sound volume
package controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import oopprj.tetrisgame.tetris.TetrisLauncher;
import utils.BackwardScreen;
import views.SettingMenu;

public class SettingViewController implements BackwardScreen {

    //Define FXML components
    @FXML
    private Slider musicSlider;
    @FXML
    private Slider soundSlider;
    @FXML
    private ImageView backBtnIcon;
    @FXML
    private ImageView musicIcon;

    //------------------------------------------------------------------------------------------------------//

    //Here we will handle the user interaction
    //If the user change the music volume, the music icon will change
    public void onMusicSliderChange(MouseEvent mouseEvent) {
        if(musicSlider.getValue() == 0) {
            musicIcon.setImage(new Image(getClass().getResource("/assets/icon/music-off.png").toExternalForm()));
        } else {
            musicIcon.setImage(new Image(getClass().getResource("/assets/icon/music-setting.png").toExternalForm()));
        }

        TetrisLauncher.setMusicVolume(musicSlider.getValue());
    }

    //If the user click the back button, the view will back to the previous screen

    @Override
    public void backToPrevScreen() throws Exception {
        ViewController.getStage().setScene(ViewController.previousScene);
        ViewController.getStage().show();
    }

    @Override
    public void backToMainScreen() throws Exception {
        // Do nothing
    }

    //------------------------------------------------------------------------------------------------------//

    //Here, the setting view will be displayed
    //This method will display the setting view
    public void view(Stage stage) throws Exception {
        SettingMenu settingMenu = new SettingMenu();
        settingMenu.displayView(stage);
    }

    //This method will initialize the setting view
    @FXML
    public void initialize() {
        backBtnIcon.setImage(new Image(getClass().getResource("/assets/icon/back.png").toExternalForm()));
        musicIcon.setImage(new Image(getClass().getResource("/assets/icon/music-setting.png").toExternalForm()));
    }

    //------------------------------------------------------------------------------------------------------//
    //End.
}
