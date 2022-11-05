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

//        Board.board[5][7].move(5, 7, 1, 3);
//        Board.board[3][3] = new Bishop("white", 3,3);
//        Board.board[3][1] = new Pawn("white",3,1,false);
//        Board.board[3][3].move(3,3,1,5);
//        board1.printBoard();
//        Board.board[7][3] = new Knight("black", 5 , 0);
//        Board.board[4][2] = new Queen("white",4, 2);
//        Board.board[3][2] = new Knight("black", 3 ,2);
//        Board.board[4][2].move(4,2,3,2);
//        Board.board[3][2].move(3,2,2,2);

        //pawn end row check test
//        Board.board[1][0] = new Pawn("white", 1, 0, true);
//        Board.board[1][0].move(1,0,0,0);
//        Board.board[5][6] = new King("white", 5 ,6);
//        Board.board[5][6].move(5,6,6,7);
        Board.board[3][4] = new Pawn("black", 3, 4, false, 1);
        Board.board[3][3] = new Pawn("white", 3, 3, false, 1);
        Board.board[3][3].move(3, 3, 2, 4);
        board1.printBoard();
    }
}