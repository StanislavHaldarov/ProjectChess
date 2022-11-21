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
        int choice = scan.nextInt();
        if (choice == 1) {
            inGame(true);
        } else if (choice == 2) {
            inGame(false);
        } else {
            System.out.println("Oops! This option doesn't exist.");
        }
    }

    public static void enterPlayersChoice() {
        char[] yCoordinates = {'a','b','c','d','e','f','g','h'};
        char[] xCoordinates = {'1','2','3','4','5','6','7','8'};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the coordinates of the piece you want to move! ");
        System.out.print("Enter the row/number from 1 to 8/->  ");
        int row = scan.nextInt();
        int rowNumber = convertRow(row);
        System.out.print("Enter the column/letter from a to h/ ");
        char column = scan.next().charAt(0);
        int columnNumber = convertColumnToInt(column);
        System.out.println("Your choice is -> " + Board.board[rowNumber][columnNumber]);
        System.out.println("Enter the coordinates of the place you want to move your piece -> " + Board.board[rowNumber][columnNumber]);
        System.out.print("Enter the row/number from 1 to 8/->  ");
        int newRow = scan.nextInt();
        int newRowNumber = convertRow(newRow);
        System.out.print("Enter the column/letter from a to h/ ");
        char newColumn = scan.next().charAt(0);
        int newColumnNumber = convertColumnToInt(newColumn);
        if(Board.board[rowNumber][columnNumber].isPossibleMove(newRowNumber, newColumnNumber)) {
            Board.board[rowNumber][columnNumber].move(newRowNumber, newColumnNumber);
        }
        else{
            System.out.println("Illegal move!");
            enterPlayersChoice();
        }
    }

    public static void inGame(boolean isRandom) {
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        Board.initializeStartingBoard();
        Board.printBoard();
        boolean isTheGameOver = false;
        while (!isTheGameOver) {
            enterPlayersChoice();
            board.printBoard();
            Board.sortPieces();
            PossibleMoves botMove = BotLogic.makeMove(isRandom);
            Board.board[botMove.getStartX()][botMove.getStartY()].move(botMove.getMoveToX(), botMove.getMoveToY());
            board.printBoard();
            for (Piece whitePiece : Board.whitePieces) {
                isTheGameOver = true;
                if (whitePiece instanceof King) {
                    isTheGameOver = false;
                    break;
                }
            }
            Board.sortPieces();
        }
    }

    public static int convertColumnToInt(char column) {
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

    public static int convertRow(int row) {
        switch (row) {
            case 1 -> {
                return 7;
            }
            case 2 -> {
                return 6;
            }
            case 3 -> {
                return 5;
            }
            case 4 -> {
                return 4;
            }
            case 5 -> {
                return 3;
            }
            case 6 -> {
                return 2;
            }
            case 7 -> {
                return 1;
            }
            case 8 -> {
                return 0;
            }
            default -> {
                return 8;
            }
        }
    }
}
