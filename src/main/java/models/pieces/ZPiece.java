package models.pieces;

import models.blocks.Block;
import views.PlayView;

public class ZPiece extends Piece{

    public ZPiece() {
        super(new Block[]{
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 0, "#800080"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) + Block.width, 0, "#800080"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) + Block.width, 20, "#800080"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) + Block.width * 2, 20, "#800080"),
        });
    }

    @Override
    public void rotate() {

    }
}
