import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private boolean isFirstMove;
    static boolean inCheck = false;

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
        boolean result;
        if ((moveToX == getStartX() - 1 || moveToX == getStartX() || moveToX == getStartX() + 1) && (moveToY == getStartY() - 1 || moveToY == getStartY() || moveToY == getStartY() + 1)) {
            if (moveToX < getStartX()) {
                result = checkNorthDirectionsKing(moveToX, moveToY);
            } else if (moveToX > getStartX()) {
                result = checkSouthDirectionsKing(moveToX, moveToY);
            } else {
                result = checkHorizontalDirectionsKing(moveToX, moveToY);
            }
        } else if ((moveToY == getStartY() + 2 || moveToY == getStartY() - 2) && isFirstMove()) {
            result = checkKingCastling(moveToY);

        } else {
            result = false;
        }
//        if (inCheck) {
//            if (this.isInCheckmate()) {
//                return false;
//            }
//        }
//        result = result && !(inCheck);
        return result;
    }

    public boolean isPossibleMove2(int moveToX, int moveToY) {
        boolean result;
        if ((moveToX == getStartX() - 1 || moveToX == getStartX() || moveToX == getStartX() + 1) && (moveToY == getStartY() - 1 || moveToY == getStartY() || moveToY == getStartY() + 1)) {
            if (moveToX < getStartX()) {
                result = checkNorthDirectionsKing(moveToX, moveToY);
            } else if (moveToX > getStartX()) {
                result = checkSouthDirectionsKing(moveToX, moveToY);
            } else {
                result = checkHorizontalDirectionsKing(moveToX, moveToY);
            }
        } else if ((moveToY == getStartY() + 2 || moveToY == getStartY() - 2) && isFirstMove()) {
            result = checkKingCastling(moveToY);

        } else {
            result = false;
        }
        if (isInCheck(moveToX, moveToY) && !result) {
            result = false;
        }
        return result;
    }


    public boolean isInCheck(int moveToX, int moveToY) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.board[i][j] != null && !(Board.board[i][j] instanceof King)) {
                    if (Board.board[i][j].isPossibleMove(moveToX, moveToY) && !(Board.board[i][j].getColor().equals(this.getColor()))) {
                        this.inCheck = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isInCheckmate() {
        boolean result = false;
        if (inCheck) {
            if (!this.isPossibleMove2((getStartX() + 1), getStartY())) {
                result = true;
            } else if (!this.isPossibleMove2((getStartX() - 1), getStartY())) {
                result = true;
            } else if (!this.isPossibleMove2( getStartX(), (getStartY() - 1))) {
                result = true;
            } else if (!this.isPossibleMove2( getStartX(), (getStartY() + 1))) {
                result = true;
            }
        }
        return result;
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
            result = checkNortheastKing( moveToX, moveToY);
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
    public void testMove(int moveToX, int moveToY) {
        super.testMove(moveToX, moveToY);
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