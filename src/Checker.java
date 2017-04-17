class Checker{
  protected TicTacToe tictactoe;
  public Checker(TicTacToe tictactoe){
    this.tictactoe = tictactoe;
  }

  void checkPlayer(char c){
    if(c == 'o') tictactoe.getPlayers()[0].addScore();
    else if(c == 'x')tictactoe.getPlayers()[1].addScore();
  }
}
