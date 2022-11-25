public interface Checkmate {
    static boolean checkIfPossibleMoveIsCheck(int stX, int stY, int mvX, int mvY) {
        Piece undoMove = Board.board[stX][stY];
        Piece undoKillMove = null;
        boolean result;
        if (Board.board[stX][stY] != null) {
            undoKillMove = Board.board[mvX][mvY];
        }
        Board.board[stX][stY].setStartX(mvX);
        Board.board[stX][stY].setStartY(mvY);
        Board.board[mvX][mvY] = Board.board[stX][stY];
        Board.board[stX][stY] = null;
        result = checkIfKingInCheck(mvX, mvY);
        Board.board[stX][stY] = undoMove;
        Board.board[stX][stY].setStartX(stX);
        Board.board[stX][stY].setStartY(stY);
        Board.board[mvX][mvY] = undoKillMove;
        return result;
    }

    static boolean checkIfKingInCheck(int stX, int stY) {
        boolean result = false;
        int kingKillersCount = 0;
        for (int startX = 0; startX < 8; startX++) {
            for (int startY = 0; startY < 8; startY++) {
                if (Board.board[startX][startY] != null) {
                    if (!Board.board[startX][startY].getColor().equalsIgnoreCase(Board.board[stX][stY].getColor())) {
                        for (int moveToX = 0; moveToX < 8; moveToX++) {
                            for (int moveToY = 0; moveToY < 8; moveToY++) {
                                if (Board.board[startX][startY].isPossibleMove(moveToX, moveToY)) {
                                    if (Board.board[moveToX][moveToY] instanceof King) {
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

