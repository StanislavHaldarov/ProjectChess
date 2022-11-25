public class King extends Piece {
    private boolean isFirstMove;

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public King(String color, int startX, int startY, boolean isFirstMove) {
        super(color, startX, startY);
        this.isFirstMove = isFirstMove;
    }

    @Override
    public boolean isPossibleMove(int moveToX, int moveToY) {
        if ((moveToX == getStartX() - 1 || moveToX == getStartX() || moveToX == getStartX() + 1) && (moveToY == getStartY() - 1 || moveToY == getStartY() || moveToY == getStartY() + 1)) {
            if (moveToX < getStartX()) {
                return checkNorthDirectionsKing(moveToX, moveToY);
            } else if (moveToX > getStartX()) {
                return checkSouthDirectionsKing(moveToX, moveToY);
            } else {
                return checkHorizontalDirectionsKing(moveToX, moveToY);
            }
        } else if ((moveToY == getStartY() + 2 || moveToY == getStartY() - 2) && isFirstMove()) {
            return checkKingCastling(moveToY);
        }
        return false;
    }

    private boolean checkKingCastling(int moveToY) {
        if (moveToY == getStartY() + 2) {
            if (Board.board[getStartX()][getStartY() + 1] == null && Board.board[getStartX()][getStartY() + 2] == null) {
                return checkShortCastling();
            } else {
                return false;
            }
        } else {
            if (Board.board[getStartX()][getStartY() - 1] == null && Board.board[getStartX()][getStartY() - 2] == null && Board.board[getStartX()][getStartY() - 3] == null) {
                return checkLongCastling();
            } else {
                return false;
            }
        }
    }

    private boolean checkShortCastling() {
        if (Board.board[getStartX()][getStartY() + 3] instanceof Rook) {
            if (((Rook) Board.board[getStartX()][getStartY() + 3]).isFirstMove()) {
                Board.board[getStartX()][getStartY() + 1] = new Rook(getColor(), getStartX(), getStartY() + 1, false);
                Board.board[getStartX()][getStartY() + 3] = null;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkLongCastling() {
        if (Board.board[getStartX()][getStartY() - 4] instanceof Rook) {
            if (((Rook) Board.board[getStartX()][getStartY() - 4]).isFirstMove()) {
                Board.board[getStartX()][getStartY() - 1] = new Rook(getColor(), getStartX(), getStartY() - 1, false);
                Board.board[getStartX()][getStartY() - 4] = null;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkNorthDirectionsKing(int moveToX, int moveToY) {
        boolean result;
        if (moveToY < getStartY()) {
            result = checkNorthwestKing(moveToX, moveToY);
        } else if (moveToY == getStartY()) {
            result = checkNorthKing(moveToX, moveToY);
        } else {
            result = checkNortheastKing(moveToX, moveToY);
        }
        return result;
    }

    private boolean checkSouthDirectionsKing(int moveToX, int moveToY) {
        boolean result;
        if (moveToY > getStartY()) {
            result = checkSoutheastKing(moveToX, moveToY);
        } else if (moveToY == getStartY()) {
            result = checkSouthKing(moveToX, moveToY);
        } else {
            result = checkSouthwestKing(moveToX, moveToY);
        }
        return result;
    }

    private boolean checkNorthKing(int moveToX, int moveToY) {
        if (getStartX() > 0) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[getStartX()][getStartY()].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkNorthwestKing(int moveToX, int moveToY) {
        if (getStartX() > 0 && getStartY() > 0) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[getStartX()][getStartY()].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkNortheastKing(int moveToX, int moveToY) {
        if (getStartX() > 0 && getStartY() < 7) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[getStartX()][getStartY()].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkSouthwestKing(int moveToX, int moveToY) {
        if (getStartX() < 7 && getStartY() > 0) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[getStartX()][getStartY()].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkSoutheastKing(int moveToX, int moveToY) {
        if (getStartX() < 7 && getStartY() < 7) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[getStartX()][getStartY()].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }
    }

    private boolean checkSouthKing(int moveToX, int moveToY) {
        if (getStartX() < 7) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[getStartX()][getStartY()].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }

    }

    private boolean checkEastKing(int moveToX, int moveToY) {
        if (getStartY() < 7) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[getStartX()][getStartY()].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }
    }

    private boolean checkWestKing(int moveToX, int moveToY) {
        if (getStartY() > 0) {
            return Board.board[moveToX][moveToY] == null || !(Board.board[getStartX()][getStartY()].getColor().equals(Board.board[moveToX][moveToY].getColor()));
        } else {
            return false;
        }
    }

    private boolean checkHorizontalDirectionsKing(int moveToX, int moveToY) {
        boolean result;
        if (moveToY < getStartY()) {
            result = checkWestKing(moveToX, moveToY);
        } else if (moveToY > getStartY()) {
            result = checkEastKing(moveToX, moveToY);
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public void move(int moveToX, int moveToY) {
        super.move(moveToX, moveToY);
        if (isFirstMove()) {
            setFirstMove(false);
        }

    }

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wK ";
        } else {
            return "bK ";
        }
    }
}