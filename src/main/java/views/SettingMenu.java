package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oopprj.tetrisgame.tetris.TetrisLauncher;

import java.io.IOException;

public class SettingMenu {
    public static void displayView(Stage stage) {
        try {
            // Load fxml
            FXMLLoader fxmlLoader = new FXMLLoader(TetrisLauncher.class.getResource("setting-view.fxml"));

            //Set Scene
            Scene settingView = new Scene(fxmlLoader.load());
            stage.setScene(settingView);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
