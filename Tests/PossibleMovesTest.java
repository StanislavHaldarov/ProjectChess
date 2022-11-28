import Movements.PossibleMove;
import Pieces.*;
import org.junit.Test;
import MenuAndBoard.Board;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
public class PossibleMovesTest {
    @Test
    public void testPossibleMoveMethods()
    {
        PossibleMove testMove = new PossibleMove(1,0,2,1,10);
        Board.board[2][1] = new Pawn("white",2,1,false,1);
        Board.initializeStartingBoard();
        ArrayList<PossibleMove> testMoves = new ArrayList<>();
        ArrayList<PossibleMove> nonCheckMoves = new ArrayList<>();
        PossibleMove.addPossibleMoves(testMoves,Board.blackPieces,nonCheckMoves,false);
        for (PossibleMove move:nonCheckMoves) {
            if(move.equals(testMove))
            {
                assertEquals(testMove,move);
            }
        }
    }
}
