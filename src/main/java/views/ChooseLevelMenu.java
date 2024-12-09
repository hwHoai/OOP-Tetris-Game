package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oopprj.tetrisgame.tetris.TetrisLauncher;

import java.io.IOException;

public class ChooseLevelMenu {
    public static void displayView(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TetrisLauncher.class.getResource("chooseLevel-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
