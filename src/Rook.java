public class Rook extends Queen {
    public Rook(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToX == startX && moveToY != startY) {
            if (moveToY > startY) {
                result = checkEast(startX, startY, moveToX, moveToY);
            } else {
                result = checkWest(startX, startY, moveToX, moveToY);
            }
        }
        else if(moveToX != startX && moveToY == startY) {
            if (moveToX > startX) {
                result = checkSouth(startX, startY, moveToX, moveToY);
            } else {
                result = checkNorth(startX, startY, moveToX, moveToY);
            }
        }
        else{
            result = false;
        }
        return result;
    }


    @Override
    public boolean checkNorth(int startX, int startY, int moveToX, int moveToY) {
        return super.checkNorth(startX, startY, moveToX, moveToY);
    }

    @Override
    public boolean checkSouth(int startX, int startY, int moveToX, int moveToY) {
        return super.checkSouth(startX, startY, moveToX, moveToY);
    }

    @Override
    public boolean checkWest(int startX, int startY, int moveToX, int moveToY) {
        return super.checkWest(startX, startY, moveToX, moveToY);
    }

    @Override
    public boolean checkEast(int startX, int startY, int moveToX, int moveToY) {
        return super.checkEast(startX, startY, moveToX, moveToY);
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
        super.move(startX,startY,x,y);
    }

}