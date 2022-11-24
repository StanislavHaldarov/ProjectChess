import java.util.ArrayList;
import java.util.Random;

public class BotLogic {
    private static int returnMoveValue(int moveToX, int moveToY) {
        if (Board.board[moveToX][moveToY] instanceof Pawn) {
            return 10;
        } else if (Board.board[moveToX][moveToY] instanceof Knight) {
            return 30;
        } else if (Board.board[moveToX][moveToY] instanceof Bishop) {
            return 30;
        } else if (Board.board[moveToX][moveToY] instanceof Rook) {
            return 50;
        } else if (Board.board[moveToX][moveToY] instanceof Queen) {
            return 90;
        } else {
            return 900;
        }
    }

    public static int calculateNextWhiteMoveValue() {
        int newValue = 0;
        for (Piece whitePiece : Board.whitePieces) {
            for (int moveToX = 0; moveToX < 8; moveToX++) {
                for (int moveToY = 0; moveToY < 8; moveToY++) {
                    if (Board.board[whitePiece.getStartX()][whitePiece.getStartY()] != null) {
                        if (Board.board[whitePiece.getStartX()][whitePiece.getStartY()].isPossibleMove(moveToX, moveToY)) {
                            if (Board.board[moveToX][moveToY] != null) {
                                if (newValue < returnMoveValue(moveToX, moveToY)) {
                                    newValue = returnMoveValue(moveToX, moveToY);
                                } else if (Board.board[moveToX][moveToY] == null && whitePiece instanceof Pawn) {
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

    public static void addPossibleMoves(ArrayList<PossibleMoves> moves, ArrayList<Piece> pieces, ArrayList<PossibleMoves> nonCheckMoves,boolean isRandom) {
        for (Piece piece : pieces) {
            for (int moveToX = 0; moveToX < 8; moveToX++) {
                for (int moveToY = 0; moveToY < 8; moveToY++) {
                    if (Board.board[piece.getStartX()][piece.getStartY()] != null) {
                        if (Board.board[piece.getStartX()][piece.getStartY()].isPossibleMove(moveToX, moveToY)) {
                            moves.add(new PossibleMoves(piece.getStartX(), piece.getStartY(), moveToX, moveToY, 0));
                            if (piece.getColor().equalsIgnoreCase("black") && !isRandom) {
                                if (Board.board[moveToX][moveToY] != null) {
                                    moves.get(moves.size() - 1).setValue(returnMoveValue(moveToX, moveToY));
                                }
                            }
                        }
                    }
                }
            }
        }
        addNonCheckMoves(moves, nonCheckMoves);
    }

    public static PossibleMoves makeStrategicMove(ArrayList<PossibleMoves> blackMoves) {
        setBlackPossibleMovesValues(blackMoves);
        PossibleMoves move;
        move = blackMoves.get(0);
        for (PossibleMoves blackMove : blackMoves) {
            if (move.getValue() < blackMove.getValue()) {
                move = blackMove;
            }
        }
        ArrayList<PossibleMoves> bestMoves = new ArrayList<>();
        for (PossibleMoves blackMove : blackMoves) {
            if (move.getValue() == blackMove.getValue()) {
                bestMoves.add(blackMove);
            }
        }
        Random rnd = new Random();
        return bestMoves.get(rnd.nextInt(bestMoves.size()));
    }

    public static PossibleMoves makeRandomMove(ArrayList<PossibleMoves> blackMoves) {
        Random rnd = new Random();
        return blackMoves.get(rnd.nextInt(blackMoves.size()));
    }

    public static ArrayList<PossibleMoves> setBlackPossibleMovesValues(ArrayList<PossibleMoves> blackMoves) {
        for (PossibleMoves blackMove : blackMoves) {
            if (Board.board[blackMove.getStartX()][blackMove.getStartY()].isPossibleMove(blackMove.getMoveToX(), blackMove.getMoveToY())) {
                Piece undoBlackPieceMove = Board.board[blackMove.getStartX()][blackMove.getStartY()];
                Piece undoWhitePieceMove = null;
                if (Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()] != null) {
                    undoWhitePieceMove = Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()];
                }
                int x = blackMove.getStartX();
                int y = blackMove.getStartY();
                Board.board[blackMove.getStartX()][blackMove.getStartY()].setStartX(blackMove.getMoveToX());
                Board.board[blackMove.getStartX()][blackMove.getStartY()].setStartY(blackMove.getMoveToY());
                Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()] = undoBlackPieceMove;
                Board.board[blackMove.getStartX()][blackMove.getStartY()] = null;
                blackMove.setValue(blackMove.getValue() - calculateNextWhiteMoveValue());
                undoMove(blackMove, undoBlackPieceMove, undoWhitePieceMove, x, y);
            }
        }
        return blackMoves;
    }

    static void undoMove(PossibleMoves blackMove, Piece undoBlackPieceMove, Piece undoWhitePieceMove, int x, int y) {
        Board.board[blackMove.getStartX()][blackMove.getStartY()] = undoBlackPieceMove;
        Board.board[blackMove.getStartX()][blackMove.getStartY()].setStartX(x);
        Board.board[blackMove.getStartX()][blackMove.getStartY()].setStartY(y);
        Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()] = undoWhitePieceMove;
    }

    static void addNonCheckMoves(ArrayList<PossibleMoves> moves, ArrayList<PossibleMoves> nonCheckMoves) {
        for (PossibleMoves move : moves) {
            if (!Checkmate.checkIfPossibleMoveIsCheck(move.getStartX(), move.getStartY(), move.getMoveToX(), move.getMoveToY())) {
                nonCheckMoves.add(move);
            }
        }
    }

    public static PossibleMoves makeMove(boolean isRandom) {
        ArrayList<PossibleMoves> blackMoves = new ArrayList<>();
        ArrayList<PossibleMoves> nonCheckBlackMoves = new ArrayList<>();
        addPossibleMoves(blackMoves, Board.blackPieces, nonCheckBlackMoves,isRandom);
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
}
