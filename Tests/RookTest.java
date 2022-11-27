import MenuAndBoard.Board;
import Pieces.Pawn;
import Pieces.Rook;
import Pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class RookTest {
    @Before
    public void initializeBishop(){
        Board.board[3][3] = new Rook("white", 3, 3, false);
        Board.board[0][0] = new Rook("white", 0,0, true);
        Board.board[7][7] = new Rook("black", 7,7, false);
        Board.board[0][7] = new Rook("white", 0,7, true);
        Board.board[7][0] = new Rook("white", 7,0, true);
    }
    @Test
    public void testToStringMethodTWhenRookIsWhite(){
        assertEquals("wRk",Board.board[0][0].toString());
    }
    @Test
    public void testToStringMethodTWhenRookIsBlack(){
        assertEquals("bRk",Board.board[7][7].toString());
    }
    @Test
    public void testValidMoveDirectionXSouthIfThereIsAPieceFromTheOtherTeamOnMoveCoordinates(){
        Board.board[4][0] = new Rook("black", 4,0,false);
        assertTrue(Board.board[0][0].isValidMove(4,0));
    }
    @Test
    public void testValidMoveDirectionYWestIfThereIsAPieceFromTheOtherTeamOnMoveCoordinates(){
        Board.board[0][2] = new Rook("black", 0,2,false);
        assertTrue(Board.board[0][7].isValidMove(0,2));
    }
    @Test
    public void testValidMoveDirectionYEastIfThereIsAPieceFromTheOtherTeamOnMoveCoordinates(){
        Board.board[7][2] = new Rook("black", 7,2,false);
        assertTrue(Board.board[7][0].isValidMove(7,2));
    }
    @Test
    public void testValidMoveDirectionYEastWhenTheMoveIsValid(){
        assertTrue(Board.board[0][0].isValidMove(0, 3));
    }
    @Test
    public void testValidMoveDirectionYWestWhenTheMoveIsValid(){
        assertTrue(Board.board[0][7].isValidMove(0, 2));
    }
    @Test
    public void testValidMoveDirectionXSouthWhenTheMoveIsValid(){
        assertTrue(Board.board[0][0].isValidMove(6, 0));
    }
    @Test
    public void testValidMoveDirectionXNorthWhenTheMoveIsValid(){
        assertTrue(Board.board[7][7].isValidMove(0, 7));
    }
    @Test
    public void testValidMoveWhenTheMoveISNotValid(){
        assertFalse(Board.board[0][0].isValidMove(7, 7));
    }
    @Test
    public void testMoveMethod(){
        Board.board[1][1] = new Rook("white",1,1, true);
        Board.board[1][1].move(1,7);
    }
    @Test
    public void testValidMoveWhenTheMoveIsNotValidBecausePathIsBlocked() {
        Board.board[3][2] = new Rook("white", 3,2, false);
        assertFalse(Board.board[3][3].isValidMove(3,1));
        Board.board[3][4] = new Rook("white", 3,4, false);
        assertFalse(Board.board[3][3].isValidMove(3,5));
        Board.board[2][3] = new Rook("white", 2,3, false);
        assertFalse(Board.board[3][3].isValidMove(1,3));
        Board.board[4][3] = new Rook("white", 4,3, false);
        assertFalse(Board.board[3][3].isValidMove(5,3));
    }
}
