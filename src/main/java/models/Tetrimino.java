package models;

import javafx.scene.paint.Color;

public class Tetrimino {
    private final int[][][] rotations; // Tất cả các trạng thái xoay của khối
    private int rotationState;        // Trạng thái xoay hiện tại
    private int posX, posY;           // Vị trí của khối trên lưới
    private final Color color;        // Màu sắc của khối

    // Các màu mặc định cho các loại khối
    public static final Color[] COLORS = {
            Color.web("#00FFFF"), Color.web("#488BD4"), Color.web("#00FF00"), Color.web("#FF7F00"), Color.web("#FFFF00"), Color.web("#C200C2"), Color.web("#D41E3C")
    };

    // Định nghĩa các khối (tất cả các trạng thái xoay)
    public static final int[][][][] SHAPES = {
            { // I
                    {{0, 1}, {1, 1}, {2, 1}, {3, 1}}, // 0°
                    {{1, 0}, {1, 1}, {1, 2}, {1, 3}}, // 90°
                    {{0, 1}, {1, 1}, {2, 1}, {3, 1}}, // 180°
                    {{1, 0}, {1, 1}, {1, 2}, {1, 3}}  // 270°
            },
            { // J
                    {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, // 0°
                    {{1, 0}, {2, 0}, {1, 1}, {1, 2}}, // 90°
                    {{0, 1}, {1, 1}, {2, 1}, {2, 2}}, // 180°
                    {{1, 0}, {1, 1}, {0, 2}, {1, 2}}  // 270°
            },
            { // L
                    {{2, 0}, {0, 1}, {1, 1}, {2, 1}}, // 0°
                    {{1, 0}, {1, 1}, {1, 2}, {2, 2}}, // 90°
                    {{0, 1}, {1, 1}, {2, 1}, {0, 2}}, // 180°
                    {{0, 0}, {1, 0}, {1, 1}, {1, 2}}  // 270°
            },
            { // O
                    {{0, 0}, {1, 0}, {0, 1}, {1, 1}}, // Không cần xoay
                    {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                    {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                    {{0, 0}, {1, 0}, {0, 1}, {1, 1}}
            },
            { // S
                    {{1, 0}, {2, 0}, {0, 1}, {1, 1}}, // 0°
                    {{1, 0}, {1, 1}, {2, 1}, {2, 2}}, // 90°
                    {{1, 1}, {2, 1}, {0, 2}, {1, 2}}, // 180°
                    {{0, 0}, {0, 1}, {1, 1}, {1, 2}}  // 270°
            },
            { // T
                    {{1, 0}, {0, 1}, {1, 1}, {2, 1}}, // 0°
                    {{1, 0}, {1, 1}, {2, 1}, {1, 2}}, // 90°
                    {{0, 1}, {1, 1}, {2, 1}, {1, 2}}, // 180°
                    {{1, 0}, {0, 1}, {1, 1}, {1, 2}}  // 270°
            },
            { // Z
                    {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // 0°
                    {{1, 0}, {0, 1}, {1, 1}, {0, 2}}, // 90°
                    {{0, 1}, {1, 1}, {1, 2}, {2, 2}}, // 180°
                    {{2, 0}, {1, 1}, {2, 1}, {1, 2}}  // 270°
            }
    };

    public Tetrimino(int type, int x, int y) {
        this.rotations = SHAPES[type];
        this.rotationState = 0; // Trạng thái xoay ban đầu
        this.posX = x;
        this.posY = y;
        this.color = COLORS[type];
    }

    // Lấy vị trí các khối theo trạng thái xoay hiện tại
    public int[][] getBlocks() {
        int[][] relativeBlocks = rotations[rotationState];
        int[][] absoluteBlocks = new int[relativeBlocks.length][2];
        for (int i = 0; i < relativeBlocks.length; i++) {
            absoluteBlocks[i][0] = relativeBlocks[i][0] + posX;
            absoluteBlocks[i][1] = relativeBlocks[i][1] + posY;
        }
        return absoluteBlocks;
    }

    public int[][] getRelativeBlocks() {
        return rotations[rotationState];
    }

    public Color getColor() {
        return color;
    }

    public void move(int dx, int dy) {
        posX += dx;
        posY += dy;
    }

    public void rotate() {
        rotationState = (rotationState + 1) % rotations.length;
    }

    public void rotateBack() {
        rotationState = (rotationState - 1 + rotations.length) % rotations.length;
    }
}