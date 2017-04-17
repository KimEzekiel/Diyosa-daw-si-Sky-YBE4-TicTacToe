class Player{
     public static final String P1NAME = "Player 1";
     public static final char P1SYMBOL = 'x';
     public static final String P2NAME = "Player 2";
     public static final char P2SYMBOL = 'o';

     private String name;;
     private char boardSymbol;
     private int score;
     private TicTacToe tictactoe;

     public Player(String name, char symbol){
          this.name = name;
          this.boardSymbol = symbol;
          this.score = 0;
     }
     /*Getters*/
     public String getName(){
          return this.name;
     }
     public char getBoardSymbol(){
          return this.boardSymbol;
     }
     public int getScore(){
          return this.score;
     }
     public TicTacToe getTicTacToe(){
          return this.tictactoe;
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
     /**/
     /* */
     public void mark(int x, int y){
          if(this.tictactoe.getBoard()[x][y] == ' '){  //check if empty cell
               this.tictactoe.getBoard()[x][y] = this.boardSymbol;
          }
          else System.out.println("cannot move there");
          //get the coordinate
          //check if empty
     }
}
