import java.util.Random;

public class RandomBot{
    public Piece piece;
    boolean r = false;
    public Piece chooseRandomAPiece() {
        Board.sortPieces();
        int index = (int) (Math.random() * Board.blackPieces.size());
        piece = Board.blackPieces.get(index);
        return piece;
    }

    public void generateRandomMove() {
        Random random = new Random();
        int randomRow;
        int randomColumn;
        int i = 0;
        while (!r || i<=100) {
            try {
                randomRow = random.nextInt(7);
                randomColumn = random.nextInt(7);
                boolean result = piece.isPossibleMove(piece.getX(), piece.getY(), randomRow, randomColumn);
                if (result) {
                    r = true;
                    System.out.println("Random Bot chose -> " + Board.board[piece.getX()][piece.getY()].toString() + " ["+piece.getX()+"]["+piece.getY()+"]" + "  New coordinates ["+randomRow+"]["+randomColumn+"]");
                    piece.move(piece.getX(), piece.getY(), randomRow, randomColumn);
                    break;
                }
                i++;
                if(i==100){
                    chooseRandomAPiece();
                    generateRandomMove();
                }
            } catch (Exception e) {
//                System.out.println("EXCEPTION!!!!!!! "+e);
            }
        }
    }
}