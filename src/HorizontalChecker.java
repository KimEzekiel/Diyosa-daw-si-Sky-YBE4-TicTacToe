class HorizontalChecker implements runnable{
  private TicTacToe tictactoe;
  public HorizontalChecker( TicTacToe tictactoe){
      this.tictactoe = tictactoe;
  }
  void run(){
    char[][] board = tictactoe.getBoard();
    if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])){   //---------
      //player.setScore();                                                      //        -
    }                                                                         //        -
    if(board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2])){   //        -
      //player.setScore();                                                      //        -----> horizontal checker
    }                                                                         //        -
    if(board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])){   //        -
      //player.setScore();                                                      //        -
    }                                                                         //---------
  }
}
