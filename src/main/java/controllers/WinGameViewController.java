package controllers;

import javafx.stage.Stage;
import views.WinGame;

public class WinGameViewController {
    public static void view(Stage stage) throws Exception {
        WinGame.display(stage);
    }

    public static void handleClickNextLevelButton() throws Exception {
        ViewController.getChooseLevelView();
    }
}
