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
    public boolean isPossibleMove(int moveToX, int moveToY) {
        boolean result = false;
        if (getColor().equalsIgnoreCase("white")) {
            if (moveToX == getStartX() - 1 && moveToY == getStartY() - 1) {
                result = checkWhiteWestDiagonal(moveToX, moveToY);
            } else if (moveToX == getStartX() - 1 && moveToY == getStartY() + 1) {
                result = checkWhiteEastDiagonal(moveToX, moveToY);
            } else if (moveToX == getStartX() - 2 && moveToY == getStartY()) {
                result = checkWhiteIfFirstMove(moveToX, moveToY);
            } else if (moveToX == getStartX() - 1 && moveToY == getStartY()) {
                result = checkWhiteFront(moveToX);
            }
        } else {
            if (moveToX == getStartX() + 1 && moveToY == getStartY() - 1) {
                result = checkBlackWestDiagonal(moveToX, moveToY);
            } else if (moveToX == getStartX() + 1 && moveToY == getStartY() + 1) {
                result = checkBlackEastDiagonal(moveToX, moveToY);
            } else if (moveToX == getStartX() + 2 && moveToY == getStartY()) {
                result = checkBlackIfFirstMove(moveToX, moveToY);
            } else if (moveToX == getStartX() + 1 && moveToY == getStartY()) {
                result = checkBlackFront(moveToX);
            }
        }
        return result;
    }

    private boolean checkBlackFront(int moveToX) {
        if (moveToX == (getStartX() + 1)) {
            return Board.board[getStartX() + 1][getStartY()] == null;
        } else {
            return false;
        }
    }

    private boolean checkWhiteFront(int moveToX) {
        if (moveToX == (getStartX() - 1)) {
            return Board.board[getStartX() - 1][getStartY()] == null;
        } else {
            return false;
        }
    }

    private boolean checkBlackIfFirstMove(int moveToX, int moveToY) {
        if (isFirstMove()) {
            if (moveToX == (getStartX() + 2)) {
                return Board.board[getStartX() + 2][getStartY()] == null && Board.board[getStartX() + 1][getStartY()] == null;
            } else {
                return checkBlackFront(moveToX);
            }
        } else {
            return checkBlackFront(moveToX);
        }
    }

    private boolean checkWhiteIfFirstMove(int moveToX, int moveToY) {
        if (isFirstMove()) {
            if (moveToX == (getStartX() - 2)) {
                return Board.board[getStartX() - 2][getStartY()] == null && Board.board[getStartX() - 1][getStartY()] == null;
            } else {
                return checkWhiteFront(moveToX);
            }
        } else {
            return checkWhiteFront(moveToX);
        }
    }


    private boolean checkWhiteWestDiagonal(int moveToX, int moveToY) {
        if (getStartY() != 0) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("white"));
            } else {
                if(getStartX() == 3) {
                    if (Board.board[getStartX()][getStartY() - 1] != null) {
                        if (Board.board[getStartX()][getStartY() - 1] instanceof Pawn) {
                            return Board.board[getStartX()][getStartY() - 1].getColor().equalsIgnoreCase("black") && ((Pawn) Board.board[getStartX()][getStartY() - 1]).getMovesCount() == 1;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkWhiteEastDiagonal(int moveToX, int moveToY) {
        if (getStartY() != 7) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("white"));
            } else {
                if (getStartX() == 3)
                    if (Board.board[getStartX()][getStartY() + 1] != null) {
                        if (Board.board[getStartX()][getStartY() + 1] instanceof Pawn) {
                            return Board.board[getStartX()][getStartY() + 1].getColor().equalsIgnoreCase("black") && ((Pawn) Board.board[getStartX()][getStartY() + 1]).getMovesCount() == 1;

                        }
                    }

            }
        }
        return false;
    }

    private boolean checkBlackWestDiagonal(int moveToX, int moveToY) {
        if (getStartY() != 0) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("black"));
            } else {
                if(getStartX() == 4) {
                    if (Board.board[getStartX()][getStartY() - 1] != null) {
                        if (Board.board[getStartX()][getStartY() - 1] instanceof Pawn) {
                            return Board.board[getStartX()][getStartY() - 1].getColor().equalsIgnoreCase("white") && ((Pawn) Board.board[getStartX()][getStartY() - 1]).getMovesCount() == 1;
                        }
                    }
                }
            }
        }
        return false;
    }


    private boolean checkBlackEastDiagonal(int moveToX, int moveToY) {
        if (getStartY() != 7) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("black"));
            } else {
                if(getStartX() == 3) {
                    if (Board.board[getStartX()][getStartY() + 1] != null) {
                        if (Board.board[getStartX()][getStartY() + 1] instanceof Pawn) {
                            return Board.board[getStartX()][getStartY() + 1].getColor().equalsIgnoreCase("white") && ((Pawn) Board.board[getStartX()][getStartY() + 1]).getMovesCount() == 1;
                        }
                    }
                }
            }
        }
        return false;
    }
    private void checkEnPassant()
    {
        if (getColor().equalsIgnoreCase("black")) {
            if (Board.board[getStartX()-1][getStartY()] != null){
                if ((Board.board[getStartX()-1][getStartY()].getColor().equalsIgnoreCase("white") && ((Pawn) Board.board[getStartX()-1][getStartY()]).getMovesCount() == 1)) {
                    Board.board[getStartX()-1][getStartY()] = null;
                }
            }
        } else {
            if (Board.board[getStartX()+1][getStartY()] != null) {
                if ((Board.board[getStartX()+1][getStartY()].getColor().equalsIgnoreCase("black") && ((Pawn) Board.board[getStartX()+1][getStartY()]).getMovesCount() == 1)) {
                    Board.board[getStartX()+1][getStartY()] = null;
                }
            }

        }
    }
    public void changePawn() {
        Piece piece = askUserToChange();
        Board.board[getStartX()][getStartY()] = piece;
    }

    private boolean checkEndRows(int x) {
        return (x == 0 || x == 7);
    }

    private Piece askUserToChange() {
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
            case "R" -> new Rook(this.getColor(), getStartX(), getStartY(), false);
            case "K" -> new Knight(this.getColor(), getStartX(), getStartY());
            case "B" -> new Bishop(this.getColor(), getStartX(), getStartY());
            default -> new Queen(this.getColor(), getStartX(), getStartY());
        };
    }

    @Override
    public void testMove(int moveToX, int moveToY) {
        super.testMove(moveToX, moveToY);
        checkEnPassant();
    }

    @Override
    public String toString() {
        if (super.getColor().equals("white")) {
            return "wPn";
        } else {
            return "bPn";
        }
    }
    public void moveWithRunnable(int moveToX, int moveToY, Runnable callback){
        if (isPossibleMove(moveToX,moveToY)) {
            Board.board[moveToX][moveToY] = Board.board[getStartX()][getStartY()];
            Board.board[getStartX()][getStartY()] = null;
            setStartX(moveToX);
            setStartY(moveToY);
            callback.run();
        }
    }
    @Override
    public void move(int moveToX, int moveToY) {
        moveWithRunnable(moveToX, moveToY, () -> {
            if (checkEndRows(moveToX)) {
                changePawn();
            }
        });
        checkEnPassant();
        setMovesCount(movesCount + 1);
        if (isFirstMove()) {
                setFirstMove(false);
            }
    }
}
