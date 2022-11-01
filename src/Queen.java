public class Queen extends Piece {
    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if(moveToX<startX){
            if(moveToY < startY){
                if(startX-moveToX == startY-moveToY) {
                    result = checkQueenNorthwest(startX, startY, moveToX, moveToY);
                } else{
                    result = false;
                }
            } else if(moveToY==startY){
                result = checkQueenNorth(startX, startY, moveToX, moveToY);
            } else{
                if(startX-moveToX == moveToY-startY) {
                    result = checkQueenNortheast(startX, startY, moveToX, moveToY);
                } else{
                    result = false;
                }
            }
            return result;
        }else if(moveToX>startX){
            if(moveToY > startY){
                if(moveToX-startX == moveToY-startY) {
                    result = checkQueenSoutheast(startX, startY, moveToX, moveToY);
                } else{
                    result = false;
                }
            } else if(moveToY == startY){
                result = checkQueenSouth(startX, startY, moveToX, moveToY);
            } else{
                if(moveToX-startX == startY-moveToY) {
                    result = checkQueenSouthwest(startX, startY, moveToX, moveToY);
                } else{
                    result = false;
                }
            }
            return result;
        } else{
            if (moveToY < startY) //west
            {
                result = checkQueenWest(startX, startY, moveToX, moveToY);
                return result;
            }
            if (moveToY > startY) //east
            {
                result = checkQueenEast(startX, startY, moveToX, moveToY);
                return result;
            }
        }
        return false;
    }

    private boolean checkQueenWest(int startX, int startY, int moveToX, int moveToY) {
        if (startY > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startY - 1; i < (startY - moveToY); i--) {
                    if (Board.board[moveToX][i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkQueenEast(int startX, int startY, int moveToX, int moveToY) {
        if (startY < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startY + 1; i < (moveToY - startY); i++) {
                    if (Board.board[moveToX][i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkQueenNorth(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startX - 1; i < (startX - moveToX); i--) {
                    if (Board.board[i][moveToY] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkQueenSouth(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startX + 1; i < (moveToX - startX); i++) {
                    if (Board.board[i][moveToY] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkQueenNorthwest(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = 1; i < (startX - moveToX); i++) {
                    if (Board.board[startX - i][startY - i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkQueenNortheast(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY <7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = 1; i < (startX - moveToX); i++) {
                    if (Board.board[startX - i][startY + i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkQueenSoutheast(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7 && startY < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = 1; i < (moveToX - startX); i++) {
                    if (Board.board[startX + i][startY + i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkQueenSouthwest(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7 && startY > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = 1; i < (moveToX - startX); i++) {
                    if (Board.board[startX + i][startY - i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void move(int startX, int startY, int x, int y) {
        boolean isPossibleMove = isPossibleMove(startX, startY, x, y);
        if (isPossibleMove) {
            Board.board[x][y] = Board.board[startX][startY];
            Board.board[startX][startY] = null;
        } else {
            System.out.println("Not possible move!");
        }
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
