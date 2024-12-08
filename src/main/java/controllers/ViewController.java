package controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import controllers.PlayingViewController;

public class ViewController {
    public static Scene previousScene;

    private static Stage stage;

    public ViewController(Stage stage) {
        ViewController.stage = stage;
    }

    public static void getMainView() throws Exception {
        MainViewController.view(stage);
    }

    public static void getSettingView() throws Exception {
        setPreviousScene(stage.getScene());
        SettingViewController settingViewController = new SettingViewController();
        settingViewController.view(stage);
    }

    public static void getChooseLevelView() throws Exception {
        setPreviousScene(stage.getScene());
        ChooseLevelViewController chooseLevelViewController = new ChooseLevelViewController();
        chooseLevelViewController.view(stage);
    }

    public static void getPlayingView() throws Exception {
        setPreviousScene(stage.getScene());
        PlayingViewController playingViewController = new PlayingViewController();
        playingViewController.view(stage);
    }


    public void setStage(Stage stage) {
        ViewController.stage = stage;
    }


    public static Stage getStage() {
        return stage;
    }

    public Scene getPreviousScene() {
        return previousScene;
    }

    public static void setPreviousScene(Scene previousScene) {
        ViewController.previousScene = previousScene;
    }
}
