import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class Piece {
    protected String color;
    protected int startX, startY;

    public abstract boolean isPossibleMove(int moveToX, int moveToY);

    public abstract String toString();

    public void move(int moveToX, int moveToY) {
        Board.board[moveToX][moveToY] = Board.board[getStartX()][getStartY()];
        Board.board[getStartX()][getStartY()] = null;
        setStartX(moveToX);
        setStartY(moveToY);
    }

    public Piece(String color, int startX, int startY) {
        this.color = color;
        this.startX = startX;
        this.startY = startY;
    }

    public String getColor() {
        return color;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }
}
