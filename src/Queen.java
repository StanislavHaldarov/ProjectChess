import jdk.jshell.Diag;

public class Queen extends Piece {
    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int moveToX, int moveToY) {
        boolean result;
        if (moveToX < getStartX()) {
            result = checkNorthDirections(moveToX, moveToY);
        } else if (moveToX > getStartX()) {
            result = checkSouthDirections(moveToX, moveToY);
        } else {
            result = checkHorizontalDirections(moveToX,moveToY);
        }
//        if(!(Board.board[moveToX][moveToY] instanceof King) && result){
//            result = true;
//        } else {
//            result = false;
//        }
        return result;
    }

    private boolean checkNorthDirections(int moveToX, int moveToY) {
        if (moveToY < getStartX()) {
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
    public void move(int x, int y) {
        super.move(x,y);
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
