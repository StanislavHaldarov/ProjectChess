import java.util.Objects;

public class Knight extends Piece {
    public Knight(String color, int startX, int startY) {
        super(color, startX, startY);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result = ((startX + 2 == moveToX) && (startY + 1 == moveToY)) || ((startX + 1 == moveToX) && (startY + 2 == moveToY)) || ((startX - 1 == moveToX) && (startY + 2 == moveToY)) || ((startX - 2 == moveToX) && (startY + 1 == moveToY))
                || ((startX - 2 == moveToX) && (startY - 1 == moveToY)) || ((startX - 1 == moveToX) && (startY - 2 == moveToY)) || ((startX + 1 == moveToX) && (startY - 2 == moveToY)) || ((startX + 2 == moveToX) && (startY - 1 == moveToY));
        if ((Board.board[moveToX][moveToY] == null)) {
            return result;
        } else if (!Objects.equals(Board.board[moveToX][moveToY].getColor(), Board.board[startX][startY].getColor())) {
            return result;
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
