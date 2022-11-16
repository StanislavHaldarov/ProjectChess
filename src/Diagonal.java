public interface Diagonal {
    static boolean checkNorthwest(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                return Pathfinders.checkNorthwestPath(startX,startY,moveToX);
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                return Pathfinders.checkNorthwestPath(startX,startY,moveToX);
            }
        }
        return false;
    }

    static boolean checkNortheast(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                return Pathfinders.checkNortheastPath(startX,startY,moveToX);
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                return Pathfinders.checkNortheastPath(startX,startY,moveToX);
            }
        }
        return false;
    }

    static boolean checkSouthwest(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7 && startY > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                return Pathfinders.checkSouthwestPath(startX,startY,moveToX);
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                return Pathfinders.checkSouthwestPath(startX,startY,moveToX);
            }
        }
        return false;
    }


    static boolean checkSoutheast(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7 && startY < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                return Pathfinders.checkSoutheastPath(startX,startY,moveToX);
            } else if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                return Pathfinders.checkSoutheastPath(startX,startY,moveToX);
            }
        }
        return false;
    }
}
