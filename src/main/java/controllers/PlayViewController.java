package controllers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.pieces.Piece;
import views.PlayView;


public class PlayViewController {

    public void view(Stage stage) throws Exception {
        PlayView playView = new PlayView();
        playView.displayView(stage);
    }

    public static void moveOnKeyPress(Piece piece, Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        piece.moveRight();
                        break;
                    case DOWN:
                        piece.moveDown();
                        break;
                    case LEFT:
                        piece.moveLeft();
                        break;
                    case SPACE:
                    case UP: {
                        piece.rotate();
                        break;
                    }
                }
            }
        });
    }

}
