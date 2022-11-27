import MenuAndBoard.Board;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PawnTest {
    public static Piece[][] board = new Piece[8][8];

    @Before
    public void initializePawns() {
        board[6][0] = new Pawn("white", 6, 0, true, 0);
        board[3][0] = new Pawn("black", 3, 0, false, 1);
        board[3][1] = new Pawn("white",3,1,false,2);
        board[6][6] = new Pawn("black", 6, 6, false, 5);
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
    public void testIsValidMoveOneStepForwardWhenTheMoveIsValid(){
        assertTrue(board[6][0].isValidMove(5,0));
        assertTrue(board[3][0].isValidMove(4,0));
    }
    @Test
    public void testIsValidMoveTwoStepForwardWhenTheMoveIsValid(){
        assertTrue(board[6][0].isValidMove(4,0));
    }
    @Test
    public void testIsValidMoveEnPassantWhenTheMoveIsValid(){
        assertFalse(board[3][1].isValidMove(2,0));
    }
    @Test
    public void testIsValidMoveWhenTheMoveIsNotValid(){
        assertFalse(board[6][0].isValidMove(7,0));
        assertFalse(board[3][0].isValidMove(4,1));
    }

}
