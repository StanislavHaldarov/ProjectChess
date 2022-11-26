package Movements;

import Movements.PossibleMove;
import Pieces.*;

import java.util.ArrayList;
import java.util.Random;

public class BotLogic {
    public static int returnMoveValue(int moveToX, int moveToY) {
        if (MenuAndBoard.Board.board[moveToX][moveToY] instanceof Pawn) {
            return 10;
        } else if (MenuAndBoard.Board.board[moveToX][moveToY] instanceof Knight) {
            return 30;
        } else if (MenuAndBoard.Board.board[moveToX][moveToY] instanceof Bishop) {
            return 30;
        } else if (MenuAndBoard.Board.board[moveToX][moveToY] instanceof Rook) {
            return 50;
        } else if (MenuAndBoard.Board.board[moveToX][moveToY] instanceof Queen) {
            return 90;
        } else {
            return 900;
        }
    }
    private static int calculateNextWhiteMoveValue() {
        int newValue = 0;
        for (Piece whitePiece : MenuAndBoard.Board.whitePieces) {
            for (int moveToX = 0; moveToX < 8; moveToX++) {
                for (int moveToY = 0; moveToY < 8; moveToY++) {
                    if (MenuAndBoard.Board.board[whitePiece.getStartX()][whitePiece.getStartY()] != null) {
                        if (MenuAndBoard.Board.board[whitePiece.getStartX()][whitePiece.getStartY()].isValidMove(moveToX, moveToY)) {
                            if (MenuAndBoard.Board.board[moveToX][moveToY] != null) {
                                if (newValue < returnMoveValue(moveToX, moveToY)) {
                                    newValue = returnMoveValue(moveToX, moveToY);
                                } else if (MenuAndBoard.Board.board[moveToX][moveToY] == null && whitePiece instanceof Pawn) {
                                    if (whitePiece.getStartX() != moveToX && whitePiece.getStartY() != moveToY) {
                                        if (newValue < 10) {
                                            newValue = 10;
                                        }
                                    }

                                }
                            }
                        }
                    }
                }

            }
        }
        return newValue;
    }

    private static PossibleMove makeRandomMove(ArrayList<PossibleMove> blackMoves) {
        Random rnd = new Random();
        return blackMoves.get(rnd.nextInt(blackMoves.size()));
    }

    private static PossibleMove makeStrategicMove(ArrayList<PossibleMove> blackMoves) {
        setBlackPossibleMovesValues(blackMoves);
        PossibleMove move;
        move = blackMoves.get(0);
        for (PossibleMove blackMove : blackMoves) {
            if (move.getValue() < blackMove.getValue()) {
                move = blackMove;
            }
        }
        ArrayList<PossibleMove> bestMoves = new ArrayList<>();
        for (PossibleMove blackMove : blackMoves) {
            if (move.getValue() == blackMove.getValue()) {
                bestMoves.add(blackMove);
            }
        }
        Random rnd = new Random();
        return bestMoves.get(rnd.nextInt(bestMoves.size()));
    }

    private static ArrayList<PossibleMove> setBlackPossibleMovesValues(ArrayList<PossibleMove> blackMoves) {
        for (PossibleMove blackMove : blackMoves) {
            if (MenuAndBoard.Board.board[blackMove.getStartX()][blackMove.getStartY()].isValidMove(blackMove.getMoveToX(), blackMove.getMoveToY())) {
                Piece undoBlackPieceMove = MenuAndBoard.Board.board[blackMove.getStartX()][blackMove.getStartY()];
                Piece undoWhitePieceMove = null;
                if (MenuAndBoard.Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()] != null) {
                    undoWhitePieceMove = MenuAndBoard.Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()];
                }
                int x = blackMove.getStartX();
                int y = blackMove.getStartY();
                MenuAndBoard.Board.board[blackMove.getStartX()][blackMove.getStartY()].setStartX(blackMove.getMoveToX());
                MenuAndBoard.Board.board[blackMove.getStartX()][blackMove.getStartY()].setStartY(blackMove.getMoveToY());
                MenuAndBoard.Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()] = undoBlackPieceMove;
                MenuAndBoard.Board.board[blackMove.getStartX()][blackMove.getStartY()] = null;
                blackMove.setValue(blackMove.getValue() - calculateNextWhiteMoveValue());
                undoMove(blackMove, undoBlackPieceMove, undoWhitePieceMove, x, y);
            }
        }
        return blackMoves;
    }
    public static PossibleMove makeMove(boolean isRandom) {
        ArrayList<PossibleMove> blackMoves = new ArrayList<>();
        ArrayList<PossibleMove> nonCheckBlackMoves = new ArrayList<>();
        PossibleMove.addPossibleMoves(blackMoves, MenuAndBoard.Board.blackPieces, nonCheckBlackMoves, isRandom);
        blackMoves.clear();
        if (!nonCheckBlackMoves.isEmpty()) {
            blackMoves = nonCheckBlackMoves;
            if (!isRandom) {
                return makeStrategicMove(blackMoves);
            } else {
                return makeRandomMove(blackMoves);
            }
        }
        return null;
    }
    private static void undoMove(PossibleMove blackMove, Piece undoBlackPieceMove, Piece undoWhitePieceMove, int x, int y) {
        MenuAndBoard.Board.board[blackMove.getStartX()][blackMove.getStartY()] = undoBlackPieceMove;
        MenuAndBoard.Board.board[blackMove.getStartX()][blackMove.getStartY()].setStartX(x);
        MenuAndBoard.Board.board[blackMove.getStartX()][blackMove.getStartY()].setStartY(y);
        MenuAndBoard.Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()] = undoWhitePieceMove;
    }
}
