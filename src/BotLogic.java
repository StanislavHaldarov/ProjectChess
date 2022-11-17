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
                    if (Board.board[whitePiece.getX()][whitePiece.getY()] != null) {
                        if (Board.board[whitePiece.getX()][whitePiece.getY()].isPossibleMove(whitePiece.getX(), whitePiece.getY(), moveToX, moveToY)) {
                            if (Board.board[moveToX][moveToY] != null) {
                                if (newValue < returnMoveValue(moveToX, moveToY)) {
                                    newValue = returnMoveValue(moveToX, moveToY);
                                }
                            }
                        }
                    }
                }
            }
        }
        return newValue;
    }

    public static void addBlackPossibleMoves(ArrayList<PossibleMoves> blackMoves) {
        Board.sortPieces();
        for (Piece blackPiece : Board.blackPieces) {
            for (int moveToX = 0; moveToX < 8; moveToX++) {
                for (int moveToY = 0; moveToY < 8; moveToY++) {
                    if (Board.board[blackPiece.getX()][blackPiece.getY()] != null) {
                        if (Board.board[blackPiece.getX()][blackPiece.getY()].isPossibleMove(blackPiece.getX(), blackPiece.getY(), moveToX, moveToY)) {
                            blackMoves.add(new PossibleMoves(blackPiece.getX(), blackPiece.getY(), moveToX, moveToY, 0));
                            if (Board.board[moveToX][moveToY] != null) {
                                blackMoves.get(blackMoves.size() - 1).setValue(returnMoveValue(moveToX, moveToY));
                            }
                        }
                    }

                }
            }
        }
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
        return bestMoves.get(rnd.nextInt(bestMoves.size() - 1));
    }

    public static PossibleMoves makeRandomMove(ArrayList<PossibleMoves> blackMoves) {
        Random rnd = new Random();
        return blackMoves.get(rnd.nextInt(blackMoves.size() - 1));
    }

    public static void setBlackPossibleMovesValues(ArrayList<PossibleMoves> blackMoves) {
        for (PossibleMoves blackMove : blackMoves) {
            if (Board.board[blackMove.getStartX()][blackMove.getStartY()].isPossibleMove(blackMove.getStartX(), blackMove.getStartY(), blackMove.getMoveToX(), blackMove.getMoveToY())) {
                Piece undoBlackPieceMove = Board.board[blackMove.getStartX()][blackMove.getStartY()];
                Piece undoWhitePieceMove = null;
                if (Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()] != null) {
                    undoWhitePieceMove = Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()];
                }
                Board.board[blackMove.getStartX()][blackMove.getStartY()].move(blackMove.getStartX(), blackMove.getStartX(), blackMove.getMoveToX(), blackMove.getMoveToY());
                blackMove.setValue(blackMove.getValue() - calculateNextWhiteMoveValue());
                Board.board[blackMove.getStartX()][blackMove.getStartY()] = undoBlackPieceMove;
                Board.board[blackMove.getMoveToX()][blackMove.getMoveToY()] = undoWhitePieceMove;
            }
        }
    }

    public static PossibleMoves makeMove(boolean isRandom) {
        ArrayList<PossibleMoves> blackMoves = new ArrayList<>();
        addBlackPossibleMoves(blackMoves);
        if (!isRandom) {
            return makeStrategicMove(blackMoves);
        } else {
            return makeRandomMove(blackMoves);
        }
    }
}
