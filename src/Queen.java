public class Queen extends Piece implements DirectionX, DirectionY, Diagonal {
    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result;
        if (moveToX < startX) {
            result = checkNorthDirections(startX, startY, moveToX, moveToY);
            return result;
        } else if (moveToX > startX) {
            result = checkSouthDirections(startX, startY, moveToX, moveToY);
            return result;
        } else {
            result = checkHorizontalDirections(startX,startY,moveToX,moveToY);
            return result;
        }
    }

    private boolean checkNorthDirections(int startX, int startY, int moveToX, int moveToY) {
        if (moveToY < startY) {
            if (startX - moveToX == startY - moveToY) {
                return checkNorthwest(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        } else if (moveToY == startY) {
            return checkNorth(startX, startY, moveToX, moveToY);
        } else {
            if (startX - moveToX == moveToY - startY) {
                return checkNortheast(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        }
    }

    private boolean checkSouthDirections(int startX, int startY, int moveToX, int moveToY) {
        if (moveToY > startY) {
            if (moveToX - startX == moveToY - startY) {
                return checkSoutheast(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        } else if (moveToY == startY) {
            return checkSouth(startX, startY, moveToX, moveToY);
        } else {
            if (moveToX - startX == startY - moveToY) {
                return checkSouthwest(startX, startY, moveToX, moveToY);
            } else {
                return false;
            }
        }
    }

    private boolean checkHorizontalDirections(int startX, int startY, int moveToX, int moveToY) {
        if (moveToY < startY) {
            return checkWest(startX, startY, moveToX, moveToY);
        } else if (moveToY > startY) {
            return checkEast(startX, startY, moveToX, moveToY);

        } else {
            return false;
        }
    }

    public boolean checkWest(int startX, int startY, int moveToX, int moveToY) {
        if (startY > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = moveToY+ 1; i < startY; i++) {
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

    public boolean checkEast(int startX, int startY, int moveToX, int moveToY) {
        if (startY < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startY + 1; i < moveToY; i++) {
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

    public boolean checkNorth(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = moveToX+1; i < startX; i++) {
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

    public boolean checkSouth(int startX, int startY, int moveToX, int moveToY) {
        if (startX < 7) {
            if (Board.board[moveToX][moveToY] == null || !(Board.board[startX][startY].getColor().equals(Board.board[moveToX][moveToY].getColor()))) {
                for (int i = startX + 1; i < moveToX; i++) {
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

    public boolean checkNorthwest(int startX, int startY, int moveToX, int moveToY) {
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

    public boolean checkNortheast(int startX, int startY, int moveToX, int moveToY) {
        if (startX > 0 && startY < 7) {
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

    public boolean checkSoutheast(int startX, int startY, int moveToX, int moveToY) {
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

    public boolean checkSouthwest(int startX, int startY, int moveToX, int moveToY) {
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
        super.move(startX,startY,x,y);
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
