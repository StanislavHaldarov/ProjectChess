package Pieces;

public class Rook extends Piece {

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public Rook(String color, int startX, int startY, boolean isFirstMove) {
        super(color, startX, startY);
        this.isFirstMove = isFirstMove;
    }

    @Override
    public boolean isValidMove(int moveToX, int moveToY) {
        if (moveToX == getStartX() && moveToY != getStartY()) {
            if (moveToY > getStartY()) {
                return Movements.DirectionY.checkEast(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return Movements.DirectionY.checkWest(getStartX(), getStartY(), moveToX, moveToY);
            }
        } else if (moveToX != getStartX() && moveToY == getStartY()) {
            if (moveToX > getStartX()) {
                return Movements.DirectionX.checkSouth(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return Movements.DirectionX.checkNorth(getStartX(), getStartY(), moveToX, moveToY);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wRk";
        } else {
            return "bRk";
        }
    }

    @Override
    public void move(int moveToX, int moveToY) {
        super.move(moveToX, moveToY);
        if (isFirstMove()) {
            setFirstMove(false);
        }

    }
    private boolean isFirstMove;
}