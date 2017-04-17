class VerticalChecker implements runnable{
  private TicTacToe tictactoe;
  public VerticalChecker(TicTacToe tictactoe){
    this.tictactoe = tictactoe;
  }
  public void run(){
    char[][] board = tictactoe.getBoard();
    int i;
    for(i = 0; i < 3; i++){
      if(board[0][i] == (board[1][i]) && board[0][i] == (board[2][i])){
        //player.setScore();
      }
    }
  }
}
