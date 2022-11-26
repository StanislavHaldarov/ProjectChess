package Pieces;

public class Queen extends Piece {
    public Queen(String color, int startX, int startY) {
        super(color, startX, startY);
    }

    @Override
    public boolean isValidMove(int moveToX, int moveToY) {
        if (moveToX < getStartX()) {
            return checkNorthDirections(moveToX, moveToY);
        } else if (moveToX > getStartX()) {
            return checkSouthDirections(moveToX, moveToY);
        } else {
            return checkHorizontalDirections(moveToX, moveToY);
        }
    }
    @Override
    public void move(int moveToX, int moveToY) {
        super.move(moveToX, moveToY);
    }

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wQn";
        } else {
            return "bQn";
        }
    }
    private boolean checkNorthDirections(int moveToX, int moveToY) {
        if (moveToY < getStartY()) {
            if (getStartX() - moveToX == getStartY() - moveToY) {
                return Movements.Diagonal.checkNorthwest(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return false;
            }
        } else if (moveToY == getStartY()) {
            return Movements.DirectionX.checkNorth(getStartX(), getStartY(), moveToX, moveToY);
        } else {
            if (getStartX() - moveToX == moveToY - getStartY()) {
                return Movements.Diagonal.checkNortheast(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return false;
            }
        }
    }

    private boolean checkSouthDirections(int moveToX, int moveToY) {
        if (moveToY > getStartY()) {
            if (moveToX - getStartX() == moveToY - getStartY()) {
                return Movements.Diagonal.checkSoutheast(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return false;
            }
        } else if (moveToY == getStartY()) {
            return Movements.DirectionX.checkSouth(getStartX(), getStartY(), moveToX, moveToY);
        } else {
            if (moveToX - getStartX() == getStartY() - moveToY) {
                return Movements.Diagonal.checkSouthwest(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return false;
            }
        }
    }

    private boolean checkHorizontalDirections(int moveToX, int moveToY) {
        if (moveToY < getStartY()) {
            return Movements.DirectionY.checkWest(getStartX(), getStartY(), moveToX, moveToY);
        } else if (moveToY > getStartY()) {
            return Movements.DirectionY.checkEast(getStartX(), getStartY(), moveToX, moveToY);

        } else {
            return false;
        }
    }
}