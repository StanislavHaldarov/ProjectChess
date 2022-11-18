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
        boolean result;
        if (moveToX == getStartX() && moveToY != getStartY()) {
            if (moveToY > getStartY()) {
                result = DirectionY.checkEast(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                result = DirectionY.checkWest(getStartX(), getStartY(), moveToX, moveToY);
            }
        } else if (moveToX != getStartX() && moveToY == getStartY()) {
            if (moveToX > getStartX()) {
                result = DirectionX.checkSouth(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                result = DirectionX.checkNorth(getStartX(), getStartY(), moveToX, moveToY);
            }
        } else {
            result = false;
        }
        return result;
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