import java.util.ArrayList;

public class Board {
    static Piece board[][] = new Piece[8][8];
    static ArrayList<Piece> whitePieces = new ArrayList<Piece>();
    static ArrayList<Piece> blackPieces = new ArrayList<Piece>();

    public static void printBoard() {
        System.out.println("      a    b    c    d    e    f    g    h");

        System.out.println("   -----------------------------------------");
        int count = 1;
        for (int i = 0; i < 8; i++) {
            System.out.print(count + " ");
            System.out.print(" | ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("   | ");
                } else {
                    System.out.print(board[i][j] + " |");
                }
            }
            System.out.print(count);
            count++;
            System.out.println();
            System.out.println("   -----------------------------------------");
        }
        System.out.println("      a    b    c    d    e    f    g    h");
        System.out.println();
    }

    public static int transformRows(String blackMove) {
        char[] letters = blackMove.toCharArray();
        return letters[1] - 1;
    }

    public static int transformColumns(String blackMove) {
        char[] letters = blackMove.toCharArray();
        switch (letters[0]) {
            case 'a' -> {
                return 0;
            }
            case 'b' -> {
                return 1;
            }
            case 'c' -> {
                return 2;
            }
            case 'd' -> {
                return 3;
            }
            case 'e' -> {
                return 4;
            }
            case 'f' -> {
                return 5;
            }
            case 'g' -> {
                return 6;
            }
            case 'h' -> {
                return 7;
            }
            default -> {
                return 8;
            }
        }
    }

    public static String transformCoordinates(int k, int l) {
        String xyCoordinate;
        switch (l) {
            case 0 -> xyCoordinate = "a";
            case 1 -> xyCoordinate = "b";
            case 2 -> xyCoordinate = "c";
            case 3 -> xyCoordinate = "d";
            case 4 -> xyCoordinate = "e";
            case 5 -> xyCoordinate = "f";
            case 6 -> xyCoordinate = "g";
            case 7 -> xyCoordinate = "h";
        }
        switch (k) {
            case 0 -> xyCoordinate = "8";
            case 1 -> xyCoordinate = "7";
            case 2 -> xyCoordinate = "6";
            case 3 -> xyCoordinate = "5";
            case 4 -> xyCoordinate = "4";
            case 5 -> xyCoordinate = "3";
            case 6 -> xyCoordinate = "2";
            case 7 -> xyCoordinate = "1";
        }
        xyCoordinate = l + "" + k;
        return xyCoordinate;
    }

    public static int returnMoveValue(int k, int l) {
        if (Board.board[k][l] instanceof Pawn) {
            return 10;
        } else if (Board.board[k][l] instanceof Knight) {
            return 30;
        } else if (Board.board[k][l] instanceof Bishop) {
            return 30;
        } else if (Board.board[k][l] instanceof Rook) {
            return 50;
        } else if (Board.board[k][l] instanceof Queen) {
            return 90;
        } else {
            return 900;
        }
    }

    public static void checkBlackMoves() {
        ArrayList<PossibleMoves> blackMoves = new ArrayList<>();
        blackMoves.add(new PossibleMoves("default", 0));
        ArrayList<PossibleMoves> whiteMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.board[i][j] != null) {
                    if (Board.board[i][j].getColor().equalsIgnoreCase("black")) {
                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                if (Board.board[i][j] != null) {
                                    if (Board.board[i][j].isPossibleMove(i, j, k, l)) {
                                        for (PossibleMoves blackMove : blackMoves) {
                                            if (!blackMove.getMoveCords().equals(transformCoordinates(k, l))) {
                                                blackMoves.add(new PossibleMoves(transformCoordinates(k, l), 0));
                                                if (Board.board[k][l] != null) {
                                                    blackMove.setValue(returnMoveValue(k, l));

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (PossibleMoves blackMove : blackMoves) {
            int x = transformRows(blackMove.getMoveCords());
            int y = transformColumns(blackMove.getMoveCords());
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Board.board[i][j] != null) {
                        if (Board.board[i][j].getColor().equalsIgnoreCase("black")) {
                            Board.board[i][j].move(i, j, x, y);
                        }

                    }
                }
            }
        }
    }

    public static void initializeStartingBoard() {
        // black
        board[0][1] = new Knight("black", 0, 1);
        board[0][6] = new Knight("black", 0, 6);
        board[1][0] = new Pawn("black", 1, 0, true, 0);
        board[1][1] = new Pawn("black", 1, 1, true, 0);
//            board[1][2] = new Pawn("black", 1, 2, true, 0);
//            board[1][3] = new Pawn("black", 1, 3, true, 0);
//            board[1][4] = new Pawn("black", 1, 4, true, 0);
//            board[1][5] = new Pawn("black", 1, 5, true, 0);
//            board[1][6] = new Pawn("black", 1, 6, true, 0);
//            board[1][7] = new Pawn("black", 1, 7, true, 0);
        board[0][3] = new Queen("black", 0, 3);
//        board[0][4] = new King("black", 0, 4);
//        board[0][0] = new Rook("black", 0, 0);
//        board[0][7] = new Rook("black", 0, 7);
//        board[0][2] = new Bishop("black", 0, 1);
//        board[0][5] = new Bishop("black", 0, 6);
//        // white
//        board[7][1] = new Knight("white", 6, 7);
//        board[7][6] = new Knight("white", 6, 7);
//        board[6][0] = new Pawn("white", 6, 0, true, 0);
//        board[6][1] = new Pawn("white", 6, 1, true, 0);
//        board[6][2] = new Pawn("white", 6, 2, true, 0);
//        board[6][3] = new Pawn("white", 6, 3, true, 0);
//        board[6][4] = new Pawn("white", 6, 4, true, 0);
//        board[6][5] = new Pawn("white", 6, 5, true, 0);
//        board[6][6] = new Pawn("white", 6, 6, true, 0);
//        board[6][7] = new Pawn("white", 6, 7, true, 0);
//        board[7][3] = new Queen("white", 7, 3);
//        board[7][4] = new King("white", 7, 4,true);
        board[7][0] = new Rook("white", 7, 0, true);
        board[7][7] = new Rook("white", 7, 7, true);
//        board[7][2] = new Bishop("white", 7, 1);
//        board[7][5] = new Bishop("white", 7, 6);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (Board.board[i][j] != null) {
                    if (Board.board[i][j].getColor().equals("white")) {
                        whitePieces.add(Board.board[i][j]);
                    } else {
                        blackPieces.add(Board.board[i][j]);
                    }
                }
            }
        }
    }
}



