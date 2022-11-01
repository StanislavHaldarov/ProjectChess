public class Knight extends Piece{
    public Knight(String color,int startX, int startY) {
        super(color,startX, startY);
    }

    @Override
    public boolean isPossibleMove(int startX, int startY, int moveToX, int moveToY) {
        if((Board.board[moveToX][moveToY] == null) || (Board.board[moveToX][moveToY].getColor()!=Board.board[startX][startY].getColor())) {
            if (((startX + 2 == moveToX) && (startY + 1 == moveToY)) || ((startX + 1 == moveToX) && (startY + 2 == moveToY)) || ((startX - 1 == moveToX) && (startY + 2 == moveToY)) || ((startX - 2 == moveToX) && (startY + 1 == moveToY))
                    || ((startX - 2 == moveToX) && (moveToY - 1 == moveToY)) || ((startX - 1 == moveToX) && (startY - 2 == moveToY)) || ((startX + 1 == moveToX) && (startY - 2 == moveToY)) || ((startX + 2 == moveToX) && (startY - 1 == moveToY))) {
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }

    @Override
    public void move(int startX, int startY, int moveToX, int moveToY) {
        boolean isPossibleMove = isPossibleMove(startX, startY, moveToX, moveToY);
        if(isPossibleMove){
            Board.board[moveToX][moveToY] = Board.board[startX][startY];
            Board.board[startX][startY] = null;
        } else{
            System.out.println("Not possible move!");
        }
    }
    @Override
    public String toString() {
        if(super.getColor().equals("white")){
            return "wKn";
        } else{
            return "bKn";
        }
    }
}