package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oopprj.tetrisgame.tetris.TetrisLauncher;

public class GameOverView {
    public static void displayView(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TetrisLauncher.class.getResource("gameOver-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}