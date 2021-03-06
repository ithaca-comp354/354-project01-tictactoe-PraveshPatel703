package edu.ithaca.dragon.games.tictactoe.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.games.tictactoe.board.TwoDArrayBoard;

public class TicTacToePlayerTest {
    
    @Test
    public void chooseSquareTest(){
        RuleBasedPlayer player = new RuleBasedPlayer();
        assertEquals(new Pair<>(0,0), player.chooseSquare(new TwoDArrayBoard("         "), 'X'));
        assertEquals(new Pair<>(0, 2), player.chooseSquare(new TwoDArrayBoard("XXOXOO   "), 'X'));
        assertEquals(new Pair<>(2, 2), player.chooseSquare(new TwoDArrayBoard(
            "X X" +
            "OOX" +
            "XX "), 'O'));
        
        assertThrows(IllegalArgumentException.class, ()-> player.chooseSquare(new TwoDArrayBoard("OOXOOXXXX"), 'O'));
    }
}
