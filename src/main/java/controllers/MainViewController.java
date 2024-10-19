package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import views.MainMenu;

public class MainViewController {
    @FXML
    private Label welcomeText;

    public static void view(Stage stage) throws Exception {
        MainMenu.view(stage);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
