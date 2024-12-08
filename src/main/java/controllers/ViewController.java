package controllers;

import javafx.stage.Stage;
import controllers.PlayingViewController;

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
        ChooseLevelViewController chooseLevelViewController = new ChooseLevelViewController();
        chooseLevelViewController.view(stage);
    }

    public static void getPlayingView() throws Exception {
        PlayingViewController playingViewController = new PlayingViewController();
        playingViewController.view(stage);
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

    public Stage getStage() {
        return stage;
    }
}
