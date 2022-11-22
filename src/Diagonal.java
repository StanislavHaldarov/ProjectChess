public interface Diagonal {
    static boolean checkNorthwest(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;
        if (startX > 0 && startY > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                result = Pathfinders.checkNorthwestPath(startX, startY, moveToX);
            } else {
                if (Board.board[startX][startY] != null) {
                    if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkNorthwestPath(startX, startY, moveToX);
                    }
                }
            }
        }
        return result;
    }

    static boolean checkNortheast(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;
        if (startX > 0 && startY < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                result = Pathfinders.checkNortheastPath(startX, startY, moveToX);
            } else {
                if(Board.board[startX][startY]!=null) {
                    if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkNortheastPath(startX, startY, moveToX);
                    }
                }
            }
        }
        return result;
    }

    static boolean checkSouthwest(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;
        if (startX < 7 && startY > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                result = Pathfinders.checkSouthwestPath(startX, startY, moveToX);
            } else {
                if(Board.board[startX][startY]!=null) {
                    if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkSouthwestPath(startX, startY, moveToX);
                    }
                }
            }
        }
        return result;
    }


    static boolean checkSoutheast(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;
        if (startX < 7 && startY < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                result = Pathfinders.checkSoutheastPath(startX, startY, moveToX);
            } else {
                if (Board.board[startX][startY]!=null) {
                    if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkSoutheastPath(startX, startY, moveToX);
                    }
                }
            }
        }
        return result;
    }
}
