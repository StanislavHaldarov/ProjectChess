public interface DirectionY {
    static boolean checkWest(int startX, int startY, int moveToX, int moveToY){
        if (startY > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = moveToY+ 1; i < startY; i++) {
                    if (Board.board[moveToX][i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    static boolean checkEast(int startX, int startY, int moveToX, int moveToY){
        if (startY < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startY + 1; i < moveToY; i++) {
                    if (Board.board[moveToX][i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
