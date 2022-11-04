public class King extends Piece{

    public King(String color, int x, int y) {
        super(color, x, y);
    }
    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;
        if(startX-1 == moveToX){
            checkNorth(startX,startY,moveToX,moveToY);
            result=true;
        } else if(startX+1 == moveToX){
            checkSouth(startX,startY,moveToX,moveToY);
        }
        return result;
    }
    private boolean checkNorth(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startX > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                    result = true;
            }
        }
        return result;
    }
    private boolean checkSouth(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startX < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                result = true;
            }
        }
        return result;
    }


    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wK";
        } else {
            return "bK";
        }
    }
}
