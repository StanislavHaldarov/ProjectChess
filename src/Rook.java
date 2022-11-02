public class Rook extends Piece{
    public Rook(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if(moveToY==startY && moveToX<startX){
            result = checkRookNorth(startX, startY, moveToX, moveToY);
            return result;
        } else if(moveToX>startX && moveToY == startY){
            result = checkRookSouth(startX,startY,moveToX,moveToY);
            return result;
        } else if(moveToX==startX){
            if(moveToY < startY){
                result =checkRookWest(startX,startY,moveToX,moveToY);
                return result;
            }
            if(moveToY > startY){
                result = checkRookEast(startX,startY,moveToX,moveToY);
                return result;
            }
        }
        return false;
    }
    private boolean checkRookWest(int startX, int startY, int moveToX, int moveToY) {
        if (startY > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startY - 1; i < (startY - moveToY); i--) {
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
    private boolean checkRookEast(int startX, int startY, int moveToX, int moveToY) {
        if (startY < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startY + 1; i < (moveToY - startY); i++) {
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
    private boolean checkRookNorth(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startX - 1; i < (startX - moveToX); i--) {
                    if (Board.board[i][moveToY] != null) {
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

    private boolean checkRookSouth(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startX + 1; i < (moveToX - startX); i++) {
                    if (Board.board[i][moveToY] != null) {
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

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wRk";
        } else {
            return "bRk";
        }
    }

    @Override
    public void move(int startX, int startY, int x, int y) {
        boolean isPossibleMove = isPossibleMove(startX, startY, x, y);
        if (isPossibleMove) {
            Board.board[x][y] = Board.board[startX][startY];
            Board.board[startX][startY] = null;
        } else {
            System.out.println("Not possible move!");
        }
    }
}
