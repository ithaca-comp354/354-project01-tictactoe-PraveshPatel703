package edu.ithaca.dragon.games.tictactoe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.games.tictactoe.player.BrainDeadPlayer;

public class TicTacToeTest {

    @Test
    public void brainDeadGameTest(){
        TicTacToeGame game = new TicTacToeGame(new BrainDeadPlayer(), new BrainDeadPlayer());
        while (game.calcGameStatus() == GameStatus.PLAYING){
            game.takeTurn();
        }
        String gameResult = game.makeBoardCopy().buildSquaresString();
        assertTrue("XOXOXOX  ".equals(gameResult) || "OXOXOXO  ".equals(gameResult));
    }
    
}
