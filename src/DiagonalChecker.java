class DiagonalChecker extends Checker implements Runnable{

  public DiagonalChecker(TicTacToe tictactoe){
      super(tictactoe);
  }
  public void run(){
    char[][] board = tictactoe.getBoard();
    if(board[0][0] == (board[1][1]) && board[0][0] == (board[2][2])){ // somebody got a point
     checkPlayer(board[0][0]);
     // this.tictactoe.
    }
    if(board[2][0] == (board[1][1]) && board[2][0] == (board[0][2])){ // somebody got a point
      checkPlayer(board[2][0]);
    }
  }
}
