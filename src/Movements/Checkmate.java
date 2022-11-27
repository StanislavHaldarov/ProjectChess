package Movements;

import MenuAndBoard.Board;
import Pieces.King;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Rook;

public interface Checkmate {
    static boolean checkIfValidMoveInCheck(int stX, int stY, int mvX, int mvY) {
        Piece undoMove = MenuAndBoard.Board.board[stX][stY];
        Piece undoKillMove = null;
        boolean result;
        boolean castling = false;
        if (MenuAndBoard.Board.board[mvX][mvY] != null) {
            undoKillMove = MenuAndBoard.Board.board[mvX][mvY];
        }

        Piece undoCastlingMove = checkCastlingIfCastlingMove(stX, stY, mvY, null);
        if (undoCastlingMove != null) {
            castling = true;
        }
        Piece undoEnPassantMove = checkEnPassantMove(stX, stY, mvX, mvY, null);
        MenuAndBoard.Board.board[stX][stY].setStartX(mvX);
        MenuAndBoard.Board.board[stX][stY].setStartY(mvY);
        MenuAndBoard.Board.board[mvX][mvY] = MenuAndBoard.Board.board[stX][stY];
        MenuAndBoard.Board.board[stX][stY] = null;
        result = checkIfKingInCheck(mvX, mvY, castling);
        undoMoving(stX, stY, undoMove, undoKillMove, undoCastlingMove, undoEnPassantMove, mvX, mvY);
        return result;
    }

    static void undoMoving(int stX, int stY, Piece undoMove, Piece undoKillMove, Piece undoCastlingMove, Piece undoEnPassantMove, int mvX, int mvY) {
        MenuAndBoard.Board.board[stX][stY] = undoMove;
        MenuAndBoard.Board.board[stX][stY].setStartX(stX);
        MenuAndBoard.Board.board[stX][stY].setStartY(stY);
        MenuAndBoard.Board.board[mvX][mvY] = undoKillMove;
        if (undoCastlingMove != null) {
            if (mvY == stY + 2) {

                MenuAndBoard.Board.board[stX][stY + 1] = null;
                MenuAndBoard.Board.board[stX][stY + 3] = undoCastlingMove;
            }
            if (mvY == stY - 2) {

                MenuAndBoard.Board.board[stX][stY - 1] = MenuAndBoard.Board.board[stX][stY - 4];
                MenuAndBoard.Board.board[stX][stY - 4] = null;
            }
        }
        if (undoEnPassantMove != null) {
            MenuAndBoard.Board.board[stX][stY + 1] = undoEnPassantMove;
        }
    }

    static boolean checkIfKingInCheck(int stX, int stY, boolean castling) {
        for (int startX = 0; startX < 8; startX++) {
            for (int startY = 0; startY < 8; startY++) {
                if (MenuAndBoard.Board.board[startX][startY] != null) {
                    if (!MenuAndBoard.Board.board[startX][startY].getColor().equalsIgnoreCase(MenuAndBoard.Board.board[stX][stY].getColor())) {
                        for (int moveToX = 0; moveToX < 8; moveToX++) {
                            for (int moveToY = 0; moveToY < 8; moveToY++) {
                                if (MenuAndBoard.Board.board[startX][startY].isValidMove(moveToX, moveToY)) {
                                    if (castling) {
                                        if (MenuAndBoard.Board.board[moveToX][moveToY] instanceof King || MenuAndBoard.Board.board[moveToX][moveToY] instanceof Rook) {
                                            return true;
                                        }
                                    } else {
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
        }
        return false;
    }

    static Piece checkCastlingIfCastlingMove(int stX, int stY, int mvY, Piece undoCastlingMove) {
        if (MenuAndBoard.Board.board[stX][stY] instanceof King) {
            if (mvY == stY + 2) {
                undoCastlingMove = MenuAndBoard.Board.board[stX][stY + 3];
                MenuAndBoard.Board.board[stX][stY + 1] = MenuAndBoard.Board.board[stX][stY + 3];
                MenuAndBoard.Board.board[stX][stY + 3] = null;

            }
            if (mvY == stY - 2) {
                undoCastlingMove = MenuAndBoard.Board.board[stX][0];
                MenuAndBoard.Board.board[stX][stY - 1] = MenuAndBoard.Board.board[stX][stY - 4];
                MenuAndBoard.Board.board[stX][stY - 4] = null;

            }
        }
        return undoCastlingMove;
    }

    static Piece checkEnPassantMove(int stX, int stY, int mvX, int mvY, Piece undoEnPassantMove) {
        if (MenuAndBoard.Board.board[stX][stY] instanceof Pawn) {
            if (MenuAndBoard.Board.board[mvX][mvY] == null) {
                if (stY + 1 == mvY) {
                    if (MenuAndBoard.Board.board[stX][stY + 1] instanceof Pawn) {
                        undoEnPassantMove = MenuAndBoard.Board.board[stX][stY + 1];
                        MenuAndBoard.Board.board[stX][stY + 1] = null;
                    }
                }
                if (stY - 1 == mvY) {
                    if (MenuAndBoard.Board.board[stX][stY + 1] instanceof Pawn) {
                        undoEnPassantMove = MenuAndBoard.Board.board[stX][stY - 1];
                        MenuAndBoard.Board.board[stX][stY - 1] = null;
                    }
                }
            }
        }
        return undoEnPassantMove;
    }
}

