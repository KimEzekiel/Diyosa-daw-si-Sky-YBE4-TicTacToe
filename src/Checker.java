class Checker{
  protected TicTacToe tictactoe;
  public Checker(TicTacToe tictactoe){
    this.tictactoe = tictactoe;
  }

  void checkPlayer(char c){
     /*adds score for the player who owns a the symbol c*/
    if(c == '0') tictactoe.getPlayers()[0].addScore();
    else if(c == 'x')tictactoe.getPlayers()[1].addScore();
  }
}
