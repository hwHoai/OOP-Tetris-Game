package oopprj.tetrisgame.tetris;

import com.almasb.fxgl.core.View;
import controllers.MusicController;
import controllers.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class TetrisLauncher extends Application {
    public static double widthScreen =430 ;
    public static double heightScreen =930 ;
    private static MusicController musicController;
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Tetris");
        stage.setWidth(widthScreen);
        stage.setHeight(heightScreen);

        new ViewController(stage);

        ViewController.getMainView();
        musicController = new MusicController(0.5);
        musicController.playMusic();
    }

    public static void setMusicVolume(double volume) {
        musicController.setMusicVolume(volume);
    }

    public static void main(String[] args) {
        launch();
    }
}
