package models.blocks;

import javafx.scene.shape.Rectangle;
import views.PlayView;

public class Block extends Rectangle {

    public static int width = 20;
    public static int height = 20;

    public Block(int x, int y, String color) {
        setTranslateX(x);
        setTranslateY(y);
        setHeight(height-1);
        setWidth(width-1);
        fillProperty().set(javafx.scene.paint.Color.valueOf(color));
    }

    public void moveDown() {
        int nexPos = (int) getTranslateY() + height;
        if(PlayView.board[(int) getTranslateX() / width][nexPos / height] == 0) {
            setTranslateY(nexPos);
        }
    }

    public void moveLeft() {
        int nexPos = (int) getTranslateX() - width;
        if(PlayView.board[ nexPos / width][(int) getTranslateY() / height] == 0) {
            setTranslateX(nexPos);
        }
    }

    public void moveRight() {
        int nexPos = (int) getTranslateX() + width;
        if (PlayView.board[nexPos / width][(int) getTranslateY() / height] == 0) {
            setTranslateX(nexPos);
        }
    }

    public void moveUp() {
        int nexPos = (int) getTranslateY() - height;
        if (PlayView.board[(int) getTranslateX() / width][nexPos / height] == 0) {
            setTranslateY(nexPos);
        }
    }
}
