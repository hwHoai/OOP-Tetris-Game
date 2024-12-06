package models.pieces;

import models.blocks.Block;
import views.PlayView;

public class SPiece extends Piece {

    public SPiece() {
        super(new Block[]{
                new Block((int) (Math.floor(PlayView.ROWS / 2 ) * Block.width), 0, "#800080"),
                new Block((int) (Math.floor(PlayView.ROWS / 2 ) * Block.width), 20, "#800080"),
                new Block((int) (Math.floor(PlayView.ROWS / 2 ) * Block.width) + Block.width, 20, "#800080"),
                new Block((int) (Math.floor(PlayView.ROWS / 2 ) * Block.width) + Block.width, 40, "#800080"),
        });
    }

    @Override
    public void rotate(int numOfCols) {

    }
}
