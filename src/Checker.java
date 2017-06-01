package game;
public class Checker{
  	protected TicTacToe tictactoe;
  		public Checker(TicTacToe tictactoe){
		this.tictactoe = tictactoe;
	}

	void checkPlayer(char c){
	/*adds score for the player who owns a the symbol c*/

	if(c != ' '){
		switch(c){
			case Player.P1SYMBOL:
				tictactoe.getPlayers()[0].addScore();
                    this.tictactoe.getGui().updateScore(0);
                    break;
			case Player.P2SYMBOL:
				tictactoe.getPlayers()[1].addScore();
                    this.tictactoe.getGui().updateScore(1);
				break;
			default:
				break;
		}
		this.tictactoe.nextRound();
		this.tictactoe.getGui().resetButtons();
	    }

  	}
}
