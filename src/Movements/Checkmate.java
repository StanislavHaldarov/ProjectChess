package Movements;

import Pieces.King;
import Pieces.Piece;

public interface Checkmate {
    static boolean checkIfValidMoveInCheck(int stX, int stY, int mvX, int mvY) {
        Piece undoMove = MenuAndBoard.Board.board[stX][stY];
        Piece undoKillMove = null;
        boolean result;
        if (MenuAndBoard.Board.board[stX][stY] != null) {
            undoKillMove = MenuAndBoard.Board.board[mvX][mvY];
        }
        MenuAndBoard.Board.board[stX][stY].setStartX(mvX);
        MenuAndBoard.Board.board[stX][stY].setStartY(mvY);
        MenuAndBoard.Board.board[mvX][mvY] = MenuAndBoard.Board.board[stX][stY];
        MenuAndBoard.Board.board[stX][stY] = null;
        result = checkIfKingInCheck(mvX, mvY);
        MenuAndBoard.Board.board[stX][stY] = undoMove;
        MenuAndBoard.Board.board[stX][stY].setStartX(stX);
        MenuAndBoard.Board.board[stX][stY].setStartY(stY);
        MenuAndBoard.Board.board[mvX][mvY] = undoKillMove;
        return result;
    }

    static boolean checkIfKingInCheck(int stX, int stY) {
        boolean result = false;
        for (int startX = 0; startX < 8; startX++) {
            for (int startY = 0; startY < 8; startY++) {
                if (MenuAndBoard.Board.board[startX][startY] != null) {
                    if (!MenuAndBoard.Board.board[startX][startY].getColor().equalsIgnoreCase(MenuAndBoard.Board.board[stX][stY].getColor())) {
                        for (int moveToX = 0; moveToX < 8; moveToX++) {
                            for (int moveToY = 0; moveToY < 8; moveToY++) {
                                if (MenuAndBoard.Board.board[startX][startY].isValidMove(moveToX, moveToY)) {
                                    if (MenuAndBoard.Board.board[moveToX][moveToY] instanceof King) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}

