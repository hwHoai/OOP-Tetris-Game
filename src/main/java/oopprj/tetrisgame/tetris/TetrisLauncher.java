package oopprj.tetrisgame.tetris;

import controllers.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class TetrisLauncher extends Application {
    public static double widthScreen = 430.0;
    public static double heightScreen = 932.0;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tetris");;
        stage.setWidth(widthScreen);
        stage.setHeight(heightScreen);

        new ViewController(stage);
        ViewController.getGameOverView();
    }

    public static void main(String[] args) {
        launch();
    }
}