public class Bishop extends Piece {
    public Bishop(String color, int startX, int startY) {
        super(color, startX, startY);
    }

    @Override
    public boolean isPossibleMove(int moveToX, int moveToY) {
        if (getStartX() < moveToX) {
            return checkSouthDiagonals(moveToX, moveToY);
        } else if (getStartX() > moveToX) {
            return checkNorthDiagonals(moveToX, moveToY);
        }
        return false;
    }

    private boolean checkSouthDiagonals(int moveToX, int moveToY) {
        if (moveToY > getStartY()) {
            if (moveToX - getStartX() == moveToY - getStartY()) {
                return Diagonal.checkSoutheast(getStartX(), getStartY(), moveToX, moveToY);
            }
        } else if (moveToY < getStartY()) {
            if (moveToX - getStartX() == getStartY() - moveToY) {
                return Diagonal.checkSouthwest(getStartX(), getStartY(), moveToX, moveToY);
            }
        }
        return false;
    }

    private boolean checkNorthDiagonals(int moveToX, int moveToY) {
        if (moveToY < getStartY()) {
            if (getStartX() - moveToX == getStartY() - moveToY) {
                return Diagonal.checkNorthwest(getStartX(), getStartY(), moveToX, moveToY);
            }
        } else if (moveToY > getStartY()) {
            if (getStartX() - moveToX == moveToY - getStartY()) {
                return Diagonal.checkNortheast(getStartX(), getStartY(), moveToX, moveToY);
            }
        }
        return false;
    }
    @Override
    public void move(int moveToX, int moveToY) {
        super.move(moveToX, moveToY);
    }

    @Override
    public void testMove(int moveToX, int moveToY) {
        super.testMove(moveToX, moveToY);
    }

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wBp";
        } else {
            return "bBp";
        }
    }
}
