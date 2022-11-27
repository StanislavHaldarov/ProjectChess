package Pieces;

public class Bishop extends Piece {
    public Bishop(String color, int startX, int startY) {
        super(color, startX, startY);
    }


    @Override
    public boolean isValidMove(int moveToX, int moveToY) {
        if (getStartX() < moveToX) {
            return checkSouthDiagonals(moveToX, moveToY);
        } else if (getStartX() > moveToX) {
            return checkNorthDiagonals(moveToX, moveToY);
        }
        return false;
    }

    @Override
    public void move(int moveToX, int moveToY) {
        super.move(moveToX, moveToY);
    }

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wBp";
        } else {
            return "bBp";
        }
    }

    private boolean checkSouthDiagonals(int moveToX, int moveToY) {
        if (moveToY > getStartY()) {
            if (moveToX - getStartX() == moveToY - getStartY()) {
                return Movements.Diagonal.checkSoutheast(getStartX(), getStartY(), moveToX, moveToY);
            }
        } else if (moveToY < getStartY()) {
            if (moveToX - getStartX() == getStartY() - moveToY) {
                return Movements.Diagonal.checkSouthwest(getStartX(), getStartY(), moveToX, moveToY);
            }
        }
        return false;
    }

    private boolean checkNorthDiagonals(int moveToX, int moveToY) {
        if (moveToY < getStartY()) {
            if (getStartX() - moveToX == getStartY() - moveToY) {
                return Movements.Diagonal.checkNorthwest(getStartX(), getStartY(), moveToX, moveToY);
            }
        } else if (moveToY > getStartY()) {
            if (getStartX() - moveToX == moveToY - getStartY()) {
                return Movements.Diagonal.checkNortheast(getStartX(), getStartY(), moveToX, moveToY);
            }
        }
        return false;
    }
}
