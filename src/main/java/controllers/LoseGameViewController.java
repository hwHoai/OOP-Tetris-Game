package controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import views.LoseGame;

public class LoseGameViewController {
    public static void view(Stage stage) throws Exception {
        LoseGame.display(stage);
    }

    @FXML
    public static void handleTryAgainButtonClick() throws Exception {
//        Logic here
    }
}
