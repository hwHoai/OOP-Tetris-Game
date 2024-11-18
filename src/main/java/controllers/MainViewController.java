package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import oopprj.tetrisgame.tetris.TetrisLauncher;
import views.MainMenu;

public class MainViewController {
    @FXML
    private Label welcomeText;

    public static void view(Stage stage) throws Exception {
        MainMenu.displayView(stage);
    }

    @FXML
    protected void onHelloButtonClick() throws Exception {
        ViewController.getSettingView();
    }
}
