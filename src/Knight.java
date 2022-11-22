import java.util.Objects;

public class Knight extends Piece {
    public Knight(String color, int startX, int startY) {
        super(color, startX, startY);
    }

    @Override
    public boolean isPossibleMove(int moveToX, int moveToY) {
        boolean result = ((getStartX() + 2 == moveToX) && (getStartY() + 1 == moveToY)) || ((getStartX() + 1 == moveToX) && (getStartY() + 2 == moveToY)) || ((getStartX() - 1 == moveToX) && (getStartY() + 2 == moveToY)) || ((getStartX() - 2 == moveToX) && (getStartY() + 1 == moveToY))
                || ((getStartX() - 2 == moveToX) && (getStartY() - 1 == moveToY)) || ((getStartX() - 1 == moveToX) && (getStartY() - 2 == moveToY)) || ((getStartX() + 1 == moveToX) && (getStartY() - 2 == moveToY)) || ((getStartX() + 2 == moveToX) && (getStartY() - 1 == moveToY));
        if ((Board.board[moveToX][moveToY] == null)) {
            if(result){
                return Checkmate.isPossibleMove2(getColor(), moveToX, moveToY);
            }
        } else if (!Objects.equals(Board.board[moveToX][moveToY].getColor(), Board.board[getStartX()][getStartY()].getColor())) {
            if(result){
                return Checkmate.isPossibleMove2(getColor(),moveToX,moveToY);
            }
        }
        return false;
    }

    @Override
    public void move(int moveToX, int moveToY) {
        super.move(moveToX,moveToY);
    }

    @Override
    public void testMove(int moveToX, int moveToY) {
        super.testMove(moveToX, moveToY);
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
