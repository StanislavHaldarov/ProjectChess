import MenuAndBoard.Board;
import Pieces.Queen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {

    @Before
    public void initializeBishop() {
        Board.board[4][4] = new Queen("white", 4, 4);
        Board.board[3][4] = new Queen("black", 4, 4);
    }
    @Test
    public void testMoveMethod(){
        Board.board[0][0] = new Queen("white", 0,0);
        Board.board[0][0].move(1,0);
        assertTrue(Board.board[1][0] instanceof Queen);
    }
    @Test
    public void testToStringMethodTWhenQueenIsWhite() {
        assertEquals("wQn", Board.board[4][4].toString());
    }

    @Test
    public void testToStringMethodTWhenQueenIsBlack() {
        assertEquals("bQn", Board.board[3][4].toString());
    }

    @Test
    public void testValidMoveSouthDirectionWhenTheMoveIsValid() {
        assertTrue(Board.board[4][4].isValidMove(7, 4));
    }

    @Test
    public void testValidMoveNorthDirectionWhenTheMoveIsValid() {
        assertTrue(Board.board[4][4].isValidMove(3, 4));
    }

    @Test
    public void testValidMoveEastDirectionWhenTheMoveIsValid() {
        assertTrue(Board.board[4][4].isValidMove(4, 7));
    }

    @Test
    public void testValidMoveWestDirectionWhenTheMoveIsValid() {
        assertTrue(Board.board[4][4].isValidMove(4, 0));
    }

    @Test
    public void testValidMoveNorthEastDirectionWhenTheMoveIsValid() {
        assertTrue(Board.board[4][4].isValidMove(1, 7));
    }

    @Test
    public void testValidMoveNorthWestDirectionWhenTheMoveIsValid() {
        assertTrue(Board.board[4][4].isValidMove(0, 0));
    }

    @Test
    public void testValidMoveSouthEastDirectionWhenTheMoveIsValid() {
        assertTrue(Board.board[4][4].isValidMove(7, 7));
    }

    @Test
    public void testValidMoveSouthWestDirectionWhenTheMoveIsValid() {
        assertTrue(Board.board[4][4].isValidMove(7, 1));
    }
    @Test
    public void testValidMoveWhenTheMoveIsNotValid() {
        assertFalse(Board.board[4][4].isValidMove(4, 4));
        assertFalse(Board.board[4][4].isValidMove(6,5));
        assertFalse(Board.board[4][4].isValidMove(2,3));
        assertFalse(Board.board[4][4].isValidMove(1,6));
        assertFalse(Board.board[4][4].isValidMove(7,2));
    }
}
