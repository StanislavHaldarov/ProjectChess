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
        if (getColor().equalsIgnoreCase("white")) {
            if (moveToX == getStartX() - 1 && moveToY == getStartY() - 1) {
                if(checkWhiteWestDiagonal(moveToX, moveToY)){return !Checkmate.isInCheck(getColor(),getStartX(), getStartY(), moveToX,moveToY);}
            } else if (moveToX == getStartX() - 1 && moveToY == getStartY() + 1) {
                if(checkWhiteEastDiagonal(moveToX, moveToY)){return !Checkmate.isInCheck(getColor(),getStartX(), getStartY(), moveToX,moveToY);}
            } else if (moveToX == getStartX() - 2 && moveToY == getStartY()) {
                if(checkWhiteIfFirstMove(moveToX)){return !Checkmate.isInCheck(getColor(),getStartX(), getStartY(), moveToX,moveToY);}
            } else if (moveToX == getStartX() - 1 && moveToY == getStartY()) {
                if(checkWhiteFront(moveToX)){return !Checkmate.isInCheck(getColor(),getStartX(), getStartY(), moveToX,moveToY);}
            }
        } else {
            if (moveToX == getStartX() + 1 && moveToY == getStartY() - 1) {
                if(checkBlackWestDiagonal(moveToX, moveToY)){return !Checkmate.isInCheck(getColor(),getStartX(), getStartY(), moveToX,moveToY);}
            } else if (moveToX == getStartX() + 1 && moveToY == getStartY() + 1) {
                if(checkBlackEastDiagonal(moveToX, moveToY)){return !Checkmate.isInCheck(getColor(),getStartX(), getStartY(), moveToX,moveToY);}
            } else if (moveToX == getStartX() + 2 && moveToY == getStartY()) {
                if(checkBlackIfFirstMove(moveToX)){return !Checkmate.isInCheck(getColor(),getStartX(), getStartY(), moveToX,moveToY);}
            } else if (moveToX == getStartX() + 1 && moveToY == getStartY()) {
                if(checkBlackFront(moveToX)){return !Checkmate.isInCheck(getColor(),getStartX(), getStartY(), moveToX,moveToY);}
            }
        }
        return false;
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

    private boolean checkBlackIfFirstMove(int moveToX) {
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

    private boolean checkWhiteIfFirstMove(int moveToX) {
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
            }
        }
        return false;
    }


    private boolean checkBlackEastDiagonal(int moveToX, int moveToY) {
        if (getStartY() != 7) {
            if (Board.board[moveToX][moveToY] != null) {
                return !(Board.board[moveToX][moveToY].getColor().equalsIgnoreCase("black"));
            }
        }
        return false;
    }
    private void checkEnPassant()
    {
        if (Board.board[getStartX()+1][getStartY()] != null) {
            if ((Board.board[getStartX()+1][getStartY()].getColor().equalsIgnoreCase("black") && ((Pawn) Board.board[getStartX()+1][getStartY()]).getMovesCount() == 1)) {
                Board.board[getStartX()+1][getStartY()] = null;
            }
        }
    }
    public void changePawn() {
        Piece piece = askUserToChange();
        Board.board[getStartX()][getStartY()] = piece;
    }

    private void promotePawn(int moveToX, int moveToY) {
        if(getColor().equalsIgnoreCase("white"))
        {
            if (moveToX==0) {
                changePawn();
            }
        }
        else{
            if(moveToX==7)
            {
                Board.board[moveToX][moveToY] = new Queen("black",moveToX,moveToY);
            }
        }
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
            promotePawn(moveToX,moveToY);
        });
        if(getColor().equalsIgnoreCase("white")) {
            checkEnPassant();
        }
        setMovesCount(movesCount + 1);
        if (isFirstMove()) {
                setFirstMove(false);
            }
    }
}
