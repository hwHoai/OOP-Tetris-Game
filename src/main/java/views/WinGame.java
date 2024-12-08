package views;

import controllers.ViewController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static controllers.WinGameViewController.handleClickNextLevelButton;

public class WinGame {
    public final SimpleIntegerProperty score = new SimpleIntegerProperty(0);

    public static VBox createWinScreen(Stage stage) {
        HBox greenBar = createGreenBar();

        Text titleText = new Text("YOU WIN");
        titleText.setFont(Font.font("Arial", 30));
        titleText.setFill(Color.web("#00FF00"));

        Text scoreText = new Text("Score: " + ""/*score*/);
        scoreText.setFont(Font.font("Arial", 18));
        scoreText.setFill(Color.web("#FFFFFF"));

        Button homeButton = new Button("Home");
        homeButton.setFont(Font.font("Arial", 16));
        homeButton.setTranslateX(-180);
        homeButton.setStyle("-fx-background-color: #00FF00; -fx-text-fill: black; -fx-padding: 5px 20px; -fx-border-color: transparent;\n" +
                "    -fx-border-width: 0;\n" +
                "    -fx-focus-color: transparent;\n" +
                "    -fx-faint-focus-color: transparent;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-cursor: hand;\n" +
                "    -fx-border-radius: 5px;");
        homeButton.setOnAction(e -> {
            try {
                ViewController.getMainView();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        Button nextLevelButton = new Button("Next level");
        nextLevelButton.setFont(Font.font("Arial", 16));
        nextLevelButton.setTranslateX(100);
        nextLevelButton.setStyle("-fx-background-color: #00FF00; -fx-text-fill: black; -fx-padding: 5px 45px; -fx-border-color: transparent;\n" +
                "    -fx-border-width: 0;\n" +
                "    -fx-focus-color: transparent;\n" +
                "    -fx-faint-focus-color: transparent;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-cursor: hand;\n" +
                "    -fx-border-radius: 5px;");
        nextLevelButton.setOnAction(e -> {
            try {
                handleClickNextLevelButton();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });


        HBox buttonRow = new HBox(20);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.getChildren().addAll(nextLevelButton, homeButton);

        VBox layout = new VBox(20, greenBar, titleText, scoreText, buttonRow);
        layout.setPrefWidth(502);
        layout.setPrefHeight(1088);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #0D2E43;");

        return layout;
    }
    private static HBox createGreenBar() {
        HBox greenBar = new HBox(5);
        greenBar.setAlignment(Pos.CENTER);
        greenBar.setRotate(180);
        int[] columnHeights = {2, 4, 3, 5, 2, 4, 5, 3, 2};
         for (int height : columnHeights) {
        greenBar.getChildren().add(createColumn(height));
    }

    return greenBar;
}
    private static VBox createColumn(int height) {
        VBox column = new VBox(2);
        for (int i = 0; i < height; i++) {
            column.getChildren().add(createSquare());
    }
    return column;
}
    private static Rectangle createSquare() {
    Rectangle square = new Rectangle(20, 20);
    square.setFill(Color.web("#00FF00"));
    return square;
}
    public static void display(Stage stage) throws Exception {
        VBox winScreen = createWinScreen(stage);

        stage.setScene(new Scene(winScreen, 502, 1088));
        stage.show();
    }
}
