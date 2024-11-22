package controllers;

import javafx.stage.Stage;
import views.MainMenu;

import javax.swing.text.View;

public class ViewController {
    private static Stage stage;

    public ViewController(Stage stage) {
        ViewController.stage = stage;
    }

    public static void getMainView() throws Exception {
        MainViewController.view(stage);
    }

    public static void getSettingView() throws Exception {
        SettingViewController.view(stage);
    }

    public static void getChooseLevelView() throws Exception {
        ChooseLevelViewController.view(stage);
    }

    public static void getWinView() throws Exception {
        WinViewController.view(stage);
    }

    public static void getGameOverView() throws Exception {
        GameOverViewController.view(stage);
    }

    public void setStage(Stage stage) {
        ViewController.stage = stage;
    }


    public Stage getStage() {
        return stage;
    }
}
