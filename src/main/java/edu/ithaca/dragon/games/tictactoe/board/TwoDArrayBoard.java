package edu.ithaca.dragon.games.tictactoe.board;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.GameStatus;

public class TwoDArrayBoard implements TicTacToeBoard{
    private char[][] squares;

    public TwoDArrayBoard(){
        squares = new char[3][3];
        for (int y=0; y<3; y++){
            for(int x=0; x<3;x++){
               squares[x][y] = ' ';
            }
            
        }
    }

    public TwoDArrayBoard(String squaresString){
        if (!isValidSquaresString(squaresString)){
            throw new IllegalArgumentException("Bad squareString:" + squaresString);
        }
        squares = new char[3][3];
        int strIndex=0;
        for (int y=0; y<3; y++){
            for(int x=0; x<3;x++){
               squares[x][y] = squaresString.charAt(strIndex++);
            } 
        }
    }

    @Override
    public TicTacToeBoard copyBoard(){
        return new TwoDArrayBoard(this.buildSquaresString());
    }

    @Override
    public boolean isSquareOpen(Pair<Integer, Integer> square) {
		return squares[square.getValue0()][square.getValue1()] == ' ';
	}

    @Override
    public void setSquare(Pair<Integer, Integer> square, char symbol){
        if (isValidSquareValue(symbol) && isSquareOpen(square)){
            squares[square.getValue0()][square.getValue1()] = symbol;
        }
        else {
            throw new IllegalArgumentException("Bad symbol or square: " + symbol);
        }
    }

    @Override
    public GameStatus calcGameStatus(){
        if (checkForWin('X')){
            return GameStatus.XWIN;
        }
        else if (checkForWin('O')){
            return GameStatus.OWIN;
        }
        else if (anyOpenSquares()){
            return GameStatus.PLAYING;
        }
        else {
            return GameStatus.TIE;
        }
    }

    public static boolean isValidSquareValue(char squareValue){
        return "XO ".indexOf(squareValue)!=-1;
    }

    public static boolean isValidSquaresString(String strToCheck){
        if (strToCheck.length() != 9){
            return false;
        }
        else {
            for(char charToCheck : strToCheck.toCharArray()){
                if (!isValidSquareValue(charToCheck)){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public String buildSquaresString(){
        String boardStr = "";
        for (int y=0; y<3; y++){
            for(int x=0; x<3;x++){
                boardStr +=squares[x][y];
            } 
        }
        return boardStr;
    }

    @Override
    public String displayString(){
        String boardStr = "  ";
        for (int x=0; x<3; x++){
            boardStr += x + " ";
        }
        for (int y=0; y<3; y++){
            boardStr += "\n" + y + " ";
            for(int x=0; x<3;x++){
                boardStr +=squares[x][y] + " ";
            } 
        }
        return boardStr;
    }

    private boolean anyOpenSquares() {
       return buildSquaresString().indexOf(' ') != -1;
    }

    @Override
    public boolean checkForWin(char symbol){
        //check horizontal
        for(int y=0; y<3; y++){
            if (squares[0][y] == symbol && squares[1][y] == symbol && squares[2][y] == symbol ){
                return true;
            }
        }
        //check vertical
        for(int x=0; x<3; x++){
            if (squares[x][0] == symbol && squares[x][1] == symbol && squares[x][2] == symbol ){
                return true;
            }
        }
        //check diagonals
        if (squares[0][0] == symbol && squares[1][1] == symbol && squares[2][2] == symbol ){
            return true;
        }
        if (squares[2][0] == symbol && squares[1][1] == symbol && squares[0][2] == symbol ){
            return true;
        }
        return false;
    }

}
