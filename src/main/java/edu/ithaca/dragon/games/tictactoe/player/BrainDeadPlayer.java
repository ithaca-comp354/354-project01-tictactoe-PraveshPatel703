package edu.ithaca.dragon.games.tictactoe.player;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.board.TicTacToeBoard;

public class BrainDeadPlayer implements TicTacToePlayer {

    @Override
    public Pair<Integer, Integer> chooseSquare(TicTacToeBoard curBoard, char yourSymbol) {
        for (int y=0; y<3; y++){
            for(int x=0; x<3;x++){
                if (curBoard.isSquareOpen(new Pair<>(x,y))){
                    return new Pair<>(x,y);
                }
            }
        }
        throw new IllegalArgumentException("Board with no moves given to player:\n" + curBoard.displayString());
    }

    

    
}
