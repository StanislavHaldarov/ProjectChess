package MenuAndBoard;

import Pieces.*;

import java.util.ArrayList;

public class Board {
    public static Piece[][] board = new Piece[8][8];
    public static ArrayList<Piece> whitePieces = new ArrayList<Piece>();
    public static ArrayList<Piece> blackPieces = new ArrayList<Piece>();

    public void printBoard() {
        System.out.println("      a    b    c    d    e    f    g    h");

        System.out.println("   -----------------------------------------");
        int count = 8;
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
            count--;
            System.out.println();
            System.out.println("   -----------------------------------------");
        }
        System.out.println("      a    b    c    d    e    f    g    h");
        System.out.println();
    }

    public void initializeStartingBoard() {
        board[0][1] = new Knight("black", 0, 1);
        board[0][6] = new Knight("black", 0, 6);
        board[1][0] = new Pawn("black", 1, 0, true, 0);
        board[1][1] = new Pawn("black", 1, 1, true, 0);
        board[1][2] = new Pawn("black", 1, 2, true, 0);
        board[1][3] = new Pawn("black", 1, 3, true, 0);
        board[1][4] = new Pawn("black", 1, 4, true, 0);
        board[1][5] = new Pawn("black", 1, 5, true, 0);
        board[1][6] = new Pawn("black", 1, 6, true, 0);
        board[1][7] = new Pawn("black", 1, 7, true, 0);
        board[0][1] = new Knight("black", 0, 1);
        board[0][6] = new Knight("black", 0, 6);
        board[1][0] = new Pawn("black", 1, 0, true, 0);
        board[1][1] = new Pawn("black", 1, 1, true, 0);
        board[1][2] = new Pawn("black", 1, 2, true, 0);
        board[1][3] = new Pawn("black", 1, 3, true, 0);
        board[1][4] = new Pawn("black", 1, 4, true, 0);
        board[1][5] = new Pawn("black", 1, 5, true, 0);
        board[1][6] = new Pawn("black", 1, 6, true, 0);
        board[1][7] = new Pawn("black", 1, 7, true, 0);
        board[0][3] = new Queen("black", 0, 3);
        board[0][4] = new King("black", 0, 4, true);
        board[0][0] = new Rook("black", 0, 0, true);
        board[0][7] = new Rook("black", 0, 7, true);
        board[0][2] = new Bishop("black", 0, 2);
        board[0][5] = new Bishop("black", 0, 5);
        board[7][1] = new Knight("white", 7, 1);
        board[7][6] = new Knight("white", 7, 6);
        board[6][0] = new Pawn("white", 6, 0, true, 0);
        board[6][1] = new Pawn("white", 6, 1, true, 0);
        board[6][2] = new Pawn("white", 6, 2, true, 0);
        board[6][3] = new Pawn("white", 6, 3, true, 0);
        board[6][4] = new Pawn("white", 6, 4, true, 0);
        board[6][5] = new Pawn("white", 6, 5, true, 0);
        board[6][6] = new Pawn("white", 6, 6, true, 0);
        board[6][7] = new Pawn("white", 6, 7, true, 0);
        board[7][3] = new Queen("white", 7, 3);
        board[7][4] = new King("white", 7, 4, true);
        board[7][0] = new Rook("white", 7, 0, true);
        board[7][7] = new Rook("white", 7, 7, true);
        board[7][2] = new Bishop("white", 7, 2);
        board[7][5] = new Bishop("white", 7, 5);
        sortPieces();
    }

    public static void sortPieces() {
        blackPieces.clear();
        whitePieces.clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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