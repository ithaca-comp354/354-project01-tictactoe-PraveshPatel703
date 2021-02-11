package edu.ithaca.dragon.games.tictactoe.player;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.board.TicTacToeBoard;
import edu.ithaca.dragon.games.tictactoe.GameStatus;

public class RuleBasedPlayer implements TicTacToePlayer {

    @Override
    public Pair<Integer, Integer> chooseSquare(TicTacToeBoard curBoard, char yourSymbol){
        int x = 0;
        int y = 0;
        if(curBoard.calcGameStatus() != GameStatus.PLAYING){
            throw new IllegalArgumentException("Board with no moves given to player:\n" + curBoard.displayString());
        }
        while(curBoard.calcGameStatus() == GameStatus.PLAYING){
            //checking to win
            //checking horizontally
            if (curBoard.checkSquare(new Pair <>(x,y)) == curBoard.checkSquare(new Pair<>(x+1,y)) && curBoard.checkSquare(new Pair <>(x,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y), yourSymbol);
                return new Pair<>(x+2,y);
            }
            if (curBoard.checkSquare(new Pair <>(x,y+1)) == curBoard.checkSquare(new Pair<>(x+1,y+1)) && curBoard.checkSquare(new Pair <>(x,y+1)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+1), yourSymbol);
                return new Pair<>(x+2,y+1);
            }
            if (curBoard.checkSquare(new Pair <>(x,y+2)) == curBoard.checkSquare(new Pair<>(x+1,y+2)) && curBoard.checkSquare(new Pair <>(x,y+2)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+2), yourSymbol);
                return new Pair<>(x+2,y+2);
            }
            if(curBoard.checkSquare(new Pair<>(x,y)) == curBoard.checkSquare(new Pair<>(x+2,y)) && curBoard.checkSquare(new Pair <>(x,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y), yourSymbol);
                return new Pair<>(x+1,y);
            }
            if(curBoard.checkSquare(new Pair<>(x,y+1)) == curBoard.checkSquare(new Pair<>(x+2,y+1)) && curBoard.checkSquare(new Pair <>(x,y+1)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y+1), yourSymbol);
                return new Pair<>(x+1,y+1);
            }
            if(curBoard.checkSquare(new Pair<>(x,y+2)) == curBoard.checkSquare(new Pair<>(x+2,y+2)) && curBoard.checkSquare(new Pair <>(x,y+2)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y+2), yourSymbol);
                return new Pair<>(x+1,y+2);
            }

            //checking vertically 
            if (curBoard.checkSquare(new Pair<>(x,y)) == curBoard.checkSquare(new Pair<>(x,y+1)) && curBoard.checkSquare(new Pair <>(x,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x,y+2), yourSymbol);
                return new Pair<>(x,y+2);
            }
            if (curBoard.checkSquare(new Pair<>(x+1,y)) == curBoard.checkSquare(new Pair<>(x+1,y+1)) && curBoard.checkSquare(new Pair <>(x+1,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y+2), yourSymbol);
                return new Pair<>(x+1,y+2);
            }
            if (curBoard.checkSquare(new Pair<>(x+2,y)) == curBoard.checkSquare(new Pair<>(x+2,y+1)) && curBoard.checkSquare(new Pair <>(x+2,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+2), yourSymbol);
                return new Pair<>(x+2,y+2);
            }
            if(curBoard.checkSquare(new Pair<>(x,y)) == curBoard.checkSquare(new Pair<>(x,y+2)) && curBoard.checkSquare(new Pair <>(x,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x,y+1), yourSymbol);
                return new Pair<>(x,y+1);
            }
            if(curBoard.checkSquare(new Pair<>(x+1,y)) == curBoard.checkSquare(new Pair<>(x+1,y+2)) && curBoard.checkSquare(new Pair <>(x+1,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y+1), yourSymbol);
                return new Pair<>(x+1,y+1);
            }
            if(curBoard.checkSquare(new Pair<>(x+2,y)) == curBoard.checkSquare(new Pair<>(x+2,y+2)) && curBoard.checkSquare(new Pair <>(x+2,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+1), yourSymbol);
                return new Pair<>(x+2,y+1);
            }

            //checks diagonally (left to right)
            if (curBoard.checkSquare(new Pair<>(x,y)) == curBoard.checkSquare(new Pair<>(x+1,y+1)) && curBoard.checkSquare(new Pair <>(x,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+2), yourSymbol);
                return new Pair<>(x+2,y+2);
            }
            //checks diagonally (right to left)
            if (curBoard.checkSquare(new Pair<>(x+2,y)) == curBoard.checkSquare(new Pair<>(x+1,y+1)) && curBoard.checkSquare(new Pair <>(x+2,y)) == yourSymbol){
                curBoard.setSquare(new Pair<>(x,y+2), yourSymbol);
                return new Pair<>(x,y+2);
            }

            //checking to block 
            //checking horizontally 
            if (curBoard.checkSquare(new Pair <>(x,y)) == curBoard.checkSquare(new Pair<>(x+1,y)) && curBoard.checkSquare(new Pair <>(x,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y), yourSymbol);
                return new Pair<>(x+2,y);
            }
            if (curBoard.checkSquare(new Pair <>(x,y+1)) == curBoard.checkSquare(new Pair<>(x+1,y+1)) && curBoard.checkSquare(new Pair <>(x,y+1)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+1), yourSymbol);
                return new Pair<>(x+2,y+1);
            }
            if (curBoard.checkSquare(new Pair <>(x,y+2)) == curBoard.checkSquare(new Pair<>(x+1,y+2)) && curBoard.checkSquare(new Pair <>(x,y+2)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+2), yourSymbol);
                return new Pair<>(x+2,y+2);

            }
            if(curBoard.checkSquare(new Pair<>(x,y)) == curBoard.checkSquare(new Pair<>(x+2,y)) && curBoard.checkSquare(new Pair <>(x,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y), yourSymbol);
                return new Pair<>(x+1,y);
            }
            if(curBoard.checkSquare(new Pair<>(x,y+1)) == curBoard.checkSquare(new Pair<>(x+2,y+1)) && curBoard.checkSquare(new Pair <>(x,y+1)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y+1), yourSymbol);
                return new Pair<>(x+1,y+1);
            }
            if(curBoard.checkSquare(new Pair<>(x,y+2)) == curBoard.checkSquare(new Pair<>(x+2,y+2)) && curBoard.checkSquare(new Pair <>(x,y+2)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y+2), yourSymbol);
                return new Pair<>(x+1,y+2);
            }

            //checking vertically 
            if (curBoard.checkSquare(new Pair<>(x,y)) == curBoard.checkSquare(new Pair<>(x,y+1)) && curBoard.checkSquare(new Pair <>(x,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x,y+2), yourSymbol);
                return new Pair<>(x,y+2);

            }
            if (curBoard.checkSquare(new Pair<>(x+1,y)) == curBoard.checkSquare(new Pair<>(x+1,y+1)) && curBoard.checkSquare(new Pair <>(x+1,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y+2), yourSymbol);
                return new Pair<>(x+1,y+2);

            }
            if (curBoard.checkSquare(new Pair<>(x+2,y)) == curBoard.checkSquare(new Pair<>(x+2,y+1)) && curBoard.checkSquare(new Pair <>(x+2,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+2), yourSymbol);
                return new Pair<>(x+2,y+2);

            }
            if(curBoard.checkSquare(new Pair<>(x,y)) == curBoard.checkSquare(new Pair<>(x,y+2)) && curBoard.checkSquare(new Pair <>(x,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x,y+1), yourSymbol);
                return new Pair<>(x,y+1);
            }
            if(curBoard.checkSquare(new Pair<>(x+1,y)) == curBoard.checkSquare(new Pair<>(x+1,y+2)) && curBoard.checkSquare(new Pair <>(x+1,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+1,y+1), yourSymbol);
                return new Pair<>(x+1,y+1);
            }
            if(curBoard.checkSquare(new Pair<>(x+2,y)) == curBoard.checkSquare(new Pair<>(x+2,y+2)) && curBoard.checkSquare(new Pair <>(x+2,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+1), yourSymbol);
                return new Pair<>(x+2,y+1);
            }

            //checks diagonally (left to right)
            if (curBoard.checkSquare(new Pair<>(x,y)) == curBoard.checkSquare(new Pair<>(x+1,y+1)) && curBoard.checkSquare(new Pair <>(x,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x+2,y+2), yourSymbol);
                return new Pair<>(x+2,y+2);
            }
            //checks diagonally (right to left)
            if (curBoard.checkSquare(new Pair<>(x+2,y)) == curBoard.checkSquare(new Pair<>(x+1,y+1)) && curBoard.checkSquare(new Pair <>(x+2,y)) != yourSymbol){
                curBoard.setSquare(new Pair<>(x,y+2), yourSymbol);
                return new Pair<>(x,y+2);
            }
            //else if no above conditions are met, just place symbol anywhere possible 
            for (y=0; y<3; y++){
                for(x=0; x<3;x++){
                    if (curBoard.isSquareOpen(new Pair<>(x,y))){
                        curBoard.setSquare(new Pair<>(x,y), yourSymbol);
                        return new Pair<>(x,y);
                    }
                }
            }
            curBoard.calcGameStatus();
        }
        return null;
    }
}
    
