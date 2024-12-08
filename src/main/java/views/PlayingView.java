package views;

import controllers.PlayingViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oopprj.tetrisgame.tetris.TetrisLauncher;

import java.io.IOException;

public class PlayingView {
    public static void displayView(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TetrisLauncher.class.getResource("playing-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            scene.getRoot().requestFocus();
            PlayingViewController controller = fxmlLoader.getController();
            scene.setOnKeyPressed(e -> controller.handleKeyPress(e));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
