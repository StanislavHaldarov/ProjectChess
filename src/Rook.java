public class Rook extends Piece {
    private boolean isFirstMove;

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }
    public Rook(String color, int x, int y,boolean isFirstMove) {
        super(color, x, y);
        this.isFirstMove = isFirstMove;
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToX == startX && moveToY != startY) {
            if (moveToY > startY) {
                result = DirectionY.checkEast(startX, startY, moveToX, moveToY);
            } else {
                result = DirectionY.checkWest(startX, startY, moveToX, moveToY);
            }
        } else if (moveToX != startX && moveToY == startY) {
            if (moveToX > startX) {
                result = DirectionX.checkSouth(startX, startY, moveToX, moveToY);
            } else {
                result = DirectionX.checkNorth(startX, startY, moveToX, moveToY);
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
    public void move(int startX, int startY, int x, int y) {
        super.move(startX, startY, x, y);
        if (isFirstMove()) {
                setFirstMove(false);
            }

    }

}