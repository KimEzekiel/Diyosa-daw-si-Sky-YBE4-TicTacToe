
class Checker{
  	protected TicTacToe tictactoe;
  		public Checker(TicTacToe tictactoe){
		this.tictactoe = tictactoe;
	}

	void checkPlayer(char c){
	/*adds score for the player who owns a the symbol c*/
    	if(c == Player.P1SYMBOL){
		tictactoe.getPlayers()[0].addScore();
		System.out.println("player1 got a point");
	}
	else if(c == Player.P2SYMBOL ){
		tictactoe.getPlayers()[1].addScore();
		System.out.println("player2 got a point");
	}
	this.tictactoe.justGotPoint = true;
	// this.tictactoe.nextRound();
	// this.tictactoe.nextRound();
  	}
}
