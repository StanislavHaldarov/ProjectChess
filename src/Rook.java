public class Rook extends Piece {
    private boolean isFirstMove;

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
    public boolean isPossibleMove(int moveToX, int moveToY) {
        if (moveToX == getStartX() && moveToY != getStartY()) {
            if (moveToY > getStartY()) {
                if (DirectionY.checkEast(getStartX(), getStartY(), moveToX, moveToY)) {
                    return !Checkmate.isInCheck(getColor(), getStartX(), getStartY(), moveToX, moveToY);
                }
            } else {
                if (DirectionY.checkWest(getStartX(), getStartY(), moveToX, moveToY)) {
                    return !Checkmate.isInCheck(getColor(), getStartX(), getStartY(), moveToX, moveToY);
                }
            }
        } else if (moveToX != getStartX() && moveToY == getStartY()) {
            if (moveToX > getStartX()) {
                if (DirectionX.checkSouth(getStartX(), getStartY(), moveToX, moveToY)) {
                    return !Checkmate.isInCheck(getColor(), getStartX(), getStartY(), moveToX, moveToY);
                }
            } else {
                if (DirectionX.checkNorth(getStartX(), getStartY(), moveToX, moveToY)) {
                    return !Checkmate.isInCheck(getColor(), getStartX(), getStartY(), moveToX, moveToY);
                }
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
    public void testMove(int moveToX, int moveToY) {
        super.testMove(moveToX, moveToY);
    }

    @Override
    public void move(int moveToX, int moveToY) {
        super.move(moveToX, moveToY);
        if (isFirstMove()) {
            setFirstMove(false);
        }

    }

}