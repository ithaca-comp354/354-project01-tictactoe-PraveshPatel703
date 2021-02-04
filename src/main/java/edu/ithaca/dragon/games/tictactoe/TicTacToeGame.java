package edu.ithaca.dragon.games.tictactoe;

import java.util.Random;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.board.TicTacToeBoard;
import edu.ithaca.dragon.games.tictactoe.board.TwoDArrayBoard;
import edu.ithaca.dragon.games.tictactoe.player.TicTacToePlayer;

public class TicTacToeGame {
    private static Random random = new Random();

    private TicTacToeBoard board;
    private TicTacToePlayer xPlayer;
    private TicTacToePlayer oPlayer;
    private char turn;

    public TicTacToeGame (TicTacToeBoard board, TicTacToePlayer xPlayer, TicTacToePlayer oPlayer){
        this.board = board.copyBoard();
        this.xPlayer = xPlayer;
        this.oPlayer = oPlayer;
        if (random.nextInt(2) == 1){
            turn = 'X';
        }
        else {
            turn='O';
        }
    }

    public TicTacToeGame (TicTacToePlayer xPlayer, TicTacToePlayer oPlayer){
        this(new TwoDArrayBoard(), xPlayer, oPlayer);
    }

    public void play(){
        while (board.calcGameStatus() == GameStatus.PLAYING){
            System.out.println(board.displayString());
            takeTurn();
        }
        System.out.println(board.displayString());
        System.out.println(board.calcGameStatus());
    }

    public void takeTurn(){
        if (turn == 'X'){
            makeMove(xPlayer, turn);
            turn = 'O';
        }
        else if (turn == 'O'){
            makeMove(oPlayer, turn);
            turn = 'X';
        }
        else {
            throw new RuntimeException("Bad value for turn:"  + turn);
        }
    }

    private void makeMove(TicTacToePlayer player, char symbol){
        Pair<Integer, Integer> square = player.chooseSquare(makeBoardCopy(), symbol);
        if(board.isSquareOpen(square)){
            board.setSquare(square, symbol);
        }
    }

    public TicTacToeBoard makeBoardCopy(){
        return board.copyBoard();
    }

    public GameStatus calcGameStatus(){
        return board.calcGameStatus();
    } 

}
