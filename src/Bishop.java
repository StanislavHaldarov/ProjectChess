public class Bishop extends Queen{
    public Bishop(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToX < startX && moveToY < startY) {
            if (startX - moveToX == startY - moveToY) {
                result = checkNorthwest(startX, startY, moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if (moveToX < startX && moveToY > startY) {
            if (startX - moveToX == moveToY - startY) {
                result = checkNortheast(startX, startY, moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if(moveToX > startX && moveToY > startY) {
            if (moveToX - startX == moveToY - startY) {
                result = checkSoutheast(startX, startY, moveToX, moveToY);
            } else {
                result = false;
            }
        }
        else if(moveToX > startX && moveToY < startY)
        {
            if (moveToX - startX == startY - moveToY) {
                result = checkSouthwest(startX, startY, moveToX, moveToY);
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
    public boolean checkNorthwest(int startX, int startY, int moveToX, int moveToY) {
        return super.checkNorthwest(startX, startY, moveToX, moveToY);
    }

    @Override
    public boolean checkNortheast(int startX, int startY, int moveToX, int moveToY) {
        return super.checkNortheast(startX, startY, moveToX, moveToY);
    }

    @Override
    public boolean checkSoutheast(int startX, int startY, int moveToX, int moveToY) {
        return super.checkSoutheast(startX, startY, moveToX, moveToY);
    }

    @Override
    public boolean checkSouthwest(int startX, int startY, int moveToX, int moveToY) {
        return super.checkSouthwest(startX, startY, moveToX, moveToY);
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
