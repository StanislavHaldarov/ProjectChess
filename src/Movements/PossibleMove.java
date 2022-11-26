package Movements;

import Pieces.Piece;

import java.util.ArrayList;

public class PossibleMove {
    private int startX;
    private int startY;
    private int moveToX;
    private int moveToY;
    private int value;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getMoveToX() {
        return moveToX;
    }

    public void setMoveToX(int moveToX) {
        this.moveToX = moveToX;
    }

    public int getMoveToY() {
        return moveToY;
    }

    public void setMoveToY(int moveToY) {
        this.moveToY = moveToY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PossibleMove(int startX, int startY, int moveToX, int moveToY, int value) {
        this.startX = startX;
        this.startY = startY;
        this.moveToX = moveToX;
        this.moveToY = moveToY;
        this.value = value;
    }
    public static void addPossibleMoves(ArrayList<PossibleMove> moves, ArrayList<Piece> pieces, ArrayList<PossibleMove> nonCheckMoves, boolean isRandom) {
        for (Piece piece : pieces) {
            for (int moveToX = 0; moveToX < 8; moveToX++) {
                for (int moveToY = 0; moveToY < 8; moveToY++) {
                    if (MenuAndBoard.Board.board[piece.getStartX()][piece.getStartY()] != null) {
                        if (MenuAndBoard.Board.board[piece.getStartX()][piece.getStartY()].isValidMove(moveToX, moveToY)) {
                            moves.add(new PossibleMove(piece.getStartX(), piece.getStartY(), moveToX, moveToY, 0));
                            if (piece.getColor().equalsIgnoreCase("black") && !isRandom) {
                                if (MenuAndBoard.Board.board[moveToX][moveToY] != null) {
                                    moves.get(moves.size() - 1).setValue(BotLogic.returnMoveValue(moveToX, moveToY));
                                }
                            }
                        }
                    }
                }
            }
        }
        addNonCheckMoves(moves, nonCheckMoves);
    }
    private static void addNonCheckMoves(ArrayList<PossibleMove> moves, ArrayList<PossibleMove> nonCheckMoves) {
        for (PossibleMove move : moves) {
            if (!Checkmate.checkIfValidMoveInCheck(move.getStartX(), move.getStartY(), move.getMoveToX(), move.getMoveToY())) {
                nonCheckMoves.add(move);
            }
        }
    }
}
