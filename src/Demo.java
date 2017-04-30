
public class Demo{
     /*
     This class is a clas for testing things out.
     */
     public static void main(String[] args){
          Player player1 = new Player("Player 1",Player.P1SYMBOL);
          Player player2 = new Player("Player 2", Player.P2SYMBOL);
          TicTacToe tictactoe = new TicTacToe(9,player1,player2);
          Board newBoard = new Board("Checkers", tictactoe);
     }
}
