package models.pieces;

import models.blocks.Block;
import views.PlayView;

public class JPiece extends Piece {
    private Block[] blocks;
    private final String color = "#488BD4";
    public JPiece() {
        super(new Block[]{
                new Block((int) (Math.floor(PlayView.ROWS / 2 ) * Block.width), 0, "#800080"),
                new Block((int) (Math.floor(PlayView.ROWS / 2 ) * Block.width), 20, "#800080"),
                new Block((int) (Math.floor(PlayView.ROWS / 2 ) * Block.width), 40, "#800080"),
                new Block((int) (Math.floor(PlayView.ROWS / 2 ) * Block.width) - Block.width, 40, "#800080"),

        });
    }


    @Override
    public void rotate(int numOfCols) {
        blocks[0].setTranslateX(blocks[0].getTranslateX() + 20);
        blocks[0].setTranslateY(blocks[0].getTranslateY() + 40);

        blocks[1].setTranslateY(blocks[1].getTranslateY() + 20);

        blocks[2].setTranslateX(blocks[2].getTranslateX() - 20);

        blocks[3].setTranslateY(blocks[3].getTranslateY() - 20);
    }
}
