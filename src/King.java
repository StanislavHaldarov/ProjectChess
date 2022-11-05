public class King extends Piece {

    public King(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if((moveToX == startX - 1 || moveToX == startX || moveToX == startX + 1) && (moveToY == startY - 1 || moveToY == startY || moveToY == startY + 1)) {
            if (moveToX < startX) {
                result = checkNorthDirectionsKing(startX, startY, moveToX, moveToY);
            } else if (moveToX > startX) {
                result = checkSouthDirectionsKing(startX, startY, moveToX, moveToY);
            } else {
                result = checkHorizontalDirectionsKing(startX, startY, moveToX, moveToY);
            }
        }
        else{
            result = false;
        }
        return result;
    }
    private boolean checkNorthDirectionsKing(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToY < startY) {
            result = checkNorthwestKing(startX, startY, moveToX, moveToY);
        } else if (moveToY == startY) {
            result = checkNorthKing(startX, startY, moveToX, moveToY);
        } else {
            result = checkNortheastKing(startX, startY, moveToX, moveToY);
        }
        return result;
    }

    private boolean checkSouthDirectionsKing(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToY > startY) {
            result = checkSoutheastKing(startX, startY, moveToX, moveToY);
        } else if (moveToY == startY) {
            result = checkSouthKing(startX, startY, moveToX, moveToY);
        } else {
            result = checkSouthwestKing(startX, startY, moveToX, moveToY);
        }
        return result;
    }

    private boolean checkNorthKing(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkNorthwestKing(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY > 0) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkNortheastKing(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY < 7) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkSouthwestKing(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7 && startY > 0) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkSoutheastKing(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7 && startY < 7) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkSouthKing(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkEastKing(int startX, int startY, int moveToX, int moveToY) {

        if (startY < 7) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }
    }

    private boolean checkWestKing(int startX, int startY, int moveToX, int moveToY) {
        if (startY > 0) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }
    }

    private boolean checkHorizontalDirectionsKing(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToY < startY) {
            result = checkWestKing(startX, startY, moveToX, moveToY);
        } else if (moveToY > startY) {
            result = checkEastKing(startX, startY, moveToX, moveToY);
        } else {
            result = false;
        }
        return result;
    }


    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wK";
        } else {
            return "bK";
        }
    }
}
