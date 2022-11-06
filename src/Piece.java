import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class Piece {
    private String color;
    private int x, y;
    public abstract boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY);

    public abstract String toString();
    public void move(int startX, int startY, int x, int y){
        boolean isPossibleMove = isPossibleMove(startX, startY, x, y);
        if (isPossibleMove) {
            Board.board[x][y] = Board.board[startX][startY];
            Board.board[startX][startY] = null;
        } else {
            System.out.println("Not possible move!");
        }
    }
    public void move(int startX, int startY, int x, int y, Runnable callback){
        boolean isPossibleMove = isPossibleMove(startX, startY, x, y);
        if (isPossibleMove) {
            Board.board[x][y] = Board.board[startX][startY];
            Board.board[startX][startY] = null;
            callback.run();
        } else {
            System.out.println("Not possible move!");
        }
    }

    public Piece(String color, int x, int y) {
        this.color = color;
        setX(x);
        setY(y);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
