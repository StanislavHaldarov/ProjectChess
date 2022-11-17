public class Bishop extends Piece{
    public Bishop(String color, int startX, int startY) {
        super(color, startX, startY);
    }

    @Override
    public boolean isPossibleMove(int moveToX, int moveToY) {
        boolean result;
        if (moveToX < getStartX() && moveToY < getStartY()) {
            if (getStartX() - moveToX == getStartY() - moveToY) {
                result = Diagonal.checkNorthwest(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if (moveToX < getStartX() && moveToY > getStartY()) {
            if (getStartX() - moveToX == moveToY - getStartY()) {
                result = Diagonal.checkNortheast(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if(moveToX > getStartX() && moveToY > getStartY()) {
            if (moveToX - getStartX() == moveToY - getStartY()) {
                result = Diagonal.checkSoutheast(getStartX(), getStartY(), moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if(moveToX > getStartX() && moveToY < getStartY())
        {
            if (moveToX - getStartX() == getStartY() - moveToY) {
                result = Diagonal.checkSouthwest(getStartX(), getStartY(), moveToX, moveToY);
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
}
