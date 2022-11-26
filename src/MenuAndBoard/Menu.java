package MenuAndBoard;

import Movements.BotLogic;
import Movements.Checkmate;
import Movements.PossibleMove;
import Pieces.King;
import Pieces.Piece;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println("CHESS \nby Stanislav Haldarov and Belis Aliosmanova");
        chooseDifficulty();
    }

    public static void chooseDifficulty() {
        Scanner scan = new Scanner(System.in);
        System.out.println("The options are -> easy and difficult");
        System.out.print("Enter 1 for easy game or 2 for difficult game --> ");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                inGame(true);
            } else if (choice == 2) {
                inGame(false);
            } else {
                throw new Exception("Invalid difficulty type!");
            }
        } catch (Exception e) {
            System.out.println("Invalid difficulty type!");
            chooseDifficulty();
        }
    }

    public static void enterPlayersChoice(ArrayList<PossibleMove> whiteMoves) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the coordinates of the piece you want to move! /Ex. -> a1/ ");
            int rowNumber = 0;
            int columnNumber = 0;
            String startCoordinates = scan.nextLine();
            char startColumn = startCoordinates.charAt(0);
            char startRow = startCoordinates.charAt(1);
            columnNumber = convertColumnToInt(startColumn);
            rowNumber = convertRow(startRow);
            boolean isIllegalMove = true;
            for (PossibleMove whiteMove : whiteMoves) {
                if (rowNumber == whiteMove.getStartX() && columnNumber == whiteMove.getStartY()) {
                    isIllegalMove = false;
                    break;
                }
            }
            if (isIllegalMove) {
                System.out.println("You can't move that here!");
                enterPlayersChoice(whiteMoves);
            } else {
                isIllegalMove = true;
                int moveColumnNumber = 0;
                int moveRowNumber = 0;
                System.out.print("Enter the coordinates of the place you want to move your piece -> " + Board.board[rowNumber][columnNumber] + " /Ex. -> a1/ ");
                String moveCoordinates = scan.nextLine();
                char moveColumn = moveCoordinates.charAt(0);
                char moveRow = moveCoordinates.charAt(1);
                moveColumnNumber = convertColumnToInt(moveColumn);
                moveRowNumber = convertRow(moveRow);
                for (PossibleMove whiteMove : whiteMoves) {
                    if (rowNumber == whiteMove.getStartX() && columnNumber == whiteMove.getStartY()) {
                        if (moveRowNumber == whiteMove.getMoveToX() && moveColumnNumber == whiteMove.getMoveToY()) {
                            Board.board[rowNumber][columnNumber].move(moveRowNumber, moveColumnNumber);
                            isIllegalMove = false;
                            break;
                        }

                    }
                }
                if (isIllegalMove) {
                    System.out.println("Illegal move!");
                    enterPlayersChoice(whiteMoves);
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid start coordinates! Enter again! ");
            enterPlayersChoice(whiteMoves);
        }
    }

    public static void check(ArrayList<Piece> pieces) {
        for (Piece piece : pieces) {
            if (piece instanceof King) {
                if (Checkmate.checkIfKingInCheck(piece.getStartX(), piece.getStartY())) {
                    if (piece.getColor().equalsIgnoreCase("white")) {
                        System.out.println("CHECKMATE! BOT WINS!");
                    } else {
                        System.out.println("CHECKMATE! PLAYER WINS!");
                    }
                } else {
                    if (piece.getColor().equalsIgnoreCase("white")) {
                        System.out.println("STALEMATE!");
                    } else {
                        System.out.println("STALEMATE!");
                    }
                }
                break;
            }
        }
    }

    public static void inGame(boolean isRandom) {
        Board board = new Board();
        board.initializeStartingBoard();
        board.printBoard();
        while (true) {
            ArrayList<PossibleMove> whiteMoves = new ArrayList<>();
            ArrayList<PossibleMove> nonCheckBlackMoves = new ArrayList<>();
            PossibleMove.addPossibleMoves(whiteMoves, Board.whitePieces, nonCheckBlackMoves, isRandom);
            whiteMoves.clear();
            if (!nonCheckBlackMoves.isEmpty()) {
                whiteMoves = nonCheckBlackMoves;
                enterPlayersChoice(whiteMoves);
            } else {
                check(Board.whitePieces);
                break;
            }
            board.printBoard();
            Board.sortPieces();
            PossibleMove botMove = BotLogic.makeMove(isRandom);
            if (botMove == null) {
                check(Board.blackPieces);
                break;
            }
            Board.board[botMove.getStartX()][botMove.getStartY()].move(botMove.getMoveToX(), botMove.getMoveToY());
            board.printBoard();
            Board.sortPieces();
        }
    }

    private static int convertColumnToInt(char column) {
        switch (column) {
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

    private static int convertRow(char row) {
        switch (row) {
            case '1' -> {
                return 7;
            }
            case '2' -> {
                return 6;
            }
            case '3' -> {
                return 5;
            }
            case '4' -> {
                return 4;
            }
            case '5' -> {
                return 3;
            }
            case '6' -> {
                return 2;
            }
            case '7' -> {
                return 1;
            }
            case '8' -> {
                return 0;
            }
            default -> {
                return 8;
            }
        }
    }
}
