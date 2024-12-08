import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameInterface {

    private int score = 0;

    public void start(Stage primaryStage) {
        VBox winScreen = createWinScreen(primaryStage);
        VBox gameOverScreen = createGameOverScreen(primaryStage);

        Button nextLevelButton = (Button) winScreen.getChildren().get(3);
        nextLevelButton.setOnAction(e -> primaryStage.setScene(new Scene(gameOverScreen, 502, 1088)));

        Button tryAgainButton = (Button) gameOverScreen.getChildren().get(3);
        tryAgainButton.setOnAction(e -> primaryStage.setScene(new Scene(winScreen, 502, 1088)));

        primaryStage.setScene(new Scene(winScreen, 502, 1088));
        primaryStage.setTitle("Game Interface");
        primaryStage.show();
    }

    private VBox createWinScreen(Stage stage) {
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

    private VBox createGameOverScreen(Stage stage) {
        Rectangle greenBar = new Rectangle(200, 50);
        greenBar.setFill(Color.web("#00FF00"));

        Text titleText = new Text("GAME OVER!");
        titleText.setFont(Font.font("Arial", 30));
        titleText.setFill(Color.web("#00FF00"));

        Text scoreText = new Text("Score: " + score);
        scoreText.setFont(Font.font("Arial", 18));
        scoreText.setFill(Color.web("#FFFFFF"));

        Button tryAgainButton = new Button("Again");
        tryAgainButton.setFont(Font.font("Arial", 16));
        tryAgainButton.setStyle("-fx-background-color: #00FF00; -fx-text-fill: black;");

        Button homeButton = new Button("Home");
        homeButton.setFont(Font.font("Arial", 16));
        homeButton.setStyle("-fx-background-color: #00FF00; -fx-text-fill: black;");
        homeButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(20, greenBar, titleText, scoreText, tryAgainButton, homeButton);
        layout.setPrefWidth(502);
        layout.setPrefHeight(1088);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #0D2E43;");

        return layout;
    }

    public static void main(String[] args) {
        Application.launch(GameLauncher.class, args);
    }
}

class GameLauncher extends Application {
    @Override
    public void start(Stage primaryStage) {
        GameInterface gameInterface = new GameInterface();
        gameInterface.start(primaryStage);
    }
}
