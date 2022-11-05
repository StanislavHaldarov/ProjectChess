public class King extends Piece{

    public King(String color, int x, int y) {
        super(color, x, y);
    }
    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;

        return result;
    }
//    private boolean checkIfValidPosition(int startX, int startY, int moveToX, int moveToY){
//        if(moveToX-1==startX || moveToX+1==startX){
//
//        }
//    }
    private boolean checkNorthKing(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startX > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                    result = true;
            }
        }
        return result;
    }
//    private boolean checkNortheastKing(int startX, int startY, int moveToX, int moveToY){
//
//    }
    private boolean checkSouthKing(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startX < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                result = true;
            }
        }
        return result;
    }
    private boolean checkEastKing(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startY < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                result = true;
            }
        }
        return result;
    }
    private boolean checkWestKing(int startX, int startY, int moveToX, int moveToY){
        boolean result = false;
        if (startY > 0) {
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
