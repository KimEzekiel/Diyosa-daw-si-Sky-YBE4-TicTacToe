class DiagonalChecker implements runnable{
  private TicTacToe tictactoe;
  public DiagonalChecker(TicTacToe tictactoe){
      this.tictactoe = tictactoe;
  }
  public void run(){
    char[][] board = tictactoe.getBoard();
    if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])){   //---------
      //player.setScore();                                                    //        -
    }                                                                         //        -
    if(board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])){   //        -----> Diagonal Checker
      //player.setScore();                                                    //        -
    }                                                                         //---------
  }
}
