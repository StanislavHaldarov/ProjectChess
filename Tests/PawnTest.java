import MenuAndBoard.Board;
import Pieces.Pawn;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class PawnTest {

    @Before
    public void initializePawns() {
        Board.board[6][0] = new Pawn("white", 6, 0, true, 0);
        Board.board[3][0] = new Pawn("black", 3, 0, false, 1);
        Board.board[3][1] = new Pawn("white",3,1,false,2);
        Board.board[6][6] = new Pawn("black", 6, 6, false, 5);
    }
    @Test
    public void testToStringMethodTWhenPawnIsWhite() {
        assertEquals("wPn", Board.board[6][0].toString());
    }

    @Test
    public void testToStringMethodTWhenPawnIsBlack() {
        assertEquals("bPn", Board.board[3][0].toString());
    }

    @Test
    public void testIsValidMoveOneStepForwardWhenTheMoveIsValid(){
        assertTrue(Board.board[6][0].isValidMove(5,0));
        assertTrue(Board.board[3][0].isValidMove(4,0));
    }
    @Test
    public void testIsValidMoveTwoStepForwardWhenTheMoveIsValid(){
        assertTrue(Board.board[6][0].isValidMove(4,0));
    }
    @Test
    public void testIsValidMoveEnPassantWhenTheMoveIsValid(){
        assertTrue(Board.board[3][1].isValidMove(2,0));
    }
    @Test
    public void testIsValidMoveWhenTheMoveIsNotValid(){
        assertFalse(Board.board[6][0].isValidMove(7,0));
        assertFalse(Board.board[3][0].isValidMove(4,1));
    }

}
