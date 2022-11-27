import Pieces.*;
import org.junit.Test;
import MenuAndBoard.Board;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class KingTest {
    @Before
    public void initializeKing()
    {
        Board.board[4][4] = new King("white",4,4,false);
        Board.board[0][4] = new King("black",0,4,true);
    }
    @Test
    public void testToStringMethod()
    {
        assertEquals("wK ", Board.board[4][4].toString());
        assertEquals("bK ", Board.board[0][4].toString());
    }
    @Test
    public void testKingNorthwestValidMoves()
    {
        //when the direction cords is null
        assertTrue(Board.board[4][4].isValidMove(3,3));
        //when the direction cords has an enemy piece there
        Board.board[3][3] = new Pawn("black",3,3,false,1);
        assertTrue(Board.board[4][4].isValidMove(3,3));
        //when the direction cords has a piece from the same color
        Board.board[3][3] = new Pawn("white",3,3,false,1);
        assertFalse(Board.board[4][4].isValidMove(3,3));
        //when coordinates are wrong
        assertFalse(Board.board[4][4].isValidMove(2,2));

    }
    @Test
    public void testKingNorthValidMoves()
    {
        assertTrue(Board.board[4][4].isValidMove(3,4));
        Board.board[3][4] = new Pawn("black",3,4,false,1);
        assertTrue(Board.board[4][4].isValidMove(3,4));
        Board.board[3][4] = new Pawn("white",3,4,false,1);
        assertFalse(Board.board[4][4].isValidMove(3,4));
        assertFalse(Board.board[4][4].isValidMove(2,4));

    }

    @Test
    public void testKingNortheastValidMoves()
    {
        assertTrue(Board.board[4][4].isValidMove(3,5));
        Board.board[3][5] = new Pawn("black",3,5,false,1);
        assertTrue(Board.board[4][4].isValidMove(3,5));
        Board.board[3][5] = new Pawn("white",3,5,false,1);
        assertFalse(Board.board[4][4].isValidMove(3,5));
        assertFalse(Board.board[4][4].isValidMove(2,6));
    }
    @Test
    public void testKingWestValidMoves()
    {

        assertTrue(Board.board[4][4].isValidMove(4,3));
        Board.board[4][3] = new Pawn("black",4,3,false,1);
        assertTrue(Board.board[4][4].isValidMove(4,3));
        Board.board[4][3] = new Pawn("white",4,3,false,1);
        assertFalse(Board.board[4][4].isValidMove(4,3));
        assertFalse(Board.board[4][4].isValidMove(4,2));
    }
    @Test
    public void testKingEastValidMoves()
    {
        assertTrue(Board.board[4][4].isValidMove(4,5));
        Board.board[4][5] = new Pawn("black",4,5,false,1);
        assertTrue(Board.board[4][4].isValidMove(4,5));
        Board.board[4][5] = new Pawn("white",4,5,false,1);
        assertFalse(Board.board[4][4].isValidMove(4,5));
        assertFalse(Board.board[4][4].isValidMove(4,6));
    }
    @Test
    public void testKingSouthwestValidMoves()
    {
        assertTrue(Board.board[4][4].isValidMove(5,3));
        Board.board[5][3] = new Pawn("black",5,3,false,1);
        assertTrue(Board.board[4][4].isValidMove(5,3));
        Board.board[5][3] = new Pawn("white",5,3,false,1);
        assertFalse(Board.board[4][4].isValidMove(5,3));
        assertFalse(Board.board[4][4].isValidMove(6,2));
    }
    @Test
    public void testKingSouthValidMoves()
    {
        assertTrue(Board.board[4][4].isValidMove(5,4));
        Board.board[5][4] = new Pawn("black",5,4,false,1);
        assertTrue(Board.board[4][4].isValidMove(5,4));
        Board.board[5][4] = new Pawn("white",5,4,false,1);
        assertFalse(Board.board[4][4].isValidMove(5,4));
        assertFalse(Board.board[4][4].isValidMove(6,4));
    }
    @Test
    public void testKingSoutheastValidMoves()
    {
        assertTrue(Board.board[4][4].isValidMove(5,5));
        Board.board[5][5] = new Pawn("black",5,5,false,1);
        assertTrue(Board.board[4][4].isValidMove(5,5));
        Board.board[5][5] = new Pawn("white",5,5,false,1);
        assertFalse(Board.board[4][4].isValidMove(5,5));
        assertFalse(Board.board[4][4].isValidMove(6,6));
    }
    @Test
    public void testCastling()
    {
        Board.board[0][0] = new Rook("black",0,0,true);
        Board.board[0][7] = new Rook("black",0,7,true);
        assertTrue(Board.board[0][4].isValidMove(0,2));
        assertTrue(Board.board[0][4].isValidMove(0,6));
        //when Rook doesn't have first move
        Board.board[0][0] = new Rook("black",0,0,false);
        Board.board[0][7] = new Rook("black",0,7,false);
        assertFalse(Board.board[0][4].isValidMove(0,2));
        assertFalse(Board.board[0][4].isValidMove(0,6));
        //when King doesn't have first move
        Board.board[0][4] = new King("black",0,4,false);
        assertFalse(Board.board[0][4].isValidMove(0,2));
        assertFalse(Board.board[0][4].isValidMove(0,6));
        //when there are pieces blocking the path
        Board.board[0][1] = new Pawn("black",0,1,true,2);
        Board.board[0][6] = new Pawn("white",0,6,true,7);
        assertFalse(Board.board[0][4].isValidMove(0,2));
        assertFalse(Board.board[0][4].isValidMove(0,6));
    }
    @Test
    public void testMoveMethod(){
        Board.board[7][1] = new King("black",7,1,false);
        Board.board[7][1].move(7,2);
        assertTrue(Board.board[7][2] instanceof King);
    }
}
