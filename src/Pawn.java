import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pawn extends Piece {
    private boolean isFirstMove;
    private int movesCount;

    public int getMovesCount() {
        return movesCount;
    }

    public void setMovesCount(int movesCount) {
        this.movesCount = movesCount;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public Pawn(String color, int startX, int startY, boolean isFirstMove, int movesCount) {
        super(color, startX, startY);
        this.isFirstMove = isFirstMove;
        this.movesCount = movesCount;
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        boolean result = false;
        if (getColor().equalsIgnoreCase("white")) {
            if (moveToX == startX - 1 && moveToY == startY - 1) {
                result = checkWhiteWestDiagonal(startX, startY, moveToX, moveToY);
            } else if (moveToX == startX - 1 && moveToY == startY + 1) {
                result = checkWhiteEastDiagonal(startX, startY, moveToX, moveToY);
            } else if (moveToX == (startX - 2) && moveToY == startY) {
                result = checkWhiteIfFirstMove(startX, startY, moveToX, moveToY);
            } else if (moveToX == startX - 1 && moveToY == startY) {
                result = checkWhiteFront(startX, startY, moveToX, moveToY);
            }
        } else {
            if (moveToX == startX + 1 && moveToY == startY - 1) {
                result = checkBlackWestDiagonal(startX, startY, moveToX, moveToY);
            } else if (moveToX == startX + 1 && moveToY == startY + 1) {
                result = checkBlackEastDiagonal(startX, startY, moveToX, moveToY);
            } else if (moveToX == (startX + 2) && moveToY == startY) {
                result = checkBlackIfFirstMove(startX, startY, moveToX, moveToY);
            } else if (moveToX == startX + 1 && moveToY == startY) {
                result = checkBlackFront(startX, startY, moveToX, moveToY);
            }
        }
        return result;
    }

    private boolean checkBlackFront(int startX, int startY, int moveToX, int moveToY) {
        if (moveToX == (startX + 1)) {
            return Board.board[startX + 1][startY] == null;
        } else {
            return false;
        }
    }

    private boolean checkWhiteFront(int startX, int startY, int moveToX, int moveToY) {
        if (moveToX == (startX - 1)) {
            return Board.board[startX - 1][startY] == null;
        } else {
            return false;
        }
    }

    private boolean checkBlackIfFirstMove(int startX, int startY, int moveToX, int moveToY) {
        if (isFirstMove()) {
            if (moveToX == (startX + 2)) {
                return Board.board[startX + 2][startY] == null && Board.board[startX + 1][startY] == null;
            } else {
                return checkBlackFront(startX, startY, moveToX, moveToY);
            }
        } else {
            return checkBlackFront(startX, startY, moveToX, moveToY);
        }
    }

    private boolean checkWhiteIfFirstMove(int startX, int startY, int moveToX, int moveToY) {
        if (isFirstMove()) {
            if (moveToX == (startX - 2)) {
                return Board.board[startX - 2][startY] == null && Board.board[startX - 1][startY] == null;
            } else {
                return checkWhiteFront(startX, startY, moveToX, moveToY);
            }
        } else {
            return checkWhiteFront(startX, startY, moveToX, moveToY);
        }
    }


    private boolean checkWhiteWestDiagonal(int startX, int startY, int moveToX, int moveToY) {
        if (startY != 0) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("white"));
            } else {
                if(startX == 3) {
                    if (Board.board[startX][startY - 1] != null) {
                        if (Board.board[startX][startY - 1] instanceof Pawn) {
                            return Board.board[startX][startY - 1].getColor().equalsIgnoreCase("black") && ((Pawn) Board.board[startX][startY - 1]).getMovesCount() == 1;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkWhiteEastDiagonal(int startX, int startY, int moveToX, int moveToY) {
        if (startY != 7) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("white"));
            } else {
                if (startX == 3)
                    if (Board.board[startX][startY + 1] != null) {
                        if (Board.board[startX][startY + 1] instanceof Pawn) {
                            return Board.board[startX][startY + 1].getColor().equalsIgnoreCase("black") && ((Pawn) Board.board[startX][startY + 1]).getMovesCount() == 1;

                        }
                    }

            }
        }
        return false;
    }

    private boolean checkBlackWestDiagonal(int startX, int startY, int moveToX, int moveToY) {
        if (startY != 0) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("black"));
            } else {
                if(startX == 4) {
                    if (Board.board[startX][startY - 1] != null) {
                        if (Board.board[startX][startY - 1] instanceof Pawn) {
                            return Board.board[startX][startY - 1].getColor().equalsIgnoreCase("white") && ((Pawn) Board.board[startX][startY - 1]).getMovesCount() == 1;
                        }
                    }
                }
            }
        }
        return false;
    }


    private boolean checkBlackEastDiagonal(int startX, int startY, int moveToX, int moveToY) {
        if (startY != 7) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("black"));
            } else {
                if(startX == 3) {
                    if (Board.board[startX][startY + 1] != null) {
                        if (Board.board[startX][startY + 1] instanceof Pawn) {
                            return Board.board[startX][startY + 1].getColor().equalsIgnoreCase("white") && ((Pawn) Board.board[startX][startY + 1]).getMovesCount() == 1;
                        }
                    }
                }
            }
        }
        return false;
    }
    private void checkEnPassant(int x, int y)
    {
        if (getColor().equalsIgnoreCase("black")) {
            if (Board.board[x-1][y] != null){
                if ((Board.board[x-1][y].getColor().equalsIgnoreCase("white") && ((Pawn) Board.board[x-1][y]).getMovesCount() == 1)) {
                    Board.board[x-1][y] = null;
                }
            }
        } else {
            if (Board.board[x+1][y] != null) {
                if ((Board.board[x+1][y].getColor().equalsIgnoreCase("black") && ((Pawn) Board.board[x+1][y]).getMovesCount() == 1)) {
                    Board.board[x+1][y] = null;
                }
            }

        }
    }
    public void changePawn(int startX, int startY) {
        Piece piece = askUserToChange(startX, startY);
        Board.board[startX][startY] = piece;
    }

    private boolean checkEndRows(int x) {
        return (x == 0 || x == 7);
    }

    private Piece askUserToChange(int x, int y) {
        int timesError = 0;
        String[] possiblePieces = {"R", "K", "B", "Q"};
        List<String> possiblePieceList = new ArrayList<>(Arrays.asList(possiblePieces));
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a piece to change into (R-K-B-Q): ");
        String pieceChoice = " ";
        while (true) {
            if (timesError >= 3) {
                System.out.println("Too many invalid inputs! Queen chosen/default option/!");
                break;
            }
            pieceChoice = scan.next();
            if (possiblePieceList.contains(pieceChoice)) {
                break;
            }
            timesError++;
            System.out.print("Invalid input! Please enter again (R-K-B-Q): ");
        }
        return switch (pieceChoice) {
            case "R" -> new Rook(this.getColor(), x, y, false);
            case "K" -> new Knight(this.getColor(), x, y);
            case "B" -> new Bishop(this.getColor(), x, y);
            default -> new Queen(this.getColor(), x, y);
        };
    }

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wPn";
        } else {
            return "bPn";
        }
    }
    public void moveWithRunnable(int startX, int startY, int x, int y, Runnable callback){
        if (isPossibleMove(startX,startY,x,y)) {
            Board.board[x][y] = Board.board[startX][startY];
            Board.board[startX][startY] = null;
            callback.run();
        }
    }
    @Override
    public void move(int startX, int startY, int x, int y) {
        setMovesCount(movesCount + 1);
        moveWithRunnable(startX, startY, x, y, () -> {
            if (checkEndRows(x)) {
                changePawn(x, y);
            }
        });
        checkEnPassant(x, y);
        if (isFirstMove()) {
                setFirstMove(false);
            }

    }
}
