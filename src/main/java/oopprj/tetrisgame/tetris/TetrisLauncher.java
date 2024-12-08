package oopprj.tetrisgame.tetris;

import com.almasb.fxgl.core.View;
import controllers.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class TetrisLauncher extends Application {
    public static double widthScreen = 430;
    public static double heightScreen = Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50 ;
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Tetris");
        stage.setWidth(widthScreen);
        stage.setHeight(heightScreen);

        new ViewController(stage);

        ViewController.getMainView();
    }

    public static void main(String[] args) {
        launch();
    }
}
