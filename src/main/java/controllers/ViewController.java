package controllers;

import javafx.stage.Stage;
import views.MainMenu;

public class ViewController {
    public static void mainView(Stage stage) throws Exception {
        MainViewController.view(stage);
    }

    public static void winGameView(Stage stage) throws Exception {
        WinGameViewController.view(stage);
    }

    public static void loseGameView(Stage stage) throws Exception {
        LoseGameViewController.view(stage);
    }
}
