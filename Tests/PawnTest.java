import MenuAndBoard.Board;
import Pieces.Pawn;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class PawnTest {



    @Before
    public void initializePawns() {
        Board.board[6][1] = new Pawn("white", 6, 1, true, 0);
        Board.board[3][1] = new Pawn("black", 3, 1, false, 1);

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

    public void testToStringMethod() {
        assertEquals("wPn", Board.board[6][1].toString());
        assertEquals("bPn", Board.board[3][1].toString());

    public void testToStringMethodTWhenPawnIsBlack() {
        assertEquals("bPn", Board.board[3][0].toString());
    }

    @Test
    public void testIsValidMoveOneStepForwardWhenTheMoveIsValid(){

        assertTrue(Board.board[6][1].isValidMove(5,1));
        assertTrue(Board.board[3][1].isValidMove(4,1));
    }
    @Test
    public void testIsValidMoveTwoStepForwardWhenTheMoveIsValid(){
        assertTrue(Board.board[6][1].isValidMove(4,1));
        Board.board[3][3] = new Pawn("black", 3, 3, true, 0);
        assertTrue(Board.board[3][3].isValidMove(5,3));
    }
    @Test
    public void testIsValidMoveDiagonalMoveWhenTheMoveIsValid(){
        Board.board[4][0] = new Pawn("white",4,0,false,1);
        Board.board[4][2] = new Pawn("white",4,2,false,1);
        Board.board[5][0] = new Pawn("black",5,0,false,1);
        Board.board[5][2] = new Pawn("black",5,2,false,1);
        assertTrue(Board.board[6][1].isValidMove(5,0));
        assertTrue(Board.board[3][1].isValidMove(4,0));
        assertTrue(Board.board[6][1].isValidMove(5,2));
        assertTrue(Board.board[3][1].isValidMove(4,2));
    }
    @Test
    public void testIsValidMoveEnPassantWhenTheMoveIsValid(){
        Board.board[3][2] = new Pawn("white",3,2,false,2);
        Board.board[3][3] = new Pawn("black", 3, 3, false, 1);
        assertTrue(Board.board[3][2].isValidMove(2,1));
        assertTrue(Board.board[3][2].isValidMove(2,3));
        Board.board[3][2].move(2,1);
        assertNull(Board.board[3][1]);
    }
    @Test
    public void testWhitePawnIsValidMoveIfPathIsBlocked(){
        //when pawn's front square is blocked by a piece
        Board.board[6][3] = new Pawn("white",6,3,true,0);
        Board.board[5][3] = new Pawn("white",5,3,false,2);
        assertFalse(Board.board[6][3].isValidMove(5,3));
        assertFalse(Board.board[6][3].isValidMove(4,3));
        Board.board[3][6] = new Pawn("black",3,6,true,0);
        Board.board[4][6] = new Pawn("black",4,6,false,2);
        assertFalse(Board.board[3][6].isValidMove(4,6));
        assertFalse(Board.board[3][6].isValidMove(5,6));
        //when pawn's second front square is blocked by a piece
        Board.board[4][3] = new Pawn("black",4,3,false,2);
        assertFalse(Board.board[6][3].isValidMove(4,3));
        Board.board[5][6] = new Pawn("white",5,6,false,2);
        assertFalse(Board.board[3][6].isValidMove(5,6));
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

    @Test
    public void testWhenMoveIsNotValid(){
        //when the move coordinates lead to null diagonals
        assertFalse(Board.board[6][1].isValidMove(5,0));
        assertFalse(Board.board[6][1].isValidMove(5,2));
        assertFalse(Board.board[3][1].isValidMove(4,0));
        assertFalse(Board.board[3][1].isValidMove(4,2));
        //when the move coordinates lead backwards(pawns cannot behave that way)
        assertFalse(Board.board[6][1].isValidMove(7,1));
        assertFalse(Board.board[3][1].isValidMove(2,1));
        //when the pawn is doing double step move, but that isn't first move
        Board.board[6][6] = new Pawn("white",6,6,false,1);
        assertFalse(Board.board[6][6].isValidMove(4,6));
        Board.board[3][6] = new Pawn("black",3,6,false,1);
        assertFalse(Board.board[3][6].isValidMove(5,6));
        //when diagonal paths are blocked by a piece from the same color
        Board.board[5][0] =new Pawn("white",5,0,false,2);
        Board.board[5][2] =new Pawn("white",5,2,false,2);
        assertFalse(Board.board[6][1].isValidMove(5,0));
        assertFalse(Board.board[6][1].isValidMove(5,2));
        Board.board[4][0] =new Pawn("black",4,0,false,2);
        Board.board[4][2] =new Pawn("black",4,2,false,2);
        assertFalse(Board.board[3][1].isValidMove(4,0));
        assertFalse(Board.board[3][1].isValidMove(4,2));
    }
    @Test
    public void testBlackPawnPromote()
    {
        Board.board[6][6] = new Pawn("black", 6, 6, false, 5);
        Board.board[6][6].move(7,6);
        assertTrue(Board.board[7][6] instanceof Queen);
    }
    @Test
    public void testMoveMethod(){
        Board.board[2][1] = new Pawn("white",2,1,true,0);
        Board.board[2][1].move(1,1);
        assertTrue(Board.board[1][1] instanceof Pawn);
    }
}
