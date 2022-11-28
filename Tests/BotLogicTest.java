import MenuAndBoard.Menu;
import Movements.BotLogic;
import Movements.PossibleMove;
import Pieces.*;
import org.junit.Test;
import MenuAndBoard.Board;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
public class BotLogicTest {
    @Test
    public void testStrategicBotMakeMove()
    {
        PossibleMove testMove = new PossibleMove(3,3,4,4,10);
        Board.board[3][3] = new Pawn("black",3,3,false,1);
        Board.board[4][4] = new Pawn("white",4,4,false,1);
        Board.initializeStartingBoard();
        PossibleMove botMove = BotLogic.makeMove(false);
        if(botMove!=null) {
            if (botMove.equals(testMove)) {
                assertEquals(testMove, botMove);
            }
        }
    }
    @Test
    public void testRandomBotMakeMove()
    {
        PossibleMove randomMove;
        Board.initializeStartingBoard();
        PossibleMove botMove = BotLogic.makeMove(true);
        randomMove = botMove;
        assertEquals(botMove,randomMove);

    }
    @Test
    public void testIfCheckmate()
    {
        Board.board[0][7] = new King("black",0,7,false);
        Board.board[2][7] = new Queen("white",2,7);
        Board.board[0][5] = new Rook("white",0,5,false);
        PossibleMove botMove = BotLogic.makeMove(true);
        assertNull(botMove);

    }
}
