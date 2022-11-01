import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        Menu.menu();
        Board board1 = new Board();
        board1.initializeStartingBoard();
        board1.printBoard();
//        board1.printBoard();
//        System.out.println("Enter what you want to move ");
//        System.out.println("Enter the row ");
//        System.out.println("Enter the colon ");
//        char colon = scan.next().charAt(0);
//        Random random = new Random();
//        int randomRow = random.nextInt(7);
//        int randomColumn = random.nextInt(7);
//        boolean r = false;
//        while(r==false){
//            try {
//                randomRow = random.nextInt(7);
//                randomColumn = random.nextInt(7);
//                boolean result = Board.board[7][1].isPossibleMove(7, 1, randomRow, randomColumn);
//                if(result == true){
//                    r = true;
//                    System.out.println("Random row "+randomRow);
//                    System.out.println("Random colon "+ randomColumn);
//                }
//
//            } catch (Exception e){
//                System.out.println(e);
//            }
//        }
//        int row = 7;
//        int colonNumber = 1;
//        System.out.println("You selected " + Board.board[row][colonNumber]);
//        Board.board[row][colonNumber].move(row, colonNumber, 5, 2);
//        board1.printBoard();
//        int row = 6;
//        int colonNumber = 0;
//        System.out.println("You selected " + Board.board[row][colonNumber]);
////        Board.board[5][0] = new Knight("black", 5 , 0);
//        Board.board[row][colonNumber].move(row, colonNumber, 4, 0);
//        Board.board[4][0].move(4, 0, 2, 0);
//        board1.printBoard();

        Board.board[5][7].move(5, 7, 1, 3);
        board1.printBoard();
    }
}