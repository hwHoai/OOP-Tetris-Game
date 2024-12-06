package models.pieces;

import models.blocks.Block;
import utils.PieceActions;
import views.PlayView;

public abstract class Piece implements PieceActions {
    private final int blockSize = 20;
    private final int[][] board = PlayView.board;
    private final int width = PlayView.COLS * blockSize;
    private final int height = PlayView.ROWS * blockSize;
    private Block[] blocks;
    private int form = 0;

    public Piece(Block[] blocks) {
        this.blocks = blocks;
    }

    public boolean isBottomCollided() {
        for (int i = 0; i < 4; i++) {
            if (blocks[i].getTranslateY() + blockSize > height - blockSize) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveDown() {
        if (!isBottomCollided()) {
            int moveBlock1 = board[(int) blocks[0].getTranslateX() / blockSize][(int) blocks[0].getTranslateY() / blockSize + 1];
            int moveBlock2 = board[(int) blocks[1].getTranslateX() / blockSize][(int) blocks[1].getTranslateY() / blockSize + 1];
            int moveBlock3 = board[(int) blocks[2].getTranslateX() / blockSize][(int) blocks[2].getTranslateY() / blockSize + 1];
            int moveBlock4 = board[(int) blocks[3].getTranslateX() / blockSize][(int) blocks[3].getTranslateY() / blockSize + 1];
            return moveBlock1 == 0 && moveBlock1 == moveBlock2 && moveBlock2 == moveBlock3 && moveBlock3 == moveBlock4;
        }
        return false;
    }

    @Override
    public void moveDown() {
        if (canMoveDown()) {
            for (int i = 0; i < 4; i++) {
                blocks[i].setTranslateY(blocks[i].getTranslateY() + blockSize);
            }
        }
    }

    public boolean isLeftCollided() {
        for (int i = 0; i < 4; i++) {
            if (blocks[i].getTranslateX() - blockSize < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveLeft() {
        if (!isLeftCollided()) {
            int moveBlock1 = board[(int) blocks[0].getTranslateX() / blockSize - 1][(int) blocks[0].getTranslateY() / blockSize];
            int moveBlock2 = board[(int) blocks[1].getTranslateX() / blockSize - 1][(int) blocks[1].getTranslateY() / blockSize];
            int moveBlock3 = board[(int) blocks[2].getTranslateX() / blockSize - 1][(int) blocks[2].getTranslateY() / blockSize];
            int moveBlock4 = board[(int) blocks[3].getTranslateX() / blockSize - 1][(int) blocks[3].getTranslateY() / blockSize];
            return moveBlock1 == 0 && moveBlock1 == moveBlock2 && moveBlock2 == moveBlock3 && moveBlock3 == moveBlock4;
        }
        return false;
    }

    @Override
    public void moveLeft() {
        if (canMoveLeft()) {
            for (int i = 0; i < 4; i++) {
                blocks[i].setTranslateX(blocks[i].getTranslateX() - blockSize);
            }
        }
    }

    public boolean isRightCollided() {
        for (int i = 0; i < 4; i++) {
            if (blocks[i].getTranslateX() + blockSize > width - blockSize) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveRight() {
        if (!isRightCollided()) {
            int moveBlock1 = board[(int) blocks[0].getTranslateX() / blockSize + 1][(int) blocks[0].getTranslateY() / blockSize];
            int moveBlock2 = board[(int) blocks[1].getTranslateX() / blockSize + 1][(int) blocks[1].getTranslateY() / blockSize];
            int moveBlock3 = board[(int) blocks[2].getTranslateX() / blockSize + 1][(int) blocks[2].getTranslateY() / blockSize];
            int moveBlock4 = board[(int) blocks[3].getTranslateX() / blockSize + 1][(int) blocks[3].getTranslateY() / blockSize];
            return moveBlock1 == 0 && moveBlock1 == moveBlock2 && moveBlock2 == moveBlock3 && moveBlock3 == moveBlock4;
        }
        return false;
    }

    @Override
    public void moveRight() {
        if (canMoveRight()) {
            for (int i = 0; i < 4; i++) {
                blocks[i].setTranslateX(blocks[i].getTranslateX() + blockSize);
            }

        }
    }

    //------------------------------------------------------------------------------------------//

    // Getter and Setter

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[] blocks) {
        this.blocks = blocks;
    }
}
