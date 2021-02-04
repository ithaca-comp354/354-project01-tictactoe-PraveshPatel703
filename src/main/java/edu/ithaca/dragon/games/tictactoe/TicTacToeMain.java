package edu.ithaca.dragon.games.tictactoe;

import edu.ithaca.dragon.games.tictactoe.player.BrainDeadPlayer;
import edu.ithaca.dragon.games.tictactoe.player.HumanPlayer;

public class TicTacToeMain {
    public static void main (String[] args){
        new TicTacToeGame( new HumanPlayer(), new BrainDeadPlayer()).play();
    }
    
}
