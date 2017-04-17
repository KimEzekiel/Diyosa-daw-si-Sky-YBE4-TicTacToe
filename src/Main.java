import java.util.Scanner;
public class Main{
     public static void main(String[] args){
          Player player1 = new Player(Player.P1NAME, Player.P1SYMBOL);
          Player player2 = new Player(Player.P2NAME, Player.P2SYMBOL);
          TicTacToe tictactoe = new TicTacToe(1, player1, player2);
          Scanner numScan = new Scanner(System.in);
          int x;
          int y;
          for(int i = 0; i < 9; i ++){
               System.out.println("x:")
               x = numScan.nextInt();
               System.out.println("x:")
               y = numScan.nextInt();

               
          }
     }
}
