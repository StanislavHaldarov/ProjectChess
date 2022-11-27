import MenuAndBoard.Board;
import Pieces.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KnightTest {
    @Before
    public void initializeBishop() {
        Board.board[4][4] = new Knight("white", 4, 4);
        Board.board[2][1] = new Knight("black", 2, 1);
    }

    @Test
    public void testToStringMethodTWhenKnightIsWhite() {
        assertEquals("wKn", Board.board[4][4].toString());
    }

    @Test
    public void testToStringMethodTWhenKnightIsBlack() {
        assertEquals("bKn", Board.board[2][1].toString());
    }

    @Test
    public void testValidMoveWhenTheMoveIsValid() {
        Board.board[2][3] = new Knight("black", 2, 3);
        assertTrue(Board.board[4][4].isValidMove(2, 3));
        assertTrue(Board.board[2][1].isValidMove(0, 0));
    }

    @Test
    public void testValidMoveWhenTheMoveIsNotValid() {
        Board.board[5][7] = new Knight("white", 5, 7);
        assertFalse(Board.board[4][4].isValidMove(5, 7));
        assertFalse(Board.board[2][1].isValidMove(3, 2));
    }

    @Test
    public void testMoveMethod() {
        Board.board[0][0] = new Knight("white", 0, 0);
        Board.board[0][0].move(1, 2);
        assertTrue(Board.board[1][2] instanceof Knight);
    }
}