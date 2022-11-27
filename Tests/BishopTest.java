import Pieces.Bishop;
import Pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BishopTest {
    public static Piece[][] board = new Piece[8][8];
    @Before
    public void initializeBishop(){
        board[4][4] = new Bishop("white", 4,4);
        board[0][2] = new Bishop("black", 0,2);
    }
    @Test
    public void testToStringMethodTWhenBishopIsWhite(){
        assertEquals("wBp",board[4][4].toString());
    }
    @Test
    public void testToStringMethodTWhenBishopIsBlack(){
        assertEquals("bBp",board[0][2].toString());
    }
    @Test
    public void testValidMoveSouthEastDiagonalWhenTheMoveIsValid(){
        assertTrue(board[4][4].isValidMove(6, 6));
    }
    @Test
    public void testValidMoveSouthWestDiagonalWhenTheMoveIsValid(){
        assertTrue(board[4][4].isValidMove(6, 2));
    }
    @Test
    public void testValidMoveNorthWestDiagonalWhenTheMoveIsValid(){
        assertTrue(board[4][4].isValidMove(0, 0));
    }
    @Test
    public void testValidMoveNorthEastDiagonalWhenTheMoveIsValid(){
        assertTrue(board[4][4].isValidMove(7, 7));
    }
    @Test
    public void testValidMoveWhenTheMoveIsNotValid(){
        assertFalse(board[4][4].isValidMove(5, 6));
    }
}
