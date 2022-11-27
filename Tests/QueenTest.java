import Pieces.Queen;
import Pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {
    public static Piece[][] board = new Piece[8][8];

    @Before
    public void initializeBishop() {
        board[4][4] = new Queen("white", 4, 4);
        board[3][4] = new Queen("black", 4, 4);
    }

    @Test
    public void testToStringMethodTWhenQueenIsWhite() {
        assertEquals("wQn", board[4][4].toString());
    }

    @Test
    public void testToStringMethodTWhenQueenIsBlack() {
        assertEquals("bQn", board[3][4].toString());
    }

    @Test
    public void testValidMoveSouthDirectionWhenTheMoveIsValid() {
        assertTrue(board[4][4].isValidMove(7, 4));
    }

    @Test
    public void testValidMoveNorthDirectionWhenTheMoveIsValid() {
        assertTrue(board[4][4].isValidMove(0, 4));
    }

    @Test
    public void testValidMoveEastDirectionWhenTheMoveIsValid() {
        assertTrue(board[4][4].isValidMove(4, 7));
    }

    @Test
    public void testValidMoveWestDirectionWhenTheMoveIsValid() {
        assertTrue(board[4][4].isValidMove(4, 0));
    }

    @Test
    public void testValidMoveNorthEastDirectionWhenTheMoveIsValid() {
        assertTrue(board[4][4].isValidMove(1, 7));
    }

    @Test
    public void testValidMoveNorthWestDirectionWhenTheMoveIsValid() {
        assertTrue(board[4][4].isValidMove(0, 0));
    }

    @Test
    public void testValidMoveSouthEastDirectionWhenTheMoveIsValid() {
        assertTrue(board[4][4].isValidMove(7, 7));
    }

    @Test
    public void testValidMoveSouthWestDirectionWhenTheMoveIsValid() {
        assertTrue(board[4][4].isValidMove(7, 1));
    }
}
