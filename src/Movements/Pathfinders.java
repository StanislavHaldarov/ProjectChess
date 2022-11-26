package Movements;

public interface Pathfinders {
    static boolean checkNorthPath(int startX,int moveToX,int moveToY){
        if(moveToX < startX-1) {
            for (int i = moveToX + 1; i < startX; i++) {
                if (MenuAndBoard.Board.board[i][moveToY] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkSouthPath(int startX,int moveToX,int moveToY){
        if(moveToX > startX+1) {
            for (int i = startX + 1; i < moveToX; i++) {
                if (MenuAndBoard.Board.board[i][moveToY] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkWestPath(int startY,int moveToX,int moveToY)
    {
        if(moveToY<startY-1) {
            for (int i = moveToY + 1; i < startY; i++) {
                if (MenuAndBoard.Board.board[moveToX][i] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkEastPath(int startY,int moveToX,int moveToY)
    {
        if(moveToY>startY+1) {
            for (int i = startY + 1; i < moveToY; i++) {
                if (MenuAndBoard.Board.board[moveToX][i] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkNorthwestPath(int startX, int startY, int moveToX)
    {
        if(moveToX<startX-1) {
            for (int i = 1; i < (startX - moveToX); i++) {
                if (MenuAndBoard.Board.board[startX - i][startY - i] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkNortheastPath(int startX, int startY, int moveToX)
    {
        if(moveToX < startX-1) {
            for (int i = 1; i < (startX - moveToX); i++) {
                if (MenuAndBoard.Board.board[startX - i][startY + i] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkSouthwestPath(int startX, int startY, int moveToX)
    {
        if(moveToX > startX+1) {
            for (int i = 1; i < (moveToX - startX); i++) {
                if (MenuAndBoard.Board.board[startX + i][startY - i] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkSoutheastPath(int startX, int startY, int moveToX)
    {
        if(moveToX > startX+1) {
            for (int i = 1; i < (moveToX - startX); i++) {
                if (MenuAndBoard.Board.board[startX + i][startY + i] != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
