import Pieces.Knight;
import Pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class KnightTest {
    public static Piece[][] board = new Piece[8][8];
    @Before
    public void initializeBishop(){
        board[4][4] = new Knight("white", 4,4);
        board[2][1] = new Knight("white", 2,1);
    }
    @Test
    public void testToStringMethodTWhenKnightIsWhite(){
        assertEquals("wKn",board[4][4].toString());
    }
    @Test
    public void testToStringMethodTWhenKnightIsBlack(){
        assertEquals("wKn",board[4][4].toString());
    }
    @Test
    public void testValidMoveWhenTheMoveIsValid(){
        assertTrue(board[4][4].isValidMove(2,3));
        assertTrue(board[2][1].isValidMove(0,0));
    }
    @Test
    public void testValidMoveWhenTheMoveIsNotValid(){
        assertFalse(board[4][4].isValidMove(5,7));
        assertFalse(board[2][1].isValidMove(3,2));
    }
}
