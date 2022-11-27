import MenuAndBoard.Board;
import Pieces.Bishop;
import Pieces.Pawn;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BishopTest {
    @Before
    public void initializeBishop(){
        Board.board[4][4] = new Bishop("white", 4,4);
    }
    @Test
    public void testToStringMethodTWhenBishopIsWhite() {
        assertEquals("wBp", Board.board[4][4].toString());
    }

    @Test
    public void testToStringMethodTWhenBishopIsBlack() {
        Board.board[0][2] = new Bishop("black", 0, 2);
        assertEquals("bBp", Board.board[0][2].toString());
    }

    @Test
    public void testValidMoveSouthEastDiagonalWhenTheMoveIsValid() {
        Board.board[5][4] = new Bishop("white", 5, 4);
        assertTrue(Board.board[5][4].isValidMove(7, 6));
    }

    @Test
    public void testValidMoveSouthWestDiagonalWhenTheMoveIsValid() {
        Board.board[6][3] = new Bishop("white", 6, 3);
        assertTrue(Board.board[6][3].isValidMove(7, 2));
    }

    @Test
    public void testValidMoveNorthWestDiagonalWhenTheMoveIsValid() {
        Board.board[4][5] = new Bishop("white", 4, 5);
        assertTrue(Board.board[4][5].isValidMove(3, 4));
    }

    @Test
    public void testValidMoveNorthEastDiagonalWhenTheMoveIsValid() {
        Board.board[1][3] = new Bishop("white", 1, 3);
        assertTrue(Board.board[1][3].isValidMove(0, 4));
    }

    @Test
    public void testValidMoveIsNotValid() {
        assertFalse(Board.board[4][4].isValidMove(4, 4));
    }

    @Test
    public void testValidMoveCheckNorthDiagonalsIsNotValid() {
        assertFalse(Board.board[4][4].isValidMove(3, 4));
        assertFalse(Board.board[4][4].isValidMove(5, 4));
    }

    @Test
    public void testValidMoveWhenTheMoveIsNotValid() {
        assertFalse(Board.board[4][4].isValidMove(5, 6));
    }
    @Test
    public void testValidMoveWhenTheMoveIsNotValidBecausePathIsBlocked() {
        Board.board[2][2] = new Pawn("white", 2, 2, false, 1);
        Board.board[2][6] = new Pawn("white", 2, 6, false, 1);
        Board.board[6][2] = new Pawn("white", 6, 2, false, 1);
        Board.board[6][6] = new Pawn("white", 6, 6, false, 1);

        assertFalse(Board.board[4][4].isValidMove(1, 1));
        assertFalse(Board.board[4][4].isValidMove(1, 1));
        assertFalse(Board.board[4][4].isValidMove(1, 7));
        assertFalse(Board.board[4][4].isValidMove(7, 1));
        assertFalse(Board.board[4][4].isValidMove(7, 7));
    }
    @Test
    public void testMoveMethod(){
        Board.board[4][4].move(1,7);
        assertTrue(Board.board[1][7] instanceof Bishop);
    }
    @Test
    public void testValidMoveNortheastIfThereIsAPieceFromTheOtherTeamOnMoveCoordinates(){
        Board.board[7][0] = new Bishop("white", 7,0);
        Board.board[2][5] = new Bishop("black", 2,5);
        assertTrue(Board.board[7][0].isValidMove(2,5));
    }
    @Test
    public void testValidMoveNorthwestIfThereIsAPieceFromTheOtherTeamOnMoveCoordinates(){
        Board.board[3][2] = new Bishop("white", 3,2);
        Board.board[1][0] = new Bishop("black", 1,0);
        assertTrue(Board.board[3][2].isValidMove(1,0));
    }
    @Test
    public void testValidMoveSouthwestIfThereIsAPieceFromTheOtherTeamOnMoveCoordinates(){
        Board.board[0][7] = new Bishop("white", 0,7);
        Board.board[7][0] = new Bishop("black", 7,0);
        assertTrue(Board.board[0][7].isValidMove(7,0));
    }
    @Test
    public void testValidMoveSoutheastIfThereIsAPieceFromTheOtherTeamOnMoveCoordinates(){
        Board.board[6][5] = new Bishop("white", 6,5);
        Board.board[7][6] = new Bishop("black", 7,6);
        assertTrue(Board.board[6][5].isValidMove(7,6));
    }
}