package controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import views.StartingMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class StartingViewController {
    @FXML
    private ImageView group62;
    
    @FXML
    private Text text;  // Thêm chú thích @FXML cho trường text

    public static void view(Stage stage) throws Exception {
        StartingMenu.displayView(stage);
    }

    @FXML
    public void initialize() {

        group62.setImage(new Image(getClass().getResource("/images/Group 62.png").toExternalForm()));
        
    }
}
