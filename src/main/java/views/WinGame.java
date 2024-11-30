package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class WinGame {
    private static int score = 0;
    public static VBox createWinScreen(Stage stage) {
        Rectangle greenBar = new Rectangle(200, 50);
        greenBar.setFill(Color.web("#00FF00"));

        Text titleText = new Text("YOU WIN");
        titleText.setFont(Font.font("Arial", 30));
        titleText.setFill(Color.web("#00FF00"));

        Text scoreText = new Text("Score: " + score);
        scoreText.setFont(Font.font("Arial", 18));
        scoreText.setFill(Color.web("#FFFFFF"));

        Button nextLevelButton = new Button("Next level");
        nextLevelButton.setFont(Font.font("Arial", 16));
        nextLevelButton.setStyle("-fx-background-color: #00FF00; -fx-text-fill: black;");

        Button homeButton = new Button("Home");
        homeButton.setFont(Font.font("Arial", 16));
        homeButton.setStyle("-fx-background-color: #00FF00; -fx-text-fill: black;");
        homeButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(20, greenBar, titleText, scoreText, nextLevelButton, homeButton);
        layout.setPrefWidth(502);
        layout.setPrefHeight(1088);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #0D2E43;");

        return layout;
    }
    public static void display(Stage stage) throws Exception {
        VBox winScreen = createWinScreen(stage);

        Button nextLevelButton = (Button) winScreen.getChildren().get(3);
        nextLevelButton.setOnAction(e -> stage.setScene(new Scene(winScreen, 502, 1088)));

        stage.setScene(new Scene(winScreen, 502, 1088));
        stage.show();
    }
}
