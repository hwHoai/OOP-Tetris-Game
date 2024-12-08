package models.pieces;

import models.blocks.Block;
import views.PlayView;

public class JPiece extends Piece {
    private Block[] blocks;
    private final String color = "#488BD4";
    public JPiece() {
        super(new Block[]{
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 0, "#488BD4"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 20, "#488BD4"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width), 40, "#488BD4"),
                new Block((int) (Math.floor(PlayView.COLS / 2 ) * Block.width) - Block.width, 40, "#488BD4"),

        });
    }


    @Override
    public void rotate() {
        switch (getForm()) {
            case 1:{
                if(!isLeftCollided() && !isRightCollided()) {
                    int nexPosOfBlock0 = PlayView.board[(int) (getBlocks()[0].getTranslateX() + (Block.width*1)) / Block.width][(int) (getBlocks()[0].getTranslateY() + (Block.height*2)) / Block.height];
                    int nexPosOfBlock1 = PlayView.board[(int) (getBlocks()[1].getTranslateX()) / Block.width][(int) (getBlocks()[1].getTranslateY() + (Block.height*1)) / Block.height];
                    int nexPosOfBlock2 = PlayView.board[(int) (getBlocks()[2].getTranslateX() - (Block.width*1)) / Block.width][(int) (getBlocks()[2].getTranslateY()) / Block.height];
                    int nexPosOfBlock3 = PlayView.board[(int) (getBlocks()[3].getTranslateX()) / Block.width][(int) (getBlocks()[3].getTranslateY() - (Block.height*1)) / Block.height];
                    if( nexPosOfBlock0 == 0 && nexPosOfBlock0 == nexPosOfBlock1 && nexPosOfBlock1 == nexPosOfBlock2 && nexPosOfBlock2 == nexPosOfBlock3) {
                        getBlocks()[0].moveRight();
                        getBlocks()[0].moveDown();
                        getBlocks()[0].moveDown();

                        getBlocks()[1].moveDown();

                        getBlocks()[2].moveLeft();

                        getBlocks()[3].moveUp();
                        if(getForm() != 4) {
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
                    int nexPosOfBlock0 = PlayView.board[(int) (getBlocks()[0].getTranslateX() - (Block.width * 2)) / Block.width][(int) (getBlocks()[0].getTranslateY()) / Block.height];
                    int nexPosOfBlock1 = PlayView.board[(int) (getBlocks()[1].getTranslateX() - (Block.width * 1)) / Block.width][(int) (getBlocks()[1].getTranslateY() - (Block.height * 1)) / Block.height];
                    int nexPosOfBlock2 = PlayView.board[(int) (getBlocks()[2].getTranslateX()) / Block.width][(int) (getBlocks()[2].getTranslateY() - (Block.height * 2)) / Block.height];
                    int nexPosOfBlock3 = PlayView.board[(int) (getBlocks()[3].getTranslateX() + (Block.width * 1)) / Block.width][(int) (getBlocks()[3].getTranslateY() - (Block.height * 1)) / Block.height];
                    if (nexPosOfBlock0 == 0 && nexPosOfBlock0 == nexPosOfBlock1 && nexPosOfBlock1 == nexPosOfBlock2 && nexPosOfBlock2 == nexPosOfBlock3) {
                        getBlocks()[0].moveLeft();
                        getBlocks()[0].moveLeft();

                        getBlocks()[1].moveLeft();
                        getBlocks()[1].moveUp();

                        getBlocks()[2].moveUp();
                        getBlocks()[2].moveUp();

                        getBlocks()[3].moveUp();
                        getBlocks()[3].moveRight();
                        if(getForm() != 4) {
                            setForm(getForm() + 1);
                        }
                        else {
                            setForm(1);
                        }
                    }
                }
                break;

            }
            case 3:{
                if(!isLeftCollided() && !isRightCollided()) {
                    int nexPosOfBlock0 = PlayView.board[(int) (getBlocks()[0].getTranslateX()) / Block.width][(int) (getBlocks()[0].getTranslateY() - (Block.height*2)) / Block.height];
                    int nexPosOfBlock1 = PlayView.board[(int) (getBlocks()[1].getTranslateX() + (Block.width * 1)) / Block.width][(int) (getBlocks()[1].getTranslateY() + (Block.height * 1)) / Block.height];
                    int nexPosOfBlock2 = PlayView.board[(int) (getBlocks()[2].getTranslateX() + (Block.width *2)) / Block.width][(int) (getBlocks()[2].getTranslateY()) / Block.height];
                    int nexPosOfBlock3 = PlayView.board[(int) (getBlocks()[3].getTranslateX() + (Block.width * 1)) / Block.width][(int) (getBlocks()[3].getTranslateY() + (Block.height * 1)) / Block.height];
                    if (nexPosOfBlock0 == 0 && nexPosOfBlock0 == nexPosOfBlock1 && nexPosOfBlock1 == nexPosOfBlock2 && nexPosOfBlock2 == nexPosOfBlock3) {
                        getBlocks()[0].moveUp();
                        getBlocks()[0].moveUp();

                        getBlocks()[1].moveUp();
                        getBlocks()[1].moveRight();

                        getBlocks()[2].moveRight();
                        getBlocks()[2].moveRight();

                        getBlocks()[3].moveRight();
                        getBlocks()[3].moveDown();
                        if(getForm() != 4) {
                            setForm(getForm() + 1);
                        }
                        else {
                            setForm(1);
                        }
                    }
                }
                break;

            }
            case 4:{
                if(!isLeftCollided() && !isRightCollided()) {
                    int nexPosOfBlock0 = PlayView.board[(int) (getBlocks()[0].getTranslateX() + Block.width*2) / Block.width][(int) (getBlocks()[0].getTranslateY()) / Block.height];
                    int nexPosOfBlock1 = PlayView.board[(int) (getBlocks()[1].getTranslateX() + (Block.width * 1)) / Block.width][(int) (getBlocks()[1].getTranslateY() + (Block.height * 1)) / Block.height];
                    int nexPosOfBlock2 = PlayView.board[(int) (getBlocks()[2].getTranslateX()) / Block.width][(int) (getBlocks()[2].getTranslateY() + (Block.height*2)) / Block.height];
                    int nexPosOfBlock3 = PlayView.board[(int) (getBlocks()[3].getTranslateX() + (Block.width * 1)) / Block.width][(int) (getBlocks()[3].getTranslateY() - (Block.height * 1)) / Block.height];
                    if (nexPosOfBlock0 == 0 && nexPosOfBlock0 == nexPosOfBlock1 && nexPosOfBlock1 == nexPosOfBlock2 && nexPosOfBlock2 == nexPosOfBlock3) {
                        getBlocks()[0].moveRight();
                        getBlocks()[0].moveRight();

                        getBlocks()[1].moveRight();
                        getBlocks()[1].moveDown();

                        getBlocks()[2].moveDown();
                        getBlocks()[2].moveDown();

                        getBlocks()[3].moveDown();
                        getBlocks()[3].moveLeft();
                        if(getForm() != 4) {
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
