import Pieces.Rook;
import Pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class RookTest {
    public static Piece[][] board = new Piece[8][8];
    @Before
    public void initializeBishop(){
        board[0][0] = new Rook("white", 0,0, true);
        board[7][7] = new Rook("black", 7,7, false);
        board[0][7] = new Rook("white", 0,7, true);
        board[7][0] = new Rook("white", 7,0, true);
    }
    @Test
    public void testToStringMethodTWhenRookIsWhite(){
        assertEquals("wRk",board[0][0].toString());
    }
    @Test
    public void testToStringMethodTWhenRookIsBlack(){
        assertEquals("bRk",board[7][7].toString());
    }
    @Test
    public void testValidMoveDirectionYEastWhenTheMoveIsValid(){
        assertTrue(board[0][0].isValidMove(0, 7));
    }
    @Test
    public void testValidMoveDirectionYWestWhenTheMoveIsValid(){
        assertTrue(board[0][7].isValidMove(0, 0));
    }
    @Test
    public void testValidMoveDirectionXSouthWhenTheMoveIsValid(){
        assertTrue(board[0][0].isValidMove(7, 0));
    }
    @Test
    public void testValidMoveDirectionXNorthWhenTheMoveIsValid(){
        assertTrue(board[7][7].isValidMove(0, 7));
    }
    @Test
    public void testValidMoveWhenTheMoveISNotValid(){
        assertFalse(board[0][0].isValidMove(7, 7));
    }
}
