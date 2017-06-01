import java.util.Scanner;
import game.*;
public class Demo{

     public static void main(String[] args){
          Scanner numScan = new Scanner(System.in);
          int rounds;

          Player player1 = new Player("Player 1",Player.P1SYMBOL);
          Player player2 = new Player("Player 2", Player.P2SYMBOL);
          System.out.print("Input no. of rounds: ");
          rounds = numScan.nextInt();
          TicTacToe tictactoe = new TicTacToe(rounds ,player1,player2);
     }
}
