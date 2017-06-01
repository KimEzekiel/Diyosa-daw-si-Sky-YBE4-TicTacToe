package game;
public class HorizontalChecker extends Checker implements Runnable{

  public HorizontalChecker( TicTacToe tictactoe){
      super(tictactoe);
  }
  public void run(){
    char[][] board = tictactoe.getBoard();
    int i;
    for(i = 0; i < 3; i++){
      if(board[i][0] == (board[i][1]) && board[i][0] == (board[i][2])){
        checkPlayer(board[i][0]);
     //    break;
      }
    }
  }
}
