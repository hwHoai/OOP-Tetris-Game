package controllers;

import javafx.stage.Stage;

public class ViewController {
    private static Stage stage;

    public ViewController(Stage stage) {
        ViewController.stage = stage;
    }

    public static void getStartingView() throws Exception {
        StartingViewController.view(stage);
    }

    public static void getSettingView() throws Exception {
        SettingViewController.view(stage);
    }

    public static void getChooseLevelView() throws Exception {
        ChooseLevelViewController.view(stage);
    }

    public void setStage(Stage stage) {
        ViewController.stage = stage;
    }


    public Stage getStage() {
        return stage;
    }
}
