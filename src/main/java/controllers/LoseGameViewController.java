package controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import views.LoseGame;

public class LoseGameViewController {
    private static String prevLevel;
    public static void view(Stage stage) throws Exception {
        LoseGame.display(stage);
    }

    public static String getPrevLevel() {
        return prevLevel;
    }

    public static void setPrevLevel(String prevLevel) {
        LoseGameViewController.prevLevel = prevLevel;
    }

    @FXML
    public static void handleTryAgainButtonClick() throws Exception {
        ViewController.getPlayingView(prevLevel);
    }
}
