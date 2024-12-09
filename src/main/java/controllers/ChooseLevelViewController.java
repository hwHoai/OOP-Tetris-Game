package controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import views.ChooseLevelMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChooseLevelViewController {
    @FXML
    private ImageView backArrowIcon;

    public static void view(Stage stage) throws Exception {
        ChooseLevelMenu.displayView(stage);
    }

    @FXML
    public void initialize() {
        backArrowIcon.setImage(new Image(getClass().getResource("/images/arrow_left.png").toExternalForm()));
    }

    @FXML
    public void clickBackBtnHandler() throws Exception {
        ViewController.getMainView();
    }

    @FXML
    public void clickEasyBtnHandler() throws Exception {
        ViewController.getPlayingView("easy");
    }

    @FXML
    public void clickNormalBtnHandler() throws Exception {
        ViewController.getPlayingView("normal");
    }

    @FXML void clickHardBtnHandler() throws Exception {
        ViewController.getPlayingView("hard");
    }

}
