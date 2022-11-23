public interface Checkmate {
    static boolean isPossibleMoveKing(int stX, int stY, int mvX, int mvY) {
        Piece undoKingMove = Board.board[stX][stY];
        Piece undoKillMove = null;
        if (Board.board[stX][stY] != null) {
            undoKillMove = Board.board[mvX][mvY];
        }
        Board.board[stX][stY].setStartX(mvX);
        Board.board[stX][stY].setStartY(mvY);
        Board.board[mvX][mvY] = Board.board[stX][stY];
        Board.board[stX][stY] = null;
        boolean result = isTheKingInCheck(stX, stY);
        Board.board[stX][stY] = undoKingMove;
        Board.board[stX][stY].setStartX(stX);
        Board.board[stX][stY].setStartY(stY);
        Board.board[mvX][mvY] = undoKillMove;
        return result;
    }

    static boolean isTheKingInCheck(int stX, int stY) {
        for (int startX = 0; startX < 8; startX++) {
            for (int startY = 0; startY < 8; startY++) {
                if (Board.board[startX][startY] != null) {
                    if (Board.board[stX][stY] != null) {
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
        }
        return false;
    }

    static boolean checkIfPossibleMoveIsInCheck(int stX, int stY, int mvX, int mvY) {
        if (Board.board[stX][stY].isPossibleMove(mvX, mvY)) {
            boolean inCheck = false;
            int enemiesCount = 0;
            boolean isSavable = false;
            for (int startX = 0; startX < 8; startX++) {
                for (int startY = 0; startY < 8; startY++) {
                    if (Board.board[startX][startY] != null) {
                        if (!Board.board[startX][startY].getColor().equalsIgnoreCase(Board.board[stX][stY].getColor())) {
                            for (int moveToX = 0; moveToX < 8; moveToX++) {
                                for (int moveToY = 0; moveToY < 8; moveToY++) {
                                    if (Board.board[startX][startY].isPossibleMove(moveToX, moveToY)) {
                                        if (Board.board[moveToX][moveToY] instanceof King) {
                                            inCheck = true;
                                            enemiesCount++;
                                            if (Board.board[startX][startY].getStartX() == mvX && Board.board[startX][startY].getStartY() == mvY) {
                                                isSavable = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return checkIfTheKingIsInCheck(enemiesCount, inCheck, isSavable);
        }
        return false;
    }

    static boolean checkIfTheKingIsInCheck(int enemiesCount, boolean inCheck, boolean isSavable) {
        if (inCheck) {
            if (enemiesCount == 1) {
                inCheck = isSavable;
            }
        }
        return inCheck;
    }
}
