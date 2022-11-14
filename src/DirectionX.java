public interface DirectionX {
    static boolean checkNorth(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                for (int i = moveToX + 1; i < startX; i++) {
                    if (Board.board[i][moveToY] != null) {
                        return false;
                    }
                }
                return true;
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = moveToX + 1; i < startX; i++) {
                    if (Board.board[i][moveToY] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    static boolean checkSouth(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                for (int i = startX + 1; i < moveToX; i++) {
                    if (Board.board[i][moveToY] != null) {
                        return false;
                    }
                }
                return true;
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))){
                for (int i = startX + 1; i < moveToX; i++) {
                    if (Board.board[i][moveToY] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
