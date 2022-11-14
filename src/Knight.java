public class Knight extends Piece {
    public Knight(String color, int startX, int startY) {
        super(color, startX, startY);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result = ((startX + 2 == moveToX) && (startY + 1 == moveToY)) || ((startX + 1 == moveToX) && (startY + 2 == moveToY)) || ((startX - 1 == moveToX) && (startY + 2 == moveToY)) || ((startX - 2 == moveToX) && (startY + 1 == moveToY))
                || (((startX - 2) == moveToX) && ((startY - 1) == moveToY)) || ((startX - 1 == moveToX) && (startY - 2 == moveToY)) || ((startX + 1 == moveToX) && (startY - 2 == moveToY)) || ((startX + 2 == moveToX) && (startY - 1 == moveToY));
        if ((Board.board[moveToX][moveToY] == null)) {
            if (result) {
                return true;
            } else {
                return false;
            }
        } else if (Board.board[moveToX][moveToY].getColor() != Board.board[startX][startY].getColor()) {
            if (result) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void move(int startX, int startY, int moveToX, int moveToY) {
        super.move(startX,startY,moveToX,moveToY);
    }
    @Override
    public String toString() {
        if(super.getColor().equals("white")){
            return "wKn";
        } else{
            return "bKn";
        }
    }
}
