import java.util.Scanner;
public class Main{
     public static void main(String[] args){
          Player player1 = new Player(Player.P1NAME, Player.P1SYMBOL);
          Player player2 = new Player(Player.P2NAME, Player.P2SYMBOL);
          TicTacToe tictactoe = new TicTacToe(1, player1, player2);
          Scanner numScan = new Scanner(System.in);
          int x;
          int y;
          System.out.println(tictactoe.getCurrentRound());
          for(int i = 0; i < 9; i ++){
            Thread hChecker = new Thread(new HorizontalChecker(tictactoe));
            Thread vChecker = new Thread(new VerticalChecker(tictactoe));
            Thread dChecker = new Thread(new DiagonalChecker(tictactoe));
            hChecker.start();
            vChecker.start();
            dChecker.start();

            System.out.println("x:");
            x = numScan.nextInt();
            System.out.println("y:");
            y = numScan.nextInt();
            tictactoe.playerMoves(x,y);
            tictactoe.printBoard(
            try{ //problem here hindi nagraraun ung thread.join i dont know wh   hChecker.join();
              System.out.println("ok");
              vChecker.join();
              System.out.println("ok");
              dChecker.join();
              System.out.println("ok");
            }catch(Exception e){
              System.out.println("Interrupted at join.");
            }
           System.out.println("Score Player 1: " + player1.getScore());
           System.out.println("Score Player 2: " + player2.getScore());
          }
   }
}
