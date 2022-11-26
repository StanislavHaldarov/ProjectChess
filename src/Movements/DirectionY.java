package Movements;

public interface DirectionY {
    static boolean checkWest(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startY > 0) {
            if (MenuAndBoard.Board.board[moveToX][moveToY] == null) {
                result = Pathfinders.checkWestPath(startY,moveToX,moveToY);
            } else {
                if(MenuAndBoard.Board.board[startX][startY]!=null) {
                    if (!(MenuAndBoard.Board.board[startX][startY].getColor().equals(MenuAndBoard.Board.board[moveToX][moveToY].getColor()))) {
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
            if (MenuAndBoard.Board.board[moveToX][moveToY] == null) {
                 result = Pathfinders.checkEastPath(startY,moveToX,moveToY);
            } else {
                if (MenuAndBoard.Board.board[startX][startY]!=null) {
                    if (!(MenuAndBoard.Board.board[startX][startY].getColor().equals(MenuAndBoard.Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkEastPath(startY, moveToX, moveToY);
                    }
                }
            }
        }
        return result;
    }

}
