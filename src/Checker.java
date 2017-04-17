class Checker implements runnable{
  private Player player;
  private TicTacToe tictactoe;
  public Checker(Player player, TicTacToe tictactoe){
    this.player = player;
    this.tictactoe = tictactoe;
  }
  public void run(){
    int[][] board = tictactoe.getBoard();
    if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])){   //---------
      player.setScore();                                                      //        -
    }                                                                         //        -
    if(board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2])){   //        -
      player.setScore();                                                      //        -----> horizontal checker
    }                                                                         //        -
    if(board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])){   //        -
      player.setScore();                                                      //        -
    }                                                                         //---------

    if(board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0])){   //---------
      player.setScore();                                                      //        -
    }                                                                         //        -
    if(board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1])){   //        -
      player.setScore();                                                      //        -----> Vertical checker
    }                                                                         //        -
    if(board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2])){   //        -
      player.setScore();                                                      //        -
    }                                                                         //---------



    if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])){   //---------
      player.setScore();                                                      //        -
    }                                                                         //        -
    if(board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])){   //        -----> Diagonal Checker
      player.setScore();                                                      //        -
    }                                                                         //---------

  }
}
