package edu.ithaca.dragon.games.tictactoe.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.games.tictactoe.GameStatus;

public class TwoDArrayBoardTest {
    
    @Test
    public void constructorDisplayStringSetSquareTest(){
        TwoDArrayBoard board = new TwoDArrayBoard();
        assertEquals("  0 1 2 \n0       \n1       \n2       ", board.displayString());
        board.setSquare(new Pair<>(0, 0), 'X');
        board.setSquare(new Pair<>(2, 0), 'X');
        board.setSquare(new Pair<>(0, 1), 'O');
        board.setSquare(new Pair<>(2, 2), 'O');
        assertEquals("  0 1 2 \n0 X   X \n1 O     \n2     O ", board.displayString());
        //TODO: should test for bad calls to setSquare
    }

    @Test
    public void toAndFromSquaresStringTest(){
        String s1 = "XOX  XOXO";
        assertEquals(s1, new TwoDArrayBoard(s1).buildSquaresString());
        assertThrows(IllegalArgumentException.class, ()-> new TwoDArrayBoard("XXXOOOXXJ"));
        assertThrows(IllegalArgumentException.class, ()-> new TwoDArrayBoard("          "));
        assertThrows(IllegalArgumentException.class, ()-> new TwoDArrayBoard("        "));
    }

    @Test
    public void calcGameStatusTest(){
        assertEquals(GameStatus.XWIN, new TwoDArrayBoard("XXX"+
                                                         " O "+
                                                         "OO ").calcGameStatus());
        assertEquals(GameStatus.OWIN, new TwoDArrayBoard("XXO"+
                                                         "OOO"+
                                                         "XX ").calcGameStatus());
        assertEquals(GameStatus.OWIN, new TwoDArrayBoard("XXO"+
                                                         " X "+
                                                         "OOO").calcGameStatus());

        assertEquals(GameStatus.XWIN, new TwoDArrayBoard("XXO"+
                                                         "OXO"+
                                                         "OXX").calcGameStatus());
        assertEquals(GameStatus.OWIN, new TwoDArrayBoard("  O"+
                                                         " O "+
                                                         "OXX").calcGameStatus());

        assertEquals(GameStatus.XWIN, new TwoDArrayBoard("XXO"+
                                                         "XOO"+
                                                         "XX ").calcGameStatus());
        assertEquals(GameStatus.OWIN, new TwoDArrayBoard("XOX"+
                                                         " O "+
                                                         "XO ").calcGameStatus());
        assertEquals(GameStatus.TIE, new TwoDArrayBoard("XXO"+
                                                         "OOX"+
                                                         "XXO").calcGameStatus());

        assertEquals(GameStatus.PLAYING, new TwoDArrayBoard("XX  O OO ").calcGameStatus());
        assertEquals(GameStatus.PLAYING, new TwoDArrayBoard("         ").calcGameStatus());
        assertEquals(GameStatus.PLAYING, new TwoDArrayBoard("    X    ").calcGameStatus());
        assertEquals(GameStatus.PLAYING, new TwoDArrayBoard("XXO"+
                                                            "OOX"+
                                                            "XX ").calcGameStatus());

    }

    @Test
    public void onlyContainsTest(){
        assertTrue(TwoDArrayBoard.isValidSquaresString("XXXXXXXXX"));
        assertTrue(TwoDArrayBoard.isValidSquaresString("         "));
        assertTrue(TwoDArrayBoard.isValidSquaresString("XXX O OO "));
        assertFalse(TwoDArrayBoard.isValidSquaresString("XXX O OOD"));
        assertFalse(TwoDArrayBoard.isValidSquaresString("XXX O OO\n"));
        assertFalse(TwoDArrayBoard.isValidSquaresString(""));
        assertFalse(TwoDArrayBoard.isValidSquaresString("XXX O OO"));
        assertFalse(TwoDArrayBoard.isValidSquaresString("XXX O OOO "));
    }
}
