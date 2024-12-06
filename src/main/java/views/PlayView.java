package views;

import controllers.PlayViewController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.blocks.Block;
import models.pieces.*;
import oopprj.tetrisgame.tetris.TetrisLauncher;

import java.util.Timer;
import java.util.TimerTask;

public class PlayView extends VBox {
    public static final int ROWS = 39;
    public static final int COLS = 11;
    public static int[][] board = new int[COLS][ROWS];
    private GridPane root;
    private Piece currentPiece;
    private boolean isRunning;
    private int isReachTop = 0;

    public void displayView(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TetrisLauncher.class.getResource("play-view.fxml"));
        GridPane root = fxmlLoader.load();
        root.setPrefSize(COLS * 20, ROWS * 20);
        setRoot(root);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        currentPiece = createPiece();
        isRunning = true;
        fallPieceDown();

    }

    public Piece createPiece() {
        Piece newPiece = null;
        switch (randomPiece()) {
            case 0: {
                newPiece = new TPiece();
                break;
            }
            case 1: {
                newPiece = new LPiece();
                break;
            }
            case 2: {
                newPiece = new ZPiece();
                break;
            }
            case 3: {
                newPiece = new IPiece();
                break;
            }
            case 4: {
                newPiece = new OPiece();
                break;
            }
            case 5: {
                newPiece = new JPiece();
                break;
            }
            case 6: {
                newPiece = new SPiece();
                break;
            }
        }
        this.getRoot().getChildren().addAll(newPiece.getBlocks());
        PlayViewController.moveOnKeyPress(newPiece, this.getRoot().getScene());
        return newPiece;
    }

    public void fallPieceDown() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        if (currentPiece.getBlocks()[0].getTranslateY() == 0 ||
                                currentPiece.getBlocks()[1].getTranslateY() == 0 ||
                                currentPiece.getBlocks()[2].getTranslateY() == 0 ||
                                currentPiece.getBlocks()[3].getTranslateY() == 0) {
                            isReachTop++;
                        } else {
                            isReachTop = 0;
                        }

                        if (isReachTop == 2) {
                            isRunning = false;
                            timer.cancel();
                        }

                        if (isReachTop >= 15) {
                            System.exit(0);
                        }

                        if (isRunning) {
                            if (!currentPiece.canMoveDown()) {
                                for (int i = 0; i < 4; i++) {
                                    board[(int) currentPiece.getBlocks()[i].getTranslateX() / Block.width][(int) currentPiece.getBlocks()[i].getTranslateY() / Block.height] = 1;
                                }

                                currentPiece = createPiece();
                            }
                            currentPiece.moveDown();
                        }
                    }
                });
            }
        };
        timer.schedule(task, 0, 500);

    }

    public void runningGame() {

    }


    public int randomPiece() {
        return (int) (Math.random() * 7);
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        PlayView.board = board;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

}
