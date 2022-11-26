package Pieces;

public abstract class Piece implements Movements.Movable {
    protected String color;
    protected int startX, startY;

    public abstract boolean isValidMove(int moveToX, int moveToY);

    public abstract String toString();

    @Override
    public void move(int moveToX, int moveToY) {
        MenuAndBoard.Board.board[moveToX][moveToY] = MenuAndBoard.Board.board[getStartX()][getStartY()];
        MenuAndBoard.Board.board[getStartX()][getStartY()] = null;
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
