package game;
public class VerticalChecker extends Checker implements Runnable{

  public VerticalChecker(TicTacToe tictactoe){
    super(tictactoe);
  }
  public void run(){
    char[][] board = tictactoe.getBoard();
    int i;
    for(i = 0; i < 3; i++){
      if(board[0][i] == (board[1][i]) && board[0][i] == (board[2][i])){
        checkPlayer(board[0][i]);

     //    break;
      }
    }
  }
}
