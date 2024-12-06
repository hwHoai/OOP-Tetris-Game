package models.pieces;

import models.blocks.Block;
import views.PlayView;

public class IPiece extends Piece {

    public IPiece() {
        super(new Block[]{
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 0, "#800080"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 20, "#800080"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 40, "#800080"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 60, "#800080"),

        });
    }

    @Override
    public void rotate() {
        if(getForm() < 4) {
            setForm(getForm() + 1);
        }
        else {
            setForm(0);
        }
        switch (getForm()) {
            case 1:{
                if(!isLeftCollided() && !isRightCollided()) {
                    int nexPosOfBlock0 = PlayView.board[(int) (getBlocks()[0].getTranslateX() - (Block.width*2)) / Block.width][(int) (getBlocks()[0].getTranslateY() + (Block.height*2)) / Block.height];
                    int nexPosOfBlock1 = PlayView.board[(int) (getBlocks()[1].getTranslateX() - (Block.width*1)) / Block.width][(int) (getBlocks()[1].getTranslateY() + (Block.height*1)) / Block.height];
                    int nexPosOfBlock3 = PlayView.board[(int) (getBlocks()[3].getTranslateX() + (Block.width*1)) / Block.width][(int) (getBlocks()[3].getTranslateY() - (Block.height*1)) / Block.height];
                    if( nexPosOfBlock0 == 0 && nexPosOfBlock0 == nexPosOfBlock1 && nexPosOfBlock1 == nexPosOfBlock3) {
                        getBlocks()[0].moveLeft();
                        getBlocks()[0].moveLeft();
                        getBlocks()[0].moveDown();
                        getBlocks()[0].moveDown();

                        getBlocks()[1].moveLeft();
                        getBlocks()[1].moveDown();

                        getBlocks()[3].moveRight();
                        getBlocks()[3].moveUp();
                        break;
                    }
                }

                if (getForm() > 0) {
                    setForm(0);
                } else {
                    setForm(1);
                }

                break;
            }
            case 0:{
                if(!isLeftCollided() && !isRightCollided()) {
                    int nexPosOfBlock0 = PlayView.board[(int) (getBlocks()[0].getTranslateX() + (Block.width * 2)) / Block.width][(int) (getBlocks()[0].getTranslateY() - (Block.height * 2)) / Block.height];
                    int nexPosOfBlock1 = PlayView.board[(int) (getBlocks()[1].getTranslateX() + (Block.width * 1)) / Block.width][(int) (getBlocks()[1].getTranslateY() - (Block.height * 1)) / Block.height];
                    int nexPosOfBlock3 = PlayView.board[(int) (getBlocks()[3].getTranslateX() - (Block.width * 1)) / Block.width][(int) (getBlocks()[3].getTranslateY() + (Block.height * 1)) / Block.height];
                    if (nexPosOfBlock0 == 0 && nexPosOfBlock0 == nexPosOfBlock1 && nexPosOfBlock1 == nexPosOfBlock3) {
                        getBlocks()[0].moveUp();
                        getBlocks()[0].moveUp();
                        getBlocks()[0].moveRight();
                        getBlocks()[0].moveRight();

                        getBlocks()[1].moveUp();
                        getBlocks()[1].moveRight();

                        getBlocks()[3].moveDown();
                        getBlocks()[3].moveLeft();
                        break;
                    }
                }
                if(getForm() > 0) {
                    setForm(0);
                }
                else {
                    setForm(1);
                }
                break;

            }
        }
    }
}
