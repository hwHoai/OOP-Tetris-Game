package models.pieces;

import models.blocks.Block;
import views.PlayView;

public class SPiece extends Piece {

    public SPiece() {
        super(new Block[]{
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 0, "#FFFF00"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 20, "#FFFF00"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) + Block.width, 20, "#FFFF00"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) + Block.width, 40, "#FFFF00"),
        });
    }

    @Override
    public void rotate() {
        switch (getForm()) {
            case 1:{
                if(!isLeftCollided() && !isRightCollided()) {
                    int nexPosOfBlock0 = PlayView.board[(int) (getBlocks()[0].getTranslateX() + (Block.width*1)) / Block.width][(int) (getBlocks()[0].getTranslateY() + (Block.height*1)) / Block.height];
                    int nexPosOfBlock2 = PlayView.board[(int) (getBlocks()[2].getTranslateX() - (Block.width*1)) / Block.width][(int) (getBlocks()[2].getTranslateY() + (Block.height*1)) / Block.height];
                    int nexPosOfBlock3 = PlayView.board[(int) (getBlocks()[3].getTranslateX() - (Block.width*2)) / Block.width][(int) (getBlocks()[3].getTranslateY()) / Block.height];
                    if( nexPosOfBlock0 == 0 && nexPosOfBlock0 == nexPosOfBlock2 && nexPosOfBlock2 == nexPosOfBlock3) {
                        getBlocks()[0].moveRight();
                        getBlocks()[0].moveDown();

                        getBlocks()[2].moveLeft();
                        getBlocks()[2].moveDown();

                        getBlocks()[3].moveLeft();
                        getBlocks()[3].moveLeft();
                        if(getForm() != 2) {
                            setForm(getForm() + 1);
                        }
                        else {
                            setForm(1);
                        }
                    }
                }
                break;
            }
            case 2:{
                if(!isLeftCollided() && !isRightCollided()) {
                    int nexPosOfBlock0 = PlayView.board[(int) (getBlocks()[0].getTranslateX() - (Block.width * 1)) / Block.width][(int) (getBlocks()[0].getTranslateY() - (Block.height * 1)) / Block.height];
                    int nexPosOfBlock2 = PlayView.board[(int) (getBlocks()[2].getTranslateX() + (Block.width * 1)) / Block.width][(int) (getBlocks()[2].getTranslateY() - (Block.height * 1)) / Block.height];
                    int nexPosOfBlock3 = PlayView.board[(int) (getBlocks()[3].getTranslateX() + (Block.width * 2)) / Block.width][(int) (getBlocks()[3].getTranslateY()) / Block.height];
                    if (nexPosOfBlock0 == 0 && nexPosOfBlock0 == nexPosOfBlock2 && nexPosOfBlock2 == nexPosOfBlock3) {
                        getBlocks()[0].moveUp();
                        getBlocks()[0].moveLeft();

                        getBlocks()[2].moveUp();
                        getBlocks()[2].moveRight();

                        getBlocks()[3].moveRight();
                        getBlocks()[3].moveRight();
                        if(getForm() != 2) {
                            setForm(getForm() + 1);
                        }
                        else {
                            setForm(1);
                        }
                    }
                }
                break;

            }
        }

    }
}
