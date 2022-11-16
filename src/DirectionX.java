public interface DirectionX {
    static boolean checkNorth(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                return Pathfinders.checkNorthPath(startX,moveToX,moveToY);
            } else {
                if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                    return Pathfinders.checkNorthPath(startX,moveToX,moveToY);
                }
            }
        }
        return false;
    }

    static boolean checkSouth(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                return Pathfinders.checkSouthPath(startX,moveToX,moveToY);
            } else {
                if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))){
                    return Pathfinders.checkSouthPath(startX,moveToX,moveToY);
                }
            }
        }
        return false;
    }
}
