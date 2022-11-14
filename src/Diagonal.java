public interface Diagonal {
    static boolean checkNorthwest(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                for (int i = 1; i < (startX - moveToX); i++) {
                    if (Board.board[startX - i][startY - i] != null) {
                        return false;
                    }
                }
                return true;
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = 1; i < (startX - moveToX); i++) {
                    if (Board.board[startX - i][startY - i] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    static boolean checkNortheast(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                for (int i = 1; i < (startX - moveToX); i++) {
                    if (Board.board[startX - i][startY + i] != null) {
                        return false;
                    }
                }
                return true;
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = 1; i < (startX - moveToX); i++) {
                    if (Board.board[startX - i][startY + i] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    static boolean checkSouthwest(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7 && startY > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                for (int i = 1; i < (moveToX - startX); i++) {
                    if (Board.board[startX + i][startY - i] != null) {
                        return false;
                    }
                }
                return true;
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = 1; i < (moveToX - startX); i++) {
                    if (Board.board[startX + i][startY - i] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    static boolean checkSoutheast(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7 && startY < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                for (int i = 1; i < (moveToX - startX); i++) {
                    if (Board.board[startX + i][startY + i] != null) {
                        return false;
                    }
                }
                return true;
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = 1; i < (moveToX - startX); i++) {
                    if (Board.board[startX + i][startY + i] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
