package edu.ithaca.dragon.games.tictactoe.player;

import java.util.Scanner;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.GameStatus;
import edu.ithaca.dragon.games.tictactoe.board.TicTacToeBoard;

public class HumanPlayer implements TicTacToePlayer {
    private Scanner keyboard = new Scanner(System.in);

    @Override
    public Pair<Integer, Integer> chooseSquare(TicTacToeBoard curBoard, char yourSymbol) {
        if (curBoard.calcGameStatus() != GameStatus.PLAYING){
            throw new IllegalArgumentException("No valid moves");
        }
        else {
            System.out.print(yourSymbol + ", enter coorinates for your next move x,y:");
            String coordString = keyboard.nextLine();
            while (readAndVerifyCoords(coordString) == null){
                System.out.print("bad coordinates, try again, format x,y:");
                coordString = keyboard.nextLine();
            }
            return readAndVerifyCoords(coordString);
        }
    }

    public static Pair<Integer, Integer> readAndVerifyCoords(String coordString){
        //TODO: needs error checking, shoud return null if input is invalid
        String[] coords = coordString.split(",");
        return new Pair<>(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]));
    }
    
}
