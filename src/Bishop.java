public class Bishop extends Piece{
    public Bishop(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToX < startX && moveToY < startY) {
            if (startX - moveToX == startY - moveToY) {
                result = Diagonal.checkNorthwest(startX, startY, moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if (moveToX < startX && moveToY > startY) {
            if (startX - moveToX == moveToY - startY) {
                result = Diagonal.checkNortheast(startX, startY, moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if(moveToX > startX && moveToY > startY) {
            if (moveToX - startX == moveToY - startY) {
                result = Diagonal.checkSoutheast(startX, startY, moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if(moveToX > startX && moveToY < startY)
        {
            if (moveToX - startX == startY - moveToY) {
                result = Diagonal.checkSouthwest(startX, startY, moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else{
            result = false;
        }
        return result;
    }
    @Override
    public void move(int startX, int startY, int x, int y) {
        super.move(startX, startY, x, y);
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
