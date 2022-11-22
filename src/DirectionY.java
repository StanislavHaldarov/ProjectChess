public interface DirectionY {
    static boolean checkWest(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startY > 0) {
            if (Board.board[moveToX][moveToY] == null) {
                result = Pathfinders.checkWestPath(startY,moveToX,moveToY);
            } else {
                if(Board.board[startX][startY]!=null) {
                    if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkWestPath(startY, moveToX, moveToY);
                    }
                }
            }
        }
        return result;
    }
    static boolean checkEast(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startY < 7) {
            if (Board.board[moveToX][moveToY] == null) {
                 result = Pathfinders.checkEastPath(startY,moveToX,moveToY);
            } else {
                if (Board.board[startX][startY]!=null) {
                    if (!(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkEastPath(startY, moveToX, moveToY);
                    }
                }
            }
        }
        return result;
    }

}
