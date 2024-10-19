package oopprj.tetrisgame.tetris;

import controllers.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class TetrisLauncher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ViewController.mainView(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}