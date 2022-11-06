import jdk.jshell.Diag;

public class Queen extends Piece {
    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToX < startX) {
            result = checkNorthDirections(startX, startY, moveToX, moveToY);
        } else if (moveToX > startX) {
            result = checkSouthDirections(startX, startY, moveToX, moveToY);
        } else {
            result = checkHorizontalDirections(startX,startY,moveToX,moveToY);
        }
//        if(!(Board.board[moveToX][moveToY] instanceof King) && result){
//            result = true;
//        } else {
//            result = false;
//        }
        return result;
    }

    private boolean checkNorthDirections(int startX, int startY, int moveToX, int moveToY) {
        if (moveToY < startY) {
            if (startX - moveToX == startY - moveToY) {
                return Diagonal.checkNorthwest(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        } else if (moveToY == startY) {
            return DirectionX.checkNorth(startX, startY, moveToX, moveToY);
        } else {
            if (startX - moveToX == moveToY - startY) {
                return Diagonal.checkNortheast(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        }
    }

    private boolean checkSouthDirections(int startX, int startY, int moveToX, int moveToY) {
        if (moveToY > startY) {
            if (moveToX - startX == moveToY - startY) {
                return Diagonal.checkSoutheast(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        } else if (moveToY == startY) {
            return DirectionX.checkSouth(startX, startY, moveToX, moveToY);
        } else {
            if (moveToX - startX == startY - moveToY) {
                return Diagonal.checkSouthwest(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        }
    }
    private boolean checkHorizontalDirections(int startX, int startY, int moveToX, int moveToY) {
        if (moveToY < startY) {
            return DirectionY.checkWest(startX, startY, moveToX, moveToY);
        } else if (moveToY > startY) {
            return DirectionY.checkEast(startX, startY, moveToX, moveToY);

        } else {
            return false;
        }
    }
    @Override
    public void move(int startX, int startY, int x, int y) {
        super.move(startX,startY,x,y);
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
