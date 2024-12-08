package models.pieces;

import models.blocks.Block;
import views.PlayView;

public class OPiece extends Piece {

    public OPiece() {
        super(new Block[]{
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 0, "#FF7F00"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 20, "#FF7F00"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) + Block.width, 0, "#FF7F00"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) + Block.width, 20, "#FF7F00"),
        });
    }

    @Override
    public void rotate() {
        // Do nothing
    }
}
