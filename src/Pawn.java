public class Pawn extends Piece {
    private boolean isFirstMove;

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public Pawn(String color, int startX, int startY, boolean isFirstMove) {
        super(color, startX, startY);
        this.isFirstMove = true;
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (getColor().equalsIgnoreCase("white")) {
            if ((moveToX == startX - 1 && moveToY == startY - 1) || (moveToX == startX - 1 && moveToY == startY + 1)) {
                result = checkWhiteDiagonals(startX, startY, moveToX, moveToY);
            } else {
                result = checkWhiteIfFirstMove(startX, startY, moveToX, moveToY);
            }
        } else {
            if ((moveToX == startX + 1 && moveToY == startY - 1) || (moveToX == startX + 1 && moveToY == startY + 1)) {
                result = checkBlackDiagonals(startX, startY, moveToX, moveToY);
            } else {
                result = checkBlackIfFirstMove(startX, startY, moveToX, moveToY);
            }
        }
        return result;
    }

    private boolean checkBlackIfFirstMove(int startX, int startY, int moveToX, int moveToY) {
        if (isFirstMove()) {
            if (moveToX == (startX + 1)) {
                if (Board.board[startX + 1][startY] != null) {
                    return false;
                } else {
                    setFirstMove(false);
                    return true;
                }
            } else if (moveToX == (startX + 2)) {
                if (Board.board[startX + 2][startY] != null || Board.board[startX - 1][startY] != null) {
                    return false;
                } else {
                    setFirstMove(false);
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkWhiteIfFirstMove(int startX, int startY, int moveToX, int moveToY) {
        if (isFirstMove()) {
            if (moveToX == (startX - 1)) {
                if (Board.board[startX - 1][startY] != null) {
                    return false;
                } else {
                    setFirstMove(false);
                    return true;
                }
            } else if (moveToX == (startX - 2)) {
                if (Board.board[startX - 2][startY] != null || Board.board[startX - 1][startY] != null) {
                    return false;
                } else {
                    setFirstMove(false);
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkBlackDiagonals(int startX, int startY, int moveToX, int moveToY) {
        setFirstMove(false);
        if (startY == 0 || startY == 7) {
            if (startY == 0) {
                if (Board.board[startX + 1][startY + 1] != null) {
                    if (!(Board.board[startX + 1][startY + 1].getColor().equalsIgnoreCase("black"))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (Board.board[startX + 1][startY - 1] != null) {
                    if (!(Board.board[startX + 1][startY - 1].getColor().equalsIgnoreCase("black"))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } else {
            if (Board.board[startX + 1][startY + 1] != null || Board.board[startX + 1][startY - 1] != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean checkWhiteDiagonals(int startX, int startY, int moveToX, int moveToY) {
        setFirstMove(false);
        if (startY == 0 || startY == 7) {
            if (startY == 0) {
                if (Board.board[startX - 1][startY + 1] != null) {
                    if (!(Board.board[startX - 1][startY + 1].getColor().equalsIgnoreCase("white"))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (Board.board[startX - 1][startY - 1] != null) {
                    if (!(Board.board[startX - 1][startY - 1].getColor().equalsIgnoreCase("white"))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wPn";
        } else {
            return "bPn";
        }
    }

    @Override
    public void move(int startX, int startY, int x, int y) {
        super.move(startX,startY,x,y);
    }
}
