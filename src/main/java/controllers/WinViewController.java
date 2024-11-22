package controllers;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import views.WinView;

import javafx.fxml.FXML;

import javafx.stage.Stage;


public class WinViewController {
    @FXML
    private ImageView tetrisImage;
    public static void view(Stage stage) throws Exception {
        WinView.displayView(stage);
    }

    @FXML
    public void initialize() {
        tetrisImage.setImage(new Image(getClass().getResource("/images/Tetris.png").toExternalForm()));
    }

}
