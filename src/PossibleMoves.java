public class PossibleMoves {
    private int startX;
    private int startY;
    private int moveToX;
    private int moveToY;
    private int value;

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

    public int getMoveToX() {
        return moveToX;
    }

    public void setMoveToX(int moveToX) {
        this.moveToX = moveToX;
    }

    public int getMoveToY() {
        return moveToY;
    }

    public void setMoveToY(int moveToY) {
        this.moveToY = moveToY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PossibleMoves(int startX, int startY, int moveToX, int moveToY, int value) {
        this.startX = startX;
        this.startY = startY;
        this.moveToX = moveToX;
        this.moveToY = moveToY;
        this.value = value;
    }
}
