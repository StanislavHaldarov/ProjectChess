import Pieces.Pawn;
import Pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PawnTest {
    public static Piece[][] board = new Piece[8][8];

    @Before
    public void initializeBishop() {
        board[6][0] = new Pawn("white", 6, 0, true, 0);
        board[3][0] = new Pawn("black", 3, 0, false, 1);
    }
    @Test
    public void testToStringMethodTWhenPawnIsWhite() {
        assertEquals("wPn", board[6][0].toString());
    }

    @Test
    public void testToStringMethodTWhenPawnIsBlack() {
        assertEquals("bPn", board[3][0].toString());
    }

    @Test
    public void testisValidMoveOneStepForwardWhenTheMoveIsValid(){
        assertTrue(board[6][0].isValidMove(5,3));
    }
}
