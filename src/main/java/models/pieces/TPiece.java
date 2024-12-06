package models.pieces;

import javafx.scene.Group;
import models.blocks.Block;
import views.PlayView;

public class TPiece extends Piece {
    public TPiece() {
        super(new Block[]{
        new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 0, "#800080"),
        new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) - Block.width, Block.height, "#800080"),
        new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), Block.height, "#800080"),
        new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) + Block.width, Block.height, "#800080"),

        });
    }

    @Override
    public void rotate() {
        // TODO
    }
}
