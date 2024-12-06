package controllers;

import java.lang.classfile.Label;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import views.MainMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MainViewController {
    @FXML
    private ImageView startingImage;

    @FXML
    private Text text;

    @FXML
    private Label continueText;

    public static void view(Stage stage) throws Exception {
        MainMenu.displayView(stage);
    }

    @FXML
    public void initialize() {

        startingImage.setImage(new Image(getClass().getResource("/images/startingImage.png").toExternalForm()));
    }

    @FXML
        public void onNewGameButtonClick() throws Exception {
            ViewController.getChooseLevelView();
        }

        public void onSettingButtonClick() throws Exception {
            ViewController.getSettingView();
        }
}
