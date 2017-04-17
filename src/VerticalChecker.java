class VerticalChecker implements runnable{
  private TicTacToe tictactoe;
  public VerticalChecker(TicTacToe tictactoe){
    this.tictactoe = tictactoe;
  }
  public void run(){
    char[][] board = tictactoe.getBoard();
    if(board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0])){   //---------
      //player.setScore();                                                      //        -
    }                                                                         //        -
    if(board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1])){   //        -
      //player.setScore();                                                      //        -----> Vertical checker
    }                                                                         //        -
    if(board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2])){   //        -
      //player.setScore();                                                      //        -
    }                                                                         //---------
  }
}
