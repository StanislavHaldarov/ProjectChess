import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class Piece {
    private String color;
    private int startX, startY;
    public abstract boolean isPossibleMove(int moveToX, int moveToY);

    public abstract String toString();
    public void move(int x, int y){
        boolean isPossibleMove = isPossibleMove(x, y);
        if (isPossibleMove) {
            Board.board[x][y] = Board.board[startX][startY];
            Board.board[startX][startY] = null;
        }
    }


    public Piece(String color, int startX, int startY) {
        this.color = color;
        this.startX = startX;
        this.startY = startY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
