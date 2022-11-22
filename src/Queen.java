import jdk.jshell.Diag;

public class Queen extends Piece {
    public Queen(String color, int startX, int startY) {
        super(color, startX, startY);
    }

    @Override
    public boolean isPossibleMove(int moveToX, int moveToY) {
        if (moveToX < getStartX()) {
            if (checkNorthDirections(moveToX, moveToY)) {
                return Checkmate.isPossibleMove2(getColor(), moveToX, moveToY);
            }
        } else if (moveToX > getStartX()) {
            if (checkSouthDirections(moveToX, moveToY)) {
                return Checkmate.isPossibleMove2(getColor(), moveToX, moveToY);
            }
        } else {
            if (checkHorizontalDirections(moveToX, moveToY)) {
                return Checkmate.isPossibleMove2(getColor(), moveToX, moveToY);
            }
        }
        return false;
    }

    private boolean checkNorthDirections(int moveToX, int moveToY) {
        if (moveToY < getStartY()) {
            if (getStartX() - moveToX == getStartY() - moveToY) {
                return Diagonal.checkNorthwest(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return false;
            }
        } else if (moveToY == getStartY()) {
            return DirectionX.checkNorth(getStartX(), getStartY(), moveToX, moveToY);
        } else {
            if (getStartX() - moveToX == moveToY - getStartY()) {
                return Diagonal.checkNortheast(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return false;
            }
        }
    }

    private boolean checkSouthDirections(int moveToX, int moveToY) {
        if (moveToY > getStartY()) {
            if (moveToX - getStartX() == moveToY - getStartY()) {
                return Diagonal.checkSoutheast(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return false;
            }
        } else if (moveToY == getStartY()) {
            return DirectionX.checkSouth(getStartX(), getStartY(), moveToX, moveToY);
        } else {
            if (moveToX - getStartX() == getStartY() - moveToY) {
                return Diagonal.checkSouthwest(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                return false;
            }
        }
    }

    private boolean checkHorizontalDirections(int moveToX, int moveToY) {
        if (moveToY < getStartY()) {
            return DirectionY.checkWest(getStartX(), getStartY(), moveToX, moveToY);
        } else if (moveToY > getStartY()) {
            return DirectionY.checkEast(getStartX(), getStartY(), moveToX, moveToY);

        } else {
            return false;
        }
    }

    @Override
    public void testMove(int moveToX, int moveToY) {
        super.testMove(moveToX, moveToY);
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
}
