package edu.ithaca.dragon.games.tictactoe.player;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.board.TicTacToeBoard;

public interface TicTacToePlayer {

    /**
     * @param curBoard a copy of the current board for the player to use to choose a square
     * @param yourSymbol the symbol of the player that needs to choose a square
     * @throws IllegalArgumentException if there is no avialable squares to choose
     * @return a Pair of (x,y) coordinates representing the square chosen
     */
    public Pair<Integer, Integer> chooseSquare(TicTacToeBoard curBoard, char yourSymbol);

}
