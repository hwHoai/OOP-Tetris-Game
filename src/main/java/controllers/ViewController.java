package controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import controllers.PlayingViewController;
import models.TetrisGame;

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

    public static void getPlayingView(String level) throws Exception {
        setPreviousScene(stage.getScene());
                PlayingViewController playingViewController = new PlayingViewController();
        switch (level) {
            case "easy":
                TetrisGame.setScorePlus(100);
                playingViewController.view(stage);
                break;
            case "normal":
                TetrisGame.setScorePlus(75);
                playingViewController.view(stage);
                break;
            case "hard":
                TetrisGame.setScorePlus(50);
                playingViewController.view(stage);
                break;
        }
    }

  public static void getWinGameView() throws Exception {
        WinGameViewController.view(stage);
    }

    public static void getLoseGameView() throws Exception {
        LoseGameViewController.view(stage);
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
