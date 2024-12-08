package controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.Tetrimino;
import models.TetrisGame;
import views.PlayingView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.BackwardScreen;

import java.util.LinkedList;
import java.util.List;

public class PlayingViewController implements BackwardScreen {
    @FXML
    private Canvas gameCanvas;
    @FXML
    private ImageView homeIcon;
    @FXML
    private ImageView settingIcon;
    @FXML
    private ImageView clear30Lines;

    @FXML
    private ImageView reloadIcon;
    @FXML
    private ImageView actionIcon;
    private final Image pauseIcon = new Image(getClass().getResourceAsStream("/images/pause.png"));
    private final Image continueIcon = new Image(getClass().getResourceAsStream("/images/continue.png"));
    @FXML
    private Label scoreLabel;

    @FXML
    private Canvas currentPlayCanvas;
    @FXML
    private Canvas nextCanvas1;
    @FXML
    private Canvas nextCanvas2;
    @FXML
    private Canvas nextCanvas3;

    private TetrisGame tetrisGame;
    private static AnimationTimer gameLoop;
    private List<Tetrimino> nextTetriminos = new LinkedList<>();

    private boolean isPaused = false;


    public static void view(Stage stage) throws Exception {
        PlayingView.displayView(stage);
    }

    @Override
    public void backToMainScreen() throws Exception {
        ViewController.getMainView();
    }

    @Override
    public void backToPrevScreen() throws Exception {
        // Do nothing
    }

    @FXML
    public void initialize() {
        homeIcon.setImage(new Image(getClass().getResource("/images/home.png").toExternalForm()));
        settingIcon.setImage(new Image(getClass().getResource("/images/setting.png").toExternalForm()));
        clear30Lines.setImage(new Image(getClass().getResource("/images/clear30Lines.png").toExternalForm()));

        reloadIcon.setImage(new Image(getClass().getResource("/images/reload.png").toExternalForm()));
        actionIcon.setImage(pauseIcon);
        tetrisGame = new TetrisGame(13, 20, gameCanvas.getGraphicsContext2D());
        // Initialize next tetriminos
        for (int i = 0; i < 3; i++) {
            nextTetriminos.add(tetrisGame.createRandomTetrimino());
        }

        // Đặt khối đầu tiên vào Current Play
        tetrisGame.setCurrentTetrimino(nextTetriminos.remove(0));
        nextTetriminos.add(tetrisGame.createRandomTetrimino());



        gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 500_000_000) {
                    if (!tetrisGame.moveTetrimino(0, 1)) {
                        try {
                            lockAndSpawnTetrimino();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    tetrisGame.render();
                    lastUpdate = now;
                }
            }
        };
//        gameCanvas.setFocusTraversable(true);
        gameCanvas.requestFocus();// Đảm bảo canvas nhận sự kiện phím
        gameLoop.start();
        renderNextTetriminos();
        renderCurrentPlay();
//        gameCanvas.setOnKeyPressed(event -> handleKeyPress(event));
    }



    private void lockAndSpawnTetrimino() throws Exception {
        tetrisGame.lockTetrimino();
        scoreLabel.setText(String.valueOf(tetrisGame.getScore()));

        // Chuyển khối đầu tiên trong danh sách Next sang Current Play
        tetrisGame.setCurrentTetrimino(nextTetriminos.remove(0));
        // Thêm khối mới vào danh sách Next
        nextTetriminos.add(tetrisGame.createRandomTetrimino());

        // Cập nhật lại giao diện
        renderNextTetriminos();
        renderCurrentPlay();
    }

    private void renderNextTetriminos() {
        GraphicsContext[] nextCanvases = {
                nextCanvas1.getGraphicsContext2D(),
                nextCanvas2.getGraphicsContext2D(),
                nextCanvas3.getGraphicsContext2D()
        };

        // Xóa các canvas trước đó
        for (GraphicsContext gc : nextCanvases) {
            gc.clearRect(0, 0, nextCanvas1.getWidth(), nextCanvas1.getHeight());
        }

        // Vẽ các khối tiếp theo trong danh sách Next
        for (int i = 0; i < nextTetriminos.size() && i < 3; i++) {
            drawTetrimino(nextTetriminos.get(i), nextCanvases[i], 16, 16);
        }
    }

    private void renderCurrentPlay() {
        GraphicsContext gc = currentPlayCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, currentPlayCanvas.getWidth(), currentPlayCanvas.getHeight());
        if (tetrisGame.getCurrentTetrimino() != null) {
            drawTetrimino(tetrisGame.getCurrentTetrimino(), gc, 16, 16);
        }
    }

    private void drawTetrimino(Tetrimino tetrimino, GraphicsContext gc, double offsetX, double offsetY) {
        gc.clearRect(0, 0, currentPlayCanvas.getWidth(), currentPlayCanvas.getHeight());
        gc.setFill(tetrimino.getColor());
        for (int[] block : tetrimino.getRelativeBlocks()) {
            gc.fillRect((block[0] * 10 + offsetX) - 1, (block[1] * 10 + offsetY) - 1, 10 - 1, 10 - 1);
        }
    }




    public void handleToggleActionIcon() {
        isPaused = !isPaused;

        if (isPaused) {
            gameLoop.stop();
            actionIcon.setImage(continueIcon);
        } else {
            gameLoop.start();
            actionIcon.setImage(pauseIcon);
        }
    }


    @FXML
    public void handleKeyPress(KeyEvent event) {
        System.out.println("Key pressed: " + event.getCode());
        if (isPaused) return;

        switch (event.getCode()) {
            case LEFT -> tetrisGame.moveTetrimino(-1, 0);
            case RIGHT -> tetrisGame.moveTetrimino(1, 0);
            case DOWN -> tetrisGame.moveTetrimino(0, 1);
            case UP -> tetrisGame.rotateTetrimino();
        }
        tetrisGame.render();
    }


    @FXML
    public void handleReloadGame() {
        gameLoop.stop();

        tetrisGame = new TetrisGame(13, 20, gameCanvas.getGraphicsContext2D());
        scoreLabel.setText("0");

        nextTetriminos.clear();
        for (int i = 0; i < 3; i++) {
            nextTetriminos.add(tetrisGame.createRandomTetrimino());
        }

        tetrisGame.setCurrentTetrimino(nextTetriminos.remove(0));

        nextTetriminos.add(tetrisGame.createRandomTetrimino());

        renderCurrentPlay();
        renderNextTetriminos();
        actionIcon.setImage(pauseIcon);
        gameLoop.start();
    }

    public void openSettingView() throws Exception {
        ViewController.setPreviousScene(ViewController.getStage().getScene());
        ViewController.getSettingView();
    }

    public static AnimationTimer getGameLoop() {
        return gameLoop;
    }

}
