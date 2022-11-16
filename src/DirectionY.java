public interface DirectionY {
    static boolean checkWest(int startX, int startY, int moveToX, int moveToY){
        if (startY > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                return Pathfinders.checkWestPath(startY,moveToX,moveToY);
            } else {
                if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                    return Pathfinders.checkWestPath(startY, moveToX, moveToY);
                }
            }
        }
        return false;
    }
    static boolean checkEast(int startX, int startY, int moveToX, int moveToY){
        if (startY < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                return Pathfinders.checkEastPath(startY,moveToX,moveToY);
            } else {
                if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                    return Pathfinders.checkEastPath(startY, moveToX, moveToY);
                }
            }
        }
        return false;
    }

}
