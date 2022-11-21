public interface Checkmate {
    static boolean isInCheck(String color, int startX, int startY, int moveToX, int moveToY)
    {
        boolean result;
        Piece undoMove = Board.board[startX][startY];
        Piece undoKill = null;
        if (Board.board[moveToX][moveToY] != null) {
            undoKill = Board.board[moveToX][moveToY];
        }
        Board.board[startX][startY] = null;
        Board.board[moveToX][moveToY] = undoMove;
        result = isCheckmate(color);
        Board.board[startX][startY] = undoMove;
        Board.board[moveToX][moveToY] = undoKill;
        return result;
    }
    static boolean isCheckmate(String color)
    {
        for (int startX = 0; startX < 8; startX++) {
            for (int startY = 0; startY < 8; startY++) {
                if(Board.board[startX][startY] != null){
                    if(!Board.board[startX][startY].getColor().equalsIgnoreCase(color)) {
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
        return false;
    }
}
