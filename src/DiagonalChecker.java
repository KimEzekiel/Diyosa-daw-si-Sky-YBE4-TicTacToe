class DiagonalChecker extends Checker implements runnable{
  public DiagonalChecker(Player player, TicTacToe tictactoe){
    super(player,tictactoe);
  }
  public void run(){                                                                
    if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])){   //---------
      player.setScore();                                                      //        -
    }                                                                         //        -
    if(board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])){   //        -----> Diagonal Checker
      player.setScore();                                                      //        -
    }                                                                         //---------
  }
}
