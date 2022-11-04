public class Board {
    static Piece board[][] = new Piece[8][8];

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

    public static void initializeStartingBoard() {
        // black
//        board[0][1] = new Knight("black", 1, 0);
//        board[0][6] = new Knight("black", 1, 0);
//        board[1][0] = new Pawn("black", 1, 0, true);
//        board[1][1] = new Pawn("black", 1, 1, true);
//        board[1][2] = new Pawn("black", 1, 2, true);
//        board[1][3] = new Pawn("black", 1, 3, true);
//        board[1][4] = new Pawn("black", 1, 4, true);
//        board[1][5] = new Pawn("black", 1, 5, true);
//        board[1][6] = new Pawn("black", 1, 6, true);
//        board[1][7] = new Pawn("black", 1, 7, true);
//        board[0][3] = new Queen("black", 0, 3);
//        board[0][4] = new King("black", 0, 4);
//        board[0][0] = new Rook("black", 0, 0);
//        board[0][7] = new Rook("black", 0, 7);
//        board[0][2] = new Bishop("black", 0, 1);
//        board[0][5] = new Bishop("black", 0, 6);
//        // white
        board[7][1] = new Knight("white", 6, 7);
        board[7][6] = new Knight("white", 6, 7);
        board[6][0] = new Pawn("white", 6, 0, true);
        board[6][1] = new Pawn("white", 6, 1, true);
        board[6][2] = new Pawn("white", 6, 2, true);
        board[6][3] = new Pawn("white", 6, 3, true);
        board[6][4] = new Pawn("white", 6, 4, true);
        board[6][5] = new Pawn("white", 6, 5, true);
        board[6][6] = new Pawn("white", 6, 6, true);
        board[6][7] = new Pawn("white", 6, 7, true);
        board[7][4] = new Queen("white", 7,4);
        board[7][3] = new King("white", 0, 4);
        board[7][0] = new Rook("white", 7, 0);
        board[7][7] = new Rook("white", 7, 7);
        board[7][2] = new Bishop("white", 7, 1);
        board[7][5] = new Bishop("white", 7, 6);
    }

}

