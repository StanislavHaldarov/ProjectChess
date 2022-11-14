import java.util.Scanner;

public class Menu {
    public static void menu() {
        System.out.println("CHESS \nby Stanislav Haldarov and Belis Aliosmanova");
        Player player = new Player();
        player.setUsername(enterName());
    }

    public static String enterName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        return scan.nextLine();
    }

    public static void chooseDifficulty() {
        Scanner scan = new Scanner(System.in);
        System.out.println("The options are -> easy and difficult");
        System.out.print("Enter 1 for easy game or 2 for difficult game --> ");
        int choice = scan.nextInt();
        if (choice == 1) {
            randomGame();
        } else if (choice == 2) {

        } else {
            System.out.println("Oops! This option doesn't exist.");
        }
    }

    public static void enterPlayersChoice() {
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
        if (Board.board[rowNumber][columnNumber].isPossibleMove(rowNumber, columnNumber, newRowNumber, newColumnNumber)) {
            Board.board[rowNumber][columnNumber].move(rowNumber, columnNumber, newRowNumber, newColumnNumber);
        } else {
            System.out.println("NOW ENTER AGAIN!");
            enterPlayersChoice();
        }
    }

    public static void randomGame() {
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        board.initializeStartingBoard();
        board.printBoard();
        boolean isTheGameOver = false;
        while (!isTheGameOver) {
            enterPlayersChoice();
            board.printBoard();
            RandomBot randomBot = new RandomBot();
            randomBot.chooseRandomAPiece();
            randomBot.generateRandomMove();
            board.printBoard();
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
    public static int convertRow(int row){
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
