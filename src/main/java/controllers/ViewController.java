package controllers;

import javafx.stage.Stage;

public class ViewController {
    private static Stage stage;

    public ViewController(Stage stage) {
        ViewController.stage = stage;
    }

    public static void getMainView() throws Exception {
        MainViewController.view(stage);
    }

    public static void getSettingView() throws Exception {
        SettingViewController settingViewController = new SettingViewController();
        settingViewController.view(stage);
    }

    public static void getChooseLevelView() throws Exception {
        ChooseLevelViewController.view(stage);
    }

    public static void getPlayView() throws Exception {
        PlayViewController playViewController = new PlayViewController();
        playViewController.view(stage);
    }

    public void setStage(Stage stage) {
        ViewController.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}
