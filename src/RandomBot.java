import java.util.Random;

public class RandomBot{
    public Piece piece;

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
        boolean r = false;
        while (!r) {
            try {
                randomRow = random.nextInt(7);
                randomColumn = random.nextInt(7);
                boolean result = piece.isPossibleMove(piece.getX(), piece.getY(), randomRow, randomColumn);
                if (result) {
                    r = true;
//                    System.out.println("Random piece -> "+piece.toString() + " start row-> "+piece.getX() + " start column " + piece.getY());
//                    System.out.println("Random row "+randomRow);
//                    System.out.println("Random colon "+ randomColumn);
                    piece.move(piece.getX(), piece.getY(), randomRow, randomColumn);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
