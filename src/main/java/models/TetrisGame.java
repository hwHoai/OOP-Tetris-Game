package models;
import controllers.LoseGameViewController;
import controllers.PlayingViewController;
import controllers.ViewController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static controllers.PlayingViewController.getGameLoop;

public class TetrisGame {
    private final int width, height;
    private final Color[][] grid; // Sử dụng mảng màu thay vì mảng số
    private Tetrimino currentTetrimino;
    private final GraphicsContext gc;
    private static int score;
    private static int scorePlus;

    public TetrisGame(int width, int height, GraphicsContext gc) {
        this.width = width;
        this.height = height;
        this.grid = new Color[height][width]; // Khởi tạo mảng màu
        this.gc = gc;
        this.score = 0;
    }

    public Tetrimino createRandomTetrimino() {
        int type = (int) (Math.random() * Tetrimino.SHAPES.length);
        return new Tetrimino(type, width / 2 - 1, 0); // Đặt tọa độ bắt đầu


    }

    public Tetrimino getCurrentTetrimino() {
        return currentTetrimino;
    }

    public void setCurrentTetrimino(Tetrimino tetrimino) {
        this.currentTetrimino = tetrimino;
    }

    private boolean canMoveTo(int[][] blocks) {
        for (int[] block : blocks) {
            int x = block[0], y = block[1];
            if (x < 0 || x >= width || y >= height || (y >= 0 && grid[y][x] != null)) {
                return false; // Nếu ô đã có màu, không thể di chuyển đến
            }
        }
        return true;
    }

    public boolean moveTetrimino(int dx, int dy) {
        currentTetrimino.move(dx, dy);
        if (!canMoveTo(currentTetrimino.getBlocks())) {
            currentTetrimino.move(-dx, -dy);
            return false;
        }
        return true;
    }

    public void rotateTetrimino() {
        currentTetrimino.rotate();
        // Nếu xoay bị va chạm, thử dịch chuyển khối để bù trừ
        if (!canMoveTo(currentTetrimino.getBlocks())) {
            for (int dx = -1; dx <= 1; dx++) { // Thử các dịch chuyển nhỏ
                currentTetrimino.move(dx, 0);
                if (canMoveTo(currentTetrimino.getBlocks())) {
                    return; // Nếu thành công, kết thúc
                }
                currentTetrimino.move(-dx, 0); // Khôi phục vị trí ban đầu
            }
            currentTetrimino.rotateBack(); // Không xoay được thì khôi phục
        }
    }

    public void lockTetrimino() throws Exception {
        for (int[] block : currentTetrimino.getBlocks()) {
            int x = block[0], y = block[1];
            if (y >= 0) grid[y][x] = currentTetrimino.getColor(); // Lưu màu sắc vào grid
        }

        // Nếu hang đầu tiên có màu, kết thúc trò chơi
        for(Color col : grid[0]) {
            if(col != null) {
                PlayingViewController.getGameLoop().stop();
                switch (scorePlus) {
                    case 100:
                        LoseGameViewController.setPrevLevel("easy");
                        break;
                    case 75:
                        LoseGameViewController.setPrevLevel("normal");
                        break;
                    case 50:
                        LoseGameViewController.setPrevLevel("hard");
                        break;
                }
                ViewController.getLoseGameView();
            }
        }
        clearFullRows();
    }

    private void clearFullRows() throws Exception {
        for (int y = 0; y < height; y++) {
            boolean isFull = true;
            for (int x = 0; x < width; x++) {
                if (grid[y][x] == null) { // Kiểm tra ô trống
                    isFull = false;
                    break;
                }
            }
            if (isFull) {
                clearRow(y);
                score += scorePlus; // Thêm điểm cho mỗi hàng
                if(score >= 3000) {
                    PlayingViewController.getGameLoop().stop();
                    ViewController.getWinGameView();
                }
            }
        }
    }

    private void clearRow(int row) {
        for (int y = row; y > 0; y--) {
            System.arraycopy(grid[y - 1], 0, grid[y], 0, width);
        }
        // Làm trống hàng đầu tiên
        for (int x = 0; x < width; x++) {
            grid[0][x] = null;
        }
    }

    public static int getScore() {
        return TetrisGame.score;
    }

    public void render() {
        gc.clearRect(0, 0, width * 30, height * 30);
        gc.setFill(Color.web("#0D2E43"));
        gc.fillRect(0, 0, width * 30, height * 30);

        // Vẽ lưới
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x] != null) { // Nếu có màu, vẽ ô đó
                    gc.setFill(grid[y][x]);

                    gc.fillRect(x * 30 - 1 , y * 30 - 1, 30 - 1, 30 - 1);
                }
            }
        }

        // Vẽ Tetrimino hiện tại
        gc.setFill(currentTetrimino.getColor());
        for (int[] block : currentTetrimino.getBlocks()) {
            gc.fillRect((block[0] * 30) - 1, (block[1] * 30) -1, 30 - 1, 30 - 1);
        }
    }

    public int getScorePlus() {
        return scorePlus;
    }

    public static void setScorePlus(int scorePlus) {
        TetrisGame.scorePlus = scorePlus;
    }
}
