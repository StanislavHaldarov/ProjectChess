public abstract class Piece implements Move{
    private String color;
    private int x, y;
    public abstract boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY);
    public abstract String toString();
    public abstract void move(int startX, int startY, int x, int y);

    public Piece(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
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

    @Override
    public void move() {

    }

    @Override
    public boolean isPossibleMove() {
        return false;
    }
}
