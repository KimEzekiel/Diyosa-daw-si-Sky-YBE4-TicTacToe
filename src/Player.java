package game;
public class Player{
     public static final String P1NAME = "Player 1";
     public static final char P1SYMBOL = 'o';
     public static final String P2NAME = "Player 2";
     public static final char P2SYMBOL = 'x';
     public static final char EMPTY = ' ';
     private String name;;
     private char boardSymbol;
     private int score;
     private TicTacToe tictactoe;
     private String  buttonText;

     public Player(String name, char symbol){
          this.name = name;
          this.boardSymbol = symbol;
          this.buttonText = Character.toString(symbol);
          this.score = 0;

     }
     /*Getters*/
     public String getName(){
          return this.name;
     }
     public char getBoardSymbol(){
          return this.boardSymbol;
     }
     public TicTacToe getTicTacToe(){
          return this.tictactoe;
     }
     public String getButtonText(){
          return this.buttonText;
     }
     public int getScore(){
          return this.score;
     }
     /*Setters*/
     public void setName(String name){
          this.name = name;
     }
     public void setBoardSymbol(char symbol){
          this.boardSymbol = symbol;
     }
     public void setTicTacToe(TicTacToe tictactoe){
          this.tictactoe = tictactoe;
     }
     public void addScore(){
       this.score++;
     }
     public void mark(int x, int y){
          if(this.tictactoe.getBoard()[x][y] == Player.EMPTY){  //check if empty cell
               this.tictactoe.getBoard()[x][y] = this.boardSymbol;
               //this.tictactoe.setCurrentTurn(1);
          }
          else System.out.println("cannot move there");
          //get the coordinate
          //check if empty
     }
}
