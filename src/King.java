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

    public King(String color, int x, int y, boolean isFirstMove) {
        super(color, x, y);
        this.isFirstMove = isFirstMove;
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if ((moveToX == startX - 1 || moveToX == startX || moveToX == startX + 1) && (moveToY == startY - 1 || moveToY == startY || moveToY == startY + 1)) {
            if (moveToX < startX) {
                result = checkNorthDirectionsKing(startX, startY, moveToX, moveToY);
            } else if (moveToX > startX) {
                result = checkSouthDirectionsKing(startX, startY, moveToX, moveToY);
            } else {
                result = checkHorizontalDirectionsKing(startX, startY, moveToX, moveToY);
            }
        } else if ((moveToY == startY + 2 || moveToY == startY - 2) && isFirstMove()) {
            result = checkKingCastling(startX, startY, moveToX, moveToY);

        } else {
            result = false;
        }
        if (inCheck) {
            if (this.isInCheckmate()) {
                return false;
            }
        }
        result = result && !(inCheck);
        return result;
    }

    public boolean isPossibleMove2(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if ((moveToX == startX - 1 || moveToX == startX || moveToX == startX + 1) && (moveToY == startY - 1 || moveToY == startY || moveToY == startY + 1)) {
            if (moveToX < startX) {
                result = checkNorthDirectionsKing(startX, startY, moveToX, moveToY);
            } else if (moveToX > startX) {
                result = checkSouthDirectionsKing(startX, startY, moveToX, moveToY);
            } else {
                result = checkHorizontalDirectionsKing(startX, startY, moveToX, moveToY);
            }
        } else if ((moveToY == startY + 2 || moveToY == startY - 2) && isFirstMove()) {
            result = checkKingCastling(startX, startY, moveToX, moveToY);

        } else {
            result = false;
        }
        if (isInCheck(moveToX, moveToY) && result == false) {
            result = false;
        }
        return result;
    }



    public boolean isInCheck(int moveToX, int moveToY) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.board[i][j] != null && !(Board.board[i][j] instanceof King)) {
                    if (Board.board[i][j].isPossibleMove(i, j, moveToX, moveToY) && !(Board.board[i][j].getColor().equals(this.getColor()))) {
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
            if (!this.isPossibleMove2(getX(), getY(), (this.getX()+1), getY())) {
                result = true;
            } else if (!this.isPossibleMove2(getX(), getY(), (getX()-1),getY())) {
                result = true;
            } else if (!this.isPossibleMove2(getX(), getY(), getX(), (getY() - 1))) {
                result = true;
            } else if (!this.isPossibleMove2(getX(), getY(), getX(), (getY() + 1))) {
                result = true;
            }
        }
        return result;
    }

    private boolean checkKingCastling(int startX, int startY, int moveToX, int moveToY) {
        if (moveToY == startY + 2) {
            if (Board.board[startX][startY + 1] == null && Board.board[startX][startY + 2] == null) {
                return checkShortCastling(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        } else {
            if (Board.board[startX][startY - 1] == null && Board.board[startX][startY - 2] == null && Board.board[startX][startY - 3] == null) {
                return checkLongCastling(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        }
    }

    private boolean checkShortCastling(int startX, int startY, int moveToX, int moveToY) {
        if (Board.board[startX][startY + 3] instanceof Rook) {
            if (((Rook) Board.board[startX][startY + 3]).isFirstMove()) {
                Board.board[startX][startY+1] = new Rook(getColor(),startX,startY+1,false);
                Board.board[startX][startY + 3] = null;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkLongCastling(int startX, int startY, int moveToX, int moveToY) {
        if (Board.board[startX][startY - 4] instanceof Rook) {
            if (((Rook) Board.board[startX][startY - 4]).isFirstMove()) {
                Board.board[startX][startY-1] = new Rook(getColor(),startX,startY-1,false);
                Board.board[startX][startY - 4] = null;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
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
    public void move(int startX, int startY, int x, int y) {
        super.move(startX, startY, x, y);
        if (isFirstMove()) {
            setFirstMove(false);
        }
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