package Movements;

public interface DirectionX {
    static boolean checkNorth(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;
        if (startX > 0) {
            if (MenuAndBoard.Board.board[moveToX][moveToY] == null) {
                result = Pathfinders.checkNorthPath(startX,moveToX,moveToY);
            } else {
                if (MenuAndBoard.Board.board[startX][startY]!= null) {
                    if (!(MenuAndBoard.Board.board[startX][startY].getColor().equals(MenuAndBoard.Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkNorthPath(startX, moveToX, moveToY);
                    }
                }
            }
        }
        return result;
    }

    static boolean checkSouth(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;
        if (startX < 7) {
            if (MenuAndBoard.Board.board[moveToX][moveToY] == null) {
                result = Pathfinders.checkSouthPath(startX,moveToX,moveToY);
            } else {
                if(MenuAndBoard.Board.board[startX][startY]!= null) {
                    if (!(MenuAndBoard.Board.board[startX][startY].getColor().equals(MenuAndBoard.Board.board[moveToX][moveToY].getColor()))) {
                        result = Pathfinders.checkSouthPath(startX, moveToX, moveToY);
                    }
                }
            }
        }
        return result;
    }
}
