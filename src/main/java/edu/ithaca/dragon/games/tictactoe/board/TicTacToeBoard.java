package edu.ithaca.dragon.games.tictactoe.board;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.GameStatus;

public interface TicTacToeBoard {

    public GameStatus calcGameStatus();

    //@returns true if any player can choose this square, false otherwise
    public boolean isSquareOpen(Pair<Integer, Integer> square);
    //@returns true if the given symbol (X or O) has currently won on this board
    public boolean checkForWin(char symbol);    
    
    //@throws IllegalArgumentException if square is taken or symbol is invalid
    //@post places the given symbol in the given sqaure, if both are valid
    public void setSquare(Pair<Integer, Integer> square, char symbol);
    
    //@returns a string representing the entire board for display, including coordinates
    public String displayString();
    //@returns a string of 9 characters representing each board space in row-major order
    public String buildSquaresString();
    
    //@returns a copy of the current board
    public TicTacToeBoard copyBoard();
    
}
